package com.xtl.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xtl.mapper.userMapper;
import com.xtl.pojo.article;
import com.xtl.pojo.userMessage;
import com.xtl.utils.mybatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
//访问数据库层
//主要针对user操作
@Repository
public class userDao {

    public SqlSession ss = mybatisUtils.getSqlSession();
    userMapper mapper = ss.getMapper(userMapper.class);

    //添加账号
    public Boolean adduserAccount(String account, String password, String supperPassword){
        return mapper.adduserAccount(account, password, supperPassword);
    }
    //添加账号用户信息
    public Boolean adduserMessage(String userName){
        return mapper.adduserMessage(userName);
    }


    //账号登录
    public Integer login(String account,String password){
        return mapper.login(account,password);
    }

    //获取账号个人信息
    public userMessage getUserMessage(int uId){
        return mapper.getUserMessage(uId);
    }


}
