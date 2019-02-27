package com.xtl.dao;

import com.xtl.mapper.articleMapper;
import com.xtl.pojo.article;
import com.xtl.pojo.articleStatus;
import com.xtl.pojo.userMessage;
import com.xtl.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

//新闻展示
@Repository
public class articleDao {

    public SqlSession ss = mybatisUtils.getSqlSession();
    articleMapper mapper = ss.getMapper(articleMapper.class);

    //返回该篇新闻具体信息
    public com.xtl.pojo.article getArticleByAid(Integer aId){
        return mapper.getArticleByAid(aId);
    }
    //获取该新闻情况
    public articleStatus getarticleStatusByAid(Integer aId){
        return mapper.getarticleStatusByAid(aId);
    }
    //获取用户/作者信息
    public userMessage getuserMessageByAuthor(String author){
        return mapper.getuserMessageByAuthor(author);
    }
    //发表过的总文章
    public Integer getnewSumByAuthor(String author){
        return mapper.getnewSumByAuthor(author);
    }
    //最近发表的一篇文章
    public article getLastArticleByAuthor(String author){
        return mapper.getLastArticleByAuthor(author);
    }
    //获取用户uId
    public Integer getuIdByUserName(String userName){
        return new Integer(mapper.getuIdByUserName(userName));
    }
    //搜索该用户对该新闻是否已收藏
    public Integer IsCollect(Integer aId,Integer uId){
        return mapper.IsCollect(aId,uId);
    }


    //实现收藏功能：
    //根据传过来的uId，aId对articleEvaluate进行操作，在进行添加时，先检查是否已存在记录，如果存在则直接修改即可
    public Boolean IsExist(int uId,int aId){
       return mapper.IsExist(uId,aId);
    }
    public void setCollected(int uId,int aId){
        mapper.setCollected(uId,aId);
        ss.commit();
    }
    public void updateCollected(int uId,int aId ){
        mapper.updateCollected(uId,aId);
        ss.commit();
    }
    //判断该新闻是否在articleStatus有记录
    public Boolean IsExist2(int aId){
        return mapper.IsExist2(aId);
    }
    //创建记录
    public void setStatus(int aId){
        mapper.setStatus(aId);
        ss.commit();
    }
    public void updateStatus(int aId){
        mapper.updateStatus(aId);
        ss.commit();
    }



    //取消收藏
    //修改用户收藏
    public void backCollectEvaluate(int uId,int aId){
        mapper.backCollectEvaluate(uId,aId);
    }
    //修改新闻总收藏
    public void backCollectStatus(int aId){
        mapper.backCollectStatus(aId);
    }


    //通过点击作者名

    //通过点击作者名字，列出该作者所写过的新闻
    public article[] searchNewsByAuthor(String author,Integer n,Integer m){
        return mapper.searchNewsByAuthor(author,n,m);
    }

}
