package com.xtl.service;

import com.xtl.dao.indexDao;
import com.xtl.pojo.article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//首页新闻展览
@Service
public class indexService {

    @Autowired
    indexDao indexdao;

    //首页推荐和分类数据

    public article[] getArticle(String type) throws ParseException {
        article[] articles = indexdao.getArticle(type);
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
