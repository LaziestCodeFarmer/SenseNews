package com.xtl.mapper;

import com.xtl.pojo.article;
import com.xtl.pojo.articleStatus;
import com.xtl.pojo.userMessage;
import org.apache.ibatis.annotations.Param;

//新闻展示
public interface articleMapper {

    //获取该新闻信息
    public article getArticleByAid(Integer aId);
    //根据aId获取该新闻情况
    public articleStatus getarticleStatusByAid(Integer aId);
    //获取作者信息
    public userMessage getuserMessageByAuthor(String author);
    //发表过的总文章
    public Integer getnewSumByAuthor(String author);
    //最近发表的一篇文章
    public article getLastArticleByAuthor(String author);
    //获取用户uId
    public Integer getuIdByUserName(String userName);
    //搜索该用户对该新闻是否已收藏
    public Integer IsCollect(@Param("aId") Integer aId, @Param("uId") Integer uId);

    //实现收藏功能：
    //根据传过来的uId，aId对articleEvaluate进行操作，在进行添加时，先检查是否已存在记录，如果存在则直接修改即可
    public Boolean IsExist(@Param("uId")int uId,@Param("aId")int aId);
    public void setCollected(@Param("uId")int uId,@Param("aId")int aId);
    public void updateCollected(@Param("uId")int uId,@Param("aId")int aId);
    //判断是否有记录（articleStatus）
    public Boolean IsExist2(int aId);
    public void setStatus(int aId);
    public void updateStatus(int aId);

    //实现取消收藏
    public void backCollectEvaluate(@Param("uId")int uId,@Param("aId")int aId);
    public void backCollectStatus(@Param("aId")int aId);


    //通过点击作者名字，列出该作者所写过的新闻
    public article[] searchNewsByAuthor(@Param("author") String author,@Param("n")Integer n,@Param("m")Integer m);

}
