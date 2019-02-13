package com.xtl.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * 单例mybatis会话工具类
 */
@Component
public class mybatisUtils {

    public void m1(){
        System.out.println("测试");
    }

    private static SqlSessionFactory ssf = null;
    static {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatisconfig.xml");
            ssf = new SqlSessionFactoryBuilder().build(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return ssf.openSession();
    }
}
