package com.xtl.mapper;

import com.xtl.pojo.article;
import org.apache.ibatis.annotations.Param;

//新闻分类展览模块
public interface typeNewsMapper {

    public article[] searchNewsByType(@Param("type")String type,@Param("n")Integer n,@Param("m")Integer m);


}
