package com.xtl.service;

import com.xtl.dao.userDao;
import com.xtl.pojo.userMessage;
import com.xtl.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//业务层
//主要针对账号用户业务处理
@Service
public class userService {


    @Autowired
    userDao userdao;


    //注册账号
    public Boolean regist(String account, String password, String supperPassword) throws Exception{
        //添加账号
        //先加密码进行加密
        password = MD5.md5(password);
        if(userdao.adduserAccount(account,password,supperPassword)){
            //添加账号用户信息
            if(userdao.adduserMessage(account)){
                //都成功，将事务进行提交
                userdao.ss.commit();
                //这是单例模式
                //userdao.ss.close();
                return true;
            }
        }
        return false;
    }

    //账号登录,同时返回账号个人信息进行返回
    public userMessage login(String account, String password) throws Exception {
        //将密码进行MD5解析
        password = MD5.md5(password);
        Integer uId = userdao.login(account, password);
        //uId不等于0，则表明登录成功，同时返回该用户的uId，再通过uId获取该用户的个人信息
        if(uId!=null){
            return userdao.getUserMessage(uId);
        }
        return null;
    }


}
