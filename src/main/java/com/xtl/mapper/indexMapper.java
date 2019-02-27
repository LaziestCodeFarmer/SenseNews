package com.xtl.mapper;

import com.xtl.pojo.article;
import org.apache.ibatis.annotations.Param;
//首页相关
public interface indexMapper {

    //首页新闻展览
    public article[] getArticle(@Param("type")String type);

}
