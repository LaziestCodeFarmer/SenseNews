package com.xtl.controller;

import com.xtl.pojo.article;
import com.xtl.service.typeNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

//新闻分类显示Controller
@Controller
public class TypeNewsController {
    @Autowired
    typeNewsService tns;

    @RequestMapping("/typeNews")
    public String typeNews(HttpServletRequest request, Model model){
        String type = request.getParameter("type");
        System.out.println(type);
        model.addAttribute("type",type);
        return "typeNews";
    }


    @RequestMapping("/searchNewsByType")
    @ResponseBody
    public article[] searchNewsByType(HttpServletRequest request) throws ParseException {
        String type = request.getParameter("type");
        System.out.println(type);
        Integer n = new Integer(request.getParameter("n"));
        Integer m = new Integer(request.getParameter("m"));
        System.out.println(n+"  "+m);
        article[] as = tns.searchNewsByType(type, n, m);
        return as;
    }


}
