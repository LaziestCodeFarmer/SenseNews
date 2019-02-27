package com.xtl.controller;

import com.xtl.dao.indexDao;
import com.xtl.mapper.userMapper;
import com.xtl.pojo.article;
import com.xtl.pojo.userMessage;
import com.xtl.service.indexService;
import com.xtl.service.userService;
import com.xtl.utils.MD5;
import com.xtl.utils.mybatisUtils;
import org.apache.ibatis.javassist.bytecode.ByteArray;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//用户相关操作
@Controller
public class userController {

    @Autowired
    userService userservice;
    @Autowired
    indexService indexservice;

    @RequestMapping("/aaa")
    public String aaa(){
        return "test";
    }


    //首页
    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {

        //2.Cookie自动登录操作
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            String account = null;
            String password= null;
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("account")){
                    account = cookie.getValue();
                }
                if(cookie.getName().equals("password")){
                    password = cookie.getValue();
                }
            }
            //登录
            if(account!=null&&password!=null){
                userMessage userMessage = userservice.login(account, password);
                if(userMessage!=null){
                    //获取session，如果服务器中有该session，则直接获取，如果不存在，则创建新的
                    HttpSession session = request.getSession();
                    session.setAttribute("userMessage",userMessage);
                }
            }
        }

        //首页新闻展览数据
        //数据有：推荐、科技(tech)、财经(finance)、国际(world)、军事(mil)、娱乐(ent)
        article[] recommends = indexservice.getArticle(null);
        article[] techs = indexservice.getArticle("tech");
        article[] finances = indexservice.getArticle("finance");
        article[] worlds = indexservice.getArticle("world");
        article[] mils = indexservice.getArticle("mil");
        article[] ents = indexservice.getArticle("ent");
        model.addAttribute("recommends",recommends);
        model.addAttribute("techs",techs);
        model.addAttribute("finances",finances);
        model.addAttribute("worlds",worlds);
        model.addAttribute("mils",mils);
        model.addAttribute("ents",ents);
        return "index";
    }



    //用户注册
    @RequestMapping("/regist")
    public void regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //这里不检测账号，在前端用json检测账号是否可用

        //获取用户注册信息
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String supperPassword = request.getParameter("supperPassword");

        //账号注册
        Boolean regist = userservice.regist(account, password, supperPassword);
        //注册成功
        if(regist) {
            request.getRequestDispatcher("login").forward(request,response);
        }
        //失败
        else{
            System.out.println("注册失败");
        }

        //注册成功后，转发到login模块
        //没指定名的话，默认是返回regist.jsp页面



    }

    //用户登录
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //获取账号、密码、是否记住2周内自动登录
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String autologin = request.getParameter("autologin");


        //1.普通登录
        if(account!=null&&password!=null){
            userMessage userMessage = userservice.login(account, password);
            //userMessage不为空，表明登录成功,同时获取账号的个人用户信息添加用session中
            if(userMessage!=null){
                //获取session，如果服务器中有该session，则直接获取，如果不存在，则创建新的
                HttpSession session = request.getSession();
                session.setAttribute("userMessage",userMessage);
            }
            //记忆
            if(autologin!=null){
                //账号
                Cookie accountCookie = new Cookie("account", account);
                //设置2周存活时间：14*24*60*60
                accountCookie.setMaxAge(14*24*60*60);
                //设置作用域
                accountCookie.setPath("/");
                //客户端保存
                response.addCookie(accountCookie);

                //密码
                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setMaxAge(14*24*60*60);
                passwordCookie.setPath("/");
                response.addCookie(passwordCookie);
            }
            //登录成功后，转发到/首页
            request.getRequestDispatcher("/").forward(request,response);
            return;
        }
    }
    //用户注销
    @RequestMapping("/loginOut")
    public void loginOut(HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println("正在注销");
        //注销session会话，同时检测是否保存了账号密码cookie,有的话进行删除，
        HttpSession session = request.getSession();
        session.setAttribute("userMessage",null);

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("account")){
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if(cookie.getName().equals("password")){
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        request.getRequestDispatcher("/").forward(request,response);
    }
}


