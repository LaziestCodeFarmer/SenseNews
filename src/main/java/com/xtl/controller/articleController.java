package com.xtl.controller;

import com.xtl.pojo.article;
import com.xtl.pojo.articleStatus;
import com.xtl.pojo.userMessage;
import com.xtl.service.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
public class articleController {
    @Autowired
    articleService articleservice;

    @RequestMapping("article")
    public String a (HttpServletRequest request, Model model) throws ParseException {

        int aId = new Integer(request.getParameter("aId"));
        //1.根据aId获取该新闻具体信息，封装到model返回
        article article = articleservice.getArticleByAid(aId);
        model.addAttribute("article",article);

        //2.根据aId从articleStatus表中，获取该新闻的情况，比如收藏数，点赞数
        articleStatus status =  articleservice.getarticleStatusByAid(aId);
        model.addAttribute("status",status);

        //3.从article中得到author，根据author从userMessage表中，获取作者/用户信息
        userMessage usermessage = articleservice.getuserMessageByAuthor(article.getAuthor());
        model.addAttribute("usermessage",usermessage);

        //4.根据author从article中统计该作者所发表过的新闻总量
        Integer newSum = articleservice.getnewSumByAuthor(article.getAuthor());
        model.addAttribute("newSum",newSum);

        //5.最近发表的一篇文章
        article lastArticle  = articleservice.getLastArticleByAuthor(article.getAuthor());
        model.addAttribute("lastArticle",lastArticle);

        //6.判断是否已收藏，和请求收藏，取消收藏
        //先判断是否是用户登入，如果是，则通过session中保存的用户名，根据userMessage表，获取用户uId
        HttpSession ss = request.getSession();
        userMessage user = (com.xtl.pojo.userMessage) ss.getAttribute("userMessage");
        if(user!=null){
            String userName = user.getUserName();
            Integer uid = articleservice.getuIdByUserName(userName);
            Integer isCollect = articleservice.IsCollect(article.getaId(), uid);
            model.addAttribute("uid",uid);
            model.addAttribute("isCollect",isCollect);
        }

        return "article";
    }

    @ResponseBody
    @RequestMapping("/collected")
    public void collect(HttpServletRequest request){
        int uId = new Integer(request.getParameter("uId"));
        int aId = new Integer(request.getParameter("aId"));
        articleservice.collect(uId, aId);
    }

    @ResponseBody
    @RequestMapping("/backCollect")
    public void backCollect(HttpServletRequest request){
        System.out.println("请求进来");
        int uId = new Integer(request.getParameter("uId"));
        int aId = new Integer(request.getParameter("aId"));
        articleservice.backCollect(uId,aId);
        System.out.println("请求结束");
    }

    @RequestMapping("/allNewsOfAuthor")
    public String allNewsOfAuthor(HttpServletRequest request,Model model){
        String author = request.getParameter("author");
        System.out.println(author);
        model.addAttribute("author",author);
        return "allNewsOfAuthor";
    }

    @ResponseBody
    @RequestMapping("searchNewsByAuthor")
    public article[] searchNewsByAuthor(HttpServletRequest request) throws ParseException {
        String author = request.getParameter("author");
        System.out.println(author);
        Integer n = new Integer(request.getParameter("n"));
        Integer m = new Integer(request.getParameter("m"));
        System.out.println(n+"  "+m);
        article[] as = articleservice.searchNewsByAuthor(author, n, m);
        return as;
    }

}
