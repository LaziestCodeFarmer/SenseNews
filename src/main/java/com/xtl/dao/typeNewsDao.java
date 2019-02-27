package com.xtl.dao;

import com.xtl.mapper.indexMapper;
import com.xtl.mapper.typeNewsMapper;
import com.xtl.pojo.article;
import com.xtl.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

//新闻分类数据获取层
@Repository
public class typeNewsDao {

    public SqlSession ss = mybatisUtils.getSqlSession();
    typeNewsMapper mapper = ss.getMapper(typeNewsMapper.class);

    //搜索新闻数据返回
    public article[] searchNewsByType(String type,Integer n, Integer m){
        return mapper.searchNewsByType(type,n,m);
    }


}
