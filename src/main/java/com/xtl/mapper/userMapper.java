package com.xtl.mapper;

import com.xtl.pojo.userMessage;
import org.apache.ibatis.annotations.Param;

public interface userMapper {

    //添加账号（Account）userAccount
    public Boolean adduserAccount(@Param("account")String account,
                              @Param("password")String password,
                              @Param("supperPassword")String supperPassword);


    //添加账号成功的话，进一步添加账号的用户信息
    public Boolean adduserMessage(@Param("userName")String userName);



    //账号登录
    public Integer login(@Param("account")String account,@Param("password")String password);

    //获取账号的个人信息
    public userMessage getUserMessage(@Param("uId") int uId);


}
