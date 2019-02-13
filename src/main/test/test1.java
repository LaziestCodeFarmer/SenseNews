import com.xtl.mappers.ArticleMapper;
import com.xtl.pachong.RequestProcess;
import com.xtl.pachong.UrlQueue;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.*;

public class test1 {


    @Test
    public void m1() throws Exception {

        //入口Url
        UrlQueue.add("http://tech.huanqiu.com/discovery/2019-01/14151281.html");

        //springIOC容器
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("springConfig.xml");

        //筛选调用总器
        final RequestProcess rp = context.getBean("RequestProcess",RequestProcess.class);

        //线程池
        ExecutorService executors = Executors.newFixedThreadPool(5);

        while (true){
            //判断是否为空
            if(UrlQueue.isEmpty()){
                return;
            }
            else{
                //线程
                Callable<Article> call = new Callable<Article>() {
                    @Override
                    public Article call() throws Exception{
                        String url = UrlQueue.pop();
                        Article article = rp.executor(url);
                        return article;
                    }
                };
                Future<Article> future = executors.submit(call);
                Article article = future.get(10000 * 1, TimeUnit.MILLISECONDS);
                //article和article.dataTime不为空，则数据完整
                if(article!=null&&article.getDataTime()!=null&&article.getContext()!=null){
                    System.out.println(article.toString());
                }
            }
        }
        //链接数据库
        /*SqlSession ss = MybatisUtil.getSqlSession();
        ArticleMapper mapper = ss.getMapper(ArticleMapper.class);
        mapper.insertNew(article);
        ss.commit();
        ss.close();*/
    }

    @Test
    public void m2(){
        String str = "<div class=\"text\" id=\"text\">\n" +
                "                        <p style=\"text-indent: 2em\">文/VR次元 孙实</p>\n" +
                "<p style=\"text-indent: 2em\">5亿年前的海底世界是什么样的？那个时候的海洋生物和现在有什么不同？</p>\n" +
                "<p style=\"text-indent: 2em\">相信这个问题会激发很多人的探索欲望，但问题又来了：我们如何能真真切切感受到5亿年前的海底世界？</p>\n" +
                "<p style=\"text-indent: 2em\">如果是过去几年，我们唯一能做的，可能就是利用动画特效，制作一部传统的2D纪录片，但在VR时代，我们能做的显然不止这些。</p>\n" +
                "<p align=\"center\"><img src=\"http://himg2.huanqiu.com/attachment2010/2016/0721/20160721093802864.jpg\" /></p>\n" +
                "<p style=\"text-indent: 2em\">2015年6月，由&ldquo;自然纪录片之父&rdquo;大卫 阿滕伯勒（David Attenborough）解说的VR纪录片《First Life》在伦敦自然历史博物馆首映。</p>\n" +
                "<p align=\"center\"><img src=\"http://himg2.huanqiu.com/attachment2010/2016/0721/20160721093802718.jpg\" /></p>\n" +
                "<p align=\"center\">《First Life》体验现场</p>\n" +
                "<p style=\"text-indent: 2em\">这部影片一上映，就立刻得到了大量好评：</p>\n" +
                "<p align=\"center\"><img src=\"http://himg2.huanqiu.com/attachment2010/2016/0721/20160721093802936.jpg\" /></p>\n" +
                "<p align=\"center\">《First Life》获得博物馆和文物题材纪录片创新奖</p>\n" +
                "<p align=\"center\"><img src=\"http://himg2.huanqiu.com/attachment2010/2016/0721/20160721093802750.jpg\" /></p>\n" +
                "<p align=\"center\">《连线》评选的五部最佳VR影片，《First Life》位列其中</p>\n" +
                "<p style=\"text-indent: 2em\">在这部纪录片中，阿滕伯勒带领我们进入5亿年前的海底世界。&ldquo;与古老的生物（如欧巴宾海蝎）面对面，这是一种美妙的体验。&rdquo;阿滕伯勒接受<a href=\"http://country.huanqiu.com/united_kingdom\" class=\"linkAbout\" target=\"_blank\" title=\"英国\">英国</a>媒体WIRED.co.uk采访时说。欧巴宾海蝎是寒武纪时代的生物，有五只眼睛和一个长长的嘴巴。&ldquo;在其他任何一种媒质中，我们都不能这样贴近地观看这些生物。这与电视纪录片非常不同。电影人的艺术是用影像来讲故事，但在这里，你是让观众自己探索。&rdquo;</p>\n" +
                "<p style=\"text-indent: 2em\">&ldquo;VR是一种美妙的体验，&rdquo;阿滕伯勒告诉WIRED.co.uk。 &ldquo;它的创造和叙事都是没有限制的，我们正在为许多新的纪录片而工作，其中一部将在今年晚些时候发布。&rdquo;</p>\n" +
                "<p style=\"text-indent: 2em\"><strong>《First Life》体验：逼真到让人感到恐惧</strong></p>\n" +
                "<p style=\"text-indent: 2em\">在观看《First Life》时，你最开始时会感觉像悬浮在一个深井中，在深井的墙壁上刻着表示历史时间的标记。往下看，你感觉自己好像进入了一个无底洞，越深入就表示回到了越久远的古代。你可以环顾四周，观看不同时代的古生物。</p>\n" +
                "<p align=\"center\"><img src=\"http://himg2.huanqiu.com/attachment2010/2016/0721/20160721093803487.jpg\" /></p>\n" +
                "<p style=\"text-indent: 2em\">片中的解说很短，大部分时间是你在海底潜行，绕过一座座岩石和一些古生物。如果你还没有尝试过这种VR体验，你会感到吃惊。</p>\n" +
                "<p style=\"text-indent: 2em\">如果你静坐着不动，你也会看到解说中提到的所有生物。但是，只有当你环顾四周时，你才会得到一种令人印象深刻的沉浸式体验。</p>\n" +
                "<p style=\"text-indent: 2em\">阿滕伯勒的解说提醒你依次注意各种生物，从早期的、附着在海床上的叶片状有机体，到蛞蝓、三叶虫、蜗牛和一些你可能从来没有见过的生物。如果不是自然历史博物馆为这部片子提供了严谨的科学性，你很可能以为这些奇形怪状的生物都是杜撰出来的。</p>\n" +
                "<p align=\"center\"><img src=\"http://himg2.huanqiu.com/attachment2010/2016/0721/20160721093803865.jpg\" /></p>\n" +
                "<p style=\"text-indent: 2em\">当然，这些生物有时会突然和你靠近并插肩而过，或者向你猛冲过来，但你会感觉这并不是要惊吓你，而只是让你强烈意识到你就处在它们中间。</p>\n" +
                "<p style=\"text-indent: 2em\">有在首映现场的观众回忆，当他们戴上头盔，顿时发现自己正悬浮在一个倾斜的洞穴上方的黑暗中。洞穴的侧面有一些线条，每一条线代表地球发展的不同时期（8亿年前、7亿年前等）。</p>\n" +
                "<p style=\"text-indent: 2em\">然后，观影者慢慢深入洞穴。这是一种可怕的体验，即使对有很多VR体验的人来说也是如此。尽管观影者在虚拟世界中只是一双悬浮的眼睛，仍然会感到害怕。</p>\n" +
                "<p style=\"text-indent: 2em\">到达洞穴的底部时，也就来到了最远古的时代，屏幕逐渐变为黑色，这时观影者会发现自己周围是一些最原始的单细胞动物，它们在周围漂浮着。在看过最原始的单细胞动物之后，观影者（一双浮动的眼睛）开始在海底移动，去探访另外一些古生物。它们会非常靠近观影者，以至于它们好像要直接穿过你的身体。而且，你的身体好像在与海底刮擦，这已经不但但是一种沉浸式体验，而是一种身临其境的感觉。</p>\n" +
                "<p style=\"text-indent: 2em\">当然，如此逼真的体验也会有瑕疵。有观众反映，对于以海洋古生物为题材的VR纪录片而言，制作方可以采用更能让观众理解的设计，比如让观影者在VR中进入一艘潜艇内，让观众进行某种古怪的时间旅行实验，不要一开始就让观众悬浮在一个黑暗的洞穴上，然后让他们掉下去，这样会让他们感觉自己像一个布娃娃一样被拽来拽去。（谭思参与编译）</p>\n" +
                "</p>                        <!-- 广告位：视频全屏广告位 -->\n" +
                "                        <script>\n" +
                "                            (function() {\n" +
                "                                var s = \"_\" + Math.random().toString(36).slice(2);\n" +
                "                                document.write('<div id=\"' + s + '\"></div>');\n" +
                "                                (window.slotbydup=window.slotbydup || []).push({\n" +
                "                                    id: '2397994',\n" +
                "                                    container: s,\n" +
                "                                    size: '980,551',\n" +
                "                                    display: 'inlay-fix'\n" +
                "                                });\n" +
                "                            })();\n" +
                "                        </script>\n" +
                "                                                \n" +
                "                                                <!--相关新闻上方合作--></div>";
        String str2="</div>";
        System.out.println(str.lastIndexOf(str2));
        System.out.println(str.length()-str2.length());
    }

    //MD5加密
    @Test
    public void m3() throws NoSuchAlgorithmException {

        //密码
        String password = "aa123456,,";
        //获取一个MD计算器
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //进行加密
        md5.update(password.getBytes());
        //获取加密后的数据，数据存储到2进制byte数组中
        byte[] digest = md5.digest();
        //封装到BigInteger大数据对象中
        //这个构造方法默认是将信息转成10进制封装到该对象的signum属性中
        BigInteger bi = new BigInteger(digest);
        //转换成16进制输出
        System.out.println(bi.toString(16));

        //问题1：digest()加密成一连串数字，返回该数字的字节数组，为何用new String(*)输出是乱码
        //用BigInteger(*)却行

    }


}
