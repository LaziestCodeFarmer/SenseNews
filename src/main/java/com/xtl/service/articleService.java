package com.xtl.service;

import com.xtl.dao.articleDao;
import com.xtl.pojo.article;
import com.xtl.pojo.articleStatus;
import com.xtl.pojo.userMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//新闻展示
@Service
public class articleService {

    @Autowired
    articleDao articledao;
    //获取新闻具体信息
    public article getArticleByAid(Integer aId) throws ParseException {
        article article =  articledao.getArticleByAid(aId);
        Date nowdate = new Date();
        String newdateStr = article.getDataTime();
        if(newdateStr.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}.0")){
            newdateStr = newdateStr.substring(0,article.getDataTime().length()-2);
            article.setDataTime(newdateStr);
        };
        Date newdate;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            newdate  = sdf.parse(newdateStr);
        }catch (Exception e){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            newdate = sdf.parse(newdateStr);
        }
        long nowd = nowdate.getTime();
        long newd = newdate.getTime();
        long show = (nowd-newd)/1000/60;//表示间隔多少分钟
        //分三种显示:
        //第一种：1小时之前。如果show<60，则显示show之前，如：1分钟之前
        if(show<60){
            article.setIndexTimeShow(show+1+"分钟之前");
        }
        //第二种：24小时之前，如果show>60&&show<3600
        else if(show>60&&show<60*24){
            article.setIndexTimeShow((show/60)+1+"小时之前");
        }
        //其他的直接显示日期
        else{
            article.setIndexTimeShow(article.getDataTime());
        }
        return article;
    }

    //获取新闻情况
    public articleStatus getarticleStatusByAid(Integer aId){
        return articledao.getarticleStatusByAid(aId);
    }
    //获取用户/作者信息
    public userMessage getuserMessageByAuthor(String author){
        return articledao.getuserMessageByAuthor(author);
    }
    //发表过的总文章
    public Integer getnewSumByAuthor(String author){
        return articledao.getnewSumByAuthor(author);
    }
    //最近发表的一篇文章
    public article getLastArticleByAuthor(String author){
        return articledao.getLastArticleByAuthor(author);
    }
    //获取用户uId
    public Integer getuIdByUserName(String userName){
        return articledao.getuIdByUserName(userName);
    }
    //搜索该用户对该新闻是否已收藏
    public Integer IsCollect(Integer aId,Integer uId){
        if(articledao.IsCollect(aId,uId)!=null){
            return articledao.IsCollect(aId,uId);
        }
        return null;
    }


    //实现收藏功能：
    //根据传过来的uId，aId对articleEvaluate进行操作，在进行添加时，先检查是否已存在记录，如果存在则直接修改即可
    public void collect(int uId, int aId){
        //不存在则创建，同时该新闻的收藏数加一
        if(articledao.IsExist(uId,aId)==null){
            articledao.setCollected(uId, aId);
        }
        //如果存在，则直接修改collected=1
        else {
            articledao.updateCollected(uId,aId);
        }


        //同时该新闻的收藏数加一,先判断是否有记录（articleStatus）
        if(articledao.IsExist2(aId)==null){
            //创建记录，同时让collected属性=1
            articledao.setStatus(aId);
        }
        //如果存在，则令collected+1
        else{
            articledao.updateStatus(aId);
        }
    }

    //取消收藏
    public void backCollect(int uId,int aId){
        articledao.backCollectEvaluate(uId,aId);
        articledao.backCollectStatus(aId);
    }


    //通过点击作者名字，列出该作者所写过的新闻
    public article[] searchNewsByAuthor(String author,Integer n,Integer m) throws ParseException {
        article[] articles = articledao.searchNewsByAuthor(author,n,m);
        //数据处理（跟首页的数据处理一样）
        //遍历article[]数组，从context文本中筛选出img存到article对象的imgUrl
        for(article article : articles){
            //情况1：<img src=":
            //情况2：<img alt="" src="
            String startStr = "<img src=\"";
            String endStr = "\"";
            int start = article.getContext().indexOf(startStr);
            int end;
            if(start==-1){
                startStr = "<img alt=\"\" src=\"";
                start = article.getContext().indexOf(startStr);
            }
            end = article.getContext().indexOf(endStr,start+startStr.length());
            if(start!=-1&&end!=-1){
                String imgUrl = article.getContext().substring(start + startStr.length(), end);
                article.setImgUrl(imgUrl);
            }
            else{
                article.setImgUrl("./images/3172135363.jpg");
            }


            //首页新闻时间显示如：1分钟前
            //当前时间
            Date nowdate = new Date();
            //新闻发布时间
            //时间格式修改，因为爬数据存储时，有些数据是：2019-01-27 16:09:00.0，修改成：2019-01-27 16:09:00
            String newdateStr = article.getDataTime();
            if(newdateStr.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}.0")){
                newdateStr = newdateStr.substring(0,article.getDataTime().length()-2);
                article.setDataTime(newdateStr);
            };
            Date newdate;
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                newdate  = sdf.parse(newdateStr);
            }catch (Exception e){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                newdate = sdf.parse(newdateStr);
            }
            long nowd = nowdate.getTime();
            long newd = newdate.getTime();
            long show = (nowd-newd)/1000/60;//表示间隔多少分钟
            //分三种显示:
            //第一种：1小时之前。如果show<60，则显示show之前，如：1分钟之前
            if(show<60){
                article.setIndexTimeShow(show+1+"分钟之前");
            }
            //第二种：24小时之前，如果show>60&&show<3600
            else if(show>60&&show<60*24){
                article.setIndexTimeShow((show/60)+1+"小时之前");
            }
            //其他的直接显示日期
            else{
                article.setIndexTimeShow(article.getDataTime());
            }
        }
        return articles;
    }

}
