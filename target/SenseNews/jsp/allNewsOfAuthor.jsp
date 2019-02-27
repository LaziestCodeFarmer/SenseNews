<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<body>

<div class="placeholder-height"></div>
<div class="container" id="index">
    <script language="javascript" type="text/javascript" src="js/typeNews.js"></script>
    <div class="wrap-left pull-left">
        <style>
            .detail>.sourceAndtime>a {
                color: #666;
                padding-right: 8px;
            }
            .detail>.sourceAndtime>a:hover{
                color: #666;
            }
        </style>
        <ul class="list" id="list">
            <%--该div用来隐藏新闻type的类型，便以js获取--%>
            <div id="author" style="display: none;">${author}</div>
        </ul>


    </div>
</div>
<script>
    window.onload=function () {
        var n = 0;
        var m = 4;
        var author = document.getElementById("author").innerText;
        start();
        window.onscroll = function () {
            var wScrollY = window.scrollY; // 当前滚动条位置
            var wInnerH = window.innerHeight; // 设备窗口的高度（不会变）
            var bScrollH = document.body.scrollHeight; // 滚动条总高度
            if (wScrollY + wInnerH+0.4 >= bScrollH) {
                start();
            }
        }

        /* 开始加载时，请求4条数据*/
        function start() {
            //创建异步请求对象
            var ajax = new XMLHttpRequest();
            //设置请求类型，url,参数
            ajax.open("get","./searchNewsByAuthor?author="+author+"&n="+n+"&m="+m);
            //发送请求
            ajax.send();
            //ajax状态改变时，执行的函数
            ajax.onreadystatechange = function () {
                //追加内容
                var context = "";
                //请求成功
                if(ajax.readyState==4&&ajax.status==200){
                    //获取列表ul元素
                    var typeBox = document.getElementById('list');
                    //获取返回json数据
                    var json = JSON.parse(ajax.responseText);

                    for (var i=0;i<json.length;i++){
                        var li = document.createElement("li");
                        li.setAttribute("class","item");

                        <!-- 左图 -->
                        var picture = document.createElement("div");
                        picture.setAttribute("class","picture");
                        var picture_a = document.createElement("a");
                        picture_a.setAttribute("href","./article?aId="+json[i].aId);
                        picture_a.setAttribute("target","_blank");
                        var picture_img = document.createElement("img");
                        picture_img.setAttribute("alt",json[i].title);
                        picture_img.setAttribute("src",json[i].imgUrl);

                        picture_a.append(picture_img);
                        picture.append(picture_a)
                        li.append(picture);


                        <!-- 又主体和作者，时间和分享 -->
                        var detail = document.createElement("div");
                        detail.setAttribute("class","detail");
                        var detail_h3 = document.createElement("h3");
                        var detail_h3_a = document.createElement("a");
                        detail_h3_a.setAttribute("href","./article?aId="+json[i].aId);
                        detail_h3_a.setAttribute("target","_blank");
                        detail_h3_a.innerText = json[i].title;
                        detail_h3.append(detail_h3_a);
                        detail.append(detail_h3);


                        var sourceAndtime = document.createElement("div");
                        sourceAndtime.setAttribute("class","sourceAndtime");
                        var sourceAndtime_a = document.createElement("a");
                        sourceAndtime_a.setAttribute("href","./article?aId="+json[i].aId);
                        sourceAndtime_a.setAttribute("target","_blank");
                        sourceAndtime_a.innerText = json[i].author;
                        sourceAndtime.append(sourceAndtime_a);

                        var sourceAndtime_span = document.createElement("span");
                        sourceAndtime_span.setAttribute("class","time");
                        sourceAndtime_span.innerText = json[i].indexTimeShow;
                        sourceAndtime.append(sourceAndtime_span);
                        detail.append(sourceAndtime);
                        li.append(detail);


                        <!-- 清除浮动 -->
                        var clear = document.createElement("div");
                        clear.setAttribute("class","clear");
                        li.append(clear);
                        typeBox.append(li);
                    }
                    n+=4;
                }
            }
        }

    }
</script>

<%@include file="footer.jsp"%>


</body>

</html>