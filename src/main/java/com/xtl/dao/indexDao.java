package com.xtl.dao;

import com.xtl.mapper.indexMapper;
import com.xtl.pojo.article;
import com.xtl.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

//首页数据返回
@Repository
public class indexDao {

    public SqlSession ss = mybatisUtils.getSqlSession();
    indexMapper mapper = ss.getMapper(indexMapper.class);

    //首页展览推荐和分类数据

    public article[] getArticle(String type){
        return mapper.getArticle(type);
    }

}
