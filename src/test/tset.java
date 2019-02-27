import com.xtl.mapper.indexMapper;
import com.xtl.mapper.typeNewsMapper;
import com.xtl.mapper.userMapper;
import com.xtl.pojo.article;
import com.xtl.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tset {

    @Test
    public void m1() throws Exception{
        //将密码进行MD5加密
        //获取MD5加密器
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //将密码进行加密，同时返回的是二进制密文
        //byte[] digest = md5.digest("zxzxz".getBytes("utf-8"));
        byte[] digest = md5.digest("dddss".getBytes());
        //转换成16进制
        String s = new BigInteger(digest).toString(16);
        System.out.println(s);
    }

    @Test
    public void m2(){
        SqlSession ss = mybatisUtils.getSqlSession();
        indexMapper mapper = ss.getMapper(indexMapper.class);
        article[] teches = mapper.getArticle("finance");
        if(teches!=null){
            for(article a :teches){
                //情况1：<img src=":
                //情况2：<img alt="" src="
                String startStr = "<img src=\"";
                String endStr = "\"";
                int start = a.getContext().indexOf(startStr);
                int end;
                if(start==-1){
                    startStr = "<img alt=\"\" src=\"";
                    start = a.getContext().indexOf(startStr);
                }
                end = a.getContext().indexOf(endStr,start+startStr.length());
                if(start!=-1&&end!=-1){
                    System.out.println(a.getContext().substring(start+startStr.length(),end));
                }
                else{
                    System.out.println("没找到");
                }
            }
        }
    }

    @Test
    public void m3() throws ParseException {
        //当前时间
        Date date1 = new Date();
        String sdate2 = "2019-02-14 22:18:00";
        Date date2;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date2 = sdf.parse(sdate2);
        }catch (Exception e){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date2 = sdf.parse(sdate2);
        }
        System.out.println(date2);

        long a1 = date1.getTime();
        long a2 = date2.getTime();
        //毫秒
        System.out.println(a1-a2);
        //秒
        System.out.println((a1-a2)/1000);
        //分钟
        System.out.println(((a1-a2)/1000/60));
    }


    @Test
    public void m4(){
        SqlSession ss = mybatisUtils.getSqlSession();
        indexMapper mapper = ss.getMapper(indexMapper.class);
        article[] t = mapper.getArticle("tech");
        for(article a : t){
            System.out.println(a.getDataTime().substring(0,a.getDataTime().length()-2));
        }
    }

    @Test
    public void m5(){
        SqlSession ss = mybatisUtils.getSqlSession();
        typeNewsMapper mapper = ss.getMapper(typeNewsMapper.class);
        article[] teches = mapper.searchNewsByType("tech", 1, 4);
        System.out.println(teches.length);
    }

    @Test
    public void m6(){
        String s = "5";
        Integer n = new Integer(s);
        System.out.println(n);
    }

    @Test
    public void m7(){
        Integer i = new Integer(null);
    }
}
