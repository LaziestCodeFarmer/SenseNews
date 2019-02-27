<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<body>
<!-- 主体 -->

<div class="placeholder-height"></div>
<div class="container" id="index">
    <div class="wrap-left pull-left">
        <!-- 今日要闻 -->
        <div class="big-pic-box">
            <div class="big-pic">
                <a href="./article?aId=${recommends[0].aId}"  class="transition" >
                    <div class="back-img"><img src="${recommends[0].imgUrl}"  alt="${recommends[0].title}"></div>
                    <div class="big-pic-content">
                        <h1 class="t-h1">${recommends[0].title}</h1>
                    </div>
                </a>
            </div>

            <div class="big2-pic big2-pic-index big2-pic-index-top">
                <a href="./article?aId=${recommends[1].aId}" class="back-img transition">
                    <img class="lazy" src="${recommends[1].imgUrl}" alt="${recommends[1].title}">
                </a>
                <a href="./article?aId=${recommends[1].aId}" title="${recommends[1].title}">
                    <div class="big2-pic-content">
                        <h2 class="t-h1">${recommends[1].title}</h2>
                    </div>
                </a>
            </div>
            <div class="big2-pic big2-pic-index big2-pic-index-bottom">
                <a href="./article?aId=${recommends[2].aId}" class="back-img transition">
                    <img class="lazy" src="${recommends[2].imgUrl}" alt="${recommends[2].title}">
                </a>
                <a href="./article?aId=${recommends[2].aId}" title="${recommends[2].title}">
                    <div class="big2-pic-content">
                        <h2 class="t-h1">${recommends[2].title}</h2>
                    </div>
                </a>
            </div>
        </div>


        <!-- 分类 -->
        <div class="mod-info-flow">


            <div class="fenleiBox">
                <a href="" target="_blank">科技</a>
                <span class="cname">China</span>
            </div>
            <ul class="list">
                <c:forEach var="tech" items="${techs}">
                    <li class="item">
                        <!-- 左图 -->
                        <div class="picture">
                            <a href="./article?aId=${tech.aId}"><img alt="${tech.title}" src="${tech.imgUrl}"></a>
                        </div>
                        <!-- 又主体和作者，时间和分享 -->
                        <div class="detail">
                            <h3><a href="./article?aId=${tech.aId}">${tech.title}</a></h3>
                            <div class="sourceAndtime">
                                <a class="source" target="_blank" href="${tech.authorUrl}" >${tech.author}</a>
                                <span class="time">${tech.indexTimeShow}</span>
                            </div>
                        </div>
                        <!-- 清除浮动 -->
                        <div class="clear"></div>
                    </li>
                </c:forEach>
            </ul>


            <div class="fenleiBox">
                <a href="" target="_blank">财经</a>
                <span class="cname">China</span>
            </div>
            <ul class="list">
                <c:forEach var="finance" items="${finances}">
                    <li class="item">
                        <!-- 左图 -->
                        <div class="picture">
                            <a href="./article?aId=${finance.aId}"><img alt="${finance.title}" src="${finance.imgUrl}"></a>
                        </div>
                        <!-- 又主体和作者，时间和分享 -->
                        <div class="detail">
                            <h3><a href="./article?aId=${finance.aId}">${finance.title}</a></h3>
                            <div class="sourceAndtime">
                                <a class="source" target="_blank" href="${finance.authorUrl}" >${finance.author}</a>
                                <span class="time">${finance.indexTimeShow}</span>
                            </div>
                        </div>
                        <!-- 清除浮动 -->
                        <div class="clear"></div>
                    </li>
                </c:forEach>
            </ul>


            <div class="fenleiBox">
                <a href="" target="_blank">国际</a>
                <span class="cname">China</span>
            </div>
            <ul class="list">
                <c:forEach var="world" items="${worlds}">
                    <li class="item">
                        <!-- 左图 -->
                        <div class="picture">
                            <a href="./article?aId=${world.aId}" ><img alt="${world.title}" src="${world.imgUrl}"></a>
                        </div>
                        <!-- 又主体和作者，时间和分享 -->
                        <div class="detail">
                            <h3><a href="./article?aId=${world.aId}" >${world.title}</a></h3>
                            <div class="sourceAndtime">
                                <a class="source" target="_blank" href="${world.authorUrl}" >${world.author}</a>
                                <span class="time">${world.indexTimeShow}</span>
                            </div>
                        </div>
                        <!-- 清除浮动 -->
                        <div class="clear"></div>
                    </li>
                </c:forEach>
            </ul>


            <div class="fenleiBox">
                <a href="" target="_blank">军事</a>
                <span class="cname">China</span>
            </div>
            <ul class="list">
                <c:forEach var="mil" items="${mils}">
                    <li class="item">
                        <!-- 左图 -->
                        <div class="picture">
                            <a href="./article?aId=${mil.aId}"><img alt="${mil.title}" src="${mil.imgUrl}"></a>
                        </div>
                        <!-- 又主体和作者，时间和分享 -->
                        <div class="detail">
                            <h3><a href="./article?aId=${mil.aId}">${mil.title}</a></h3>
                            <div class="sourceAndtime">
                                <a class="source" target="_blank" href="${mil.authorUrl}" >${mil.author}</a>
                                <span class="time">${mil.indexTimeShow}</span>
                            </div>
                        </div>
                        <!-- 清除浮动 -->
                        <div class="clear"></div>
                    </li>
                </c:forEach>
            </ul>


            <div class="fenleiBox">
                <a href="" target="_blank">娱乐</a>
                <span class="cname">China</span>
            </div>
            <ul class="list">
                <c:forEach var="ent" items="${ents}">
                    <li class="item">
                        <!-- 左图 -->
                        <div class="picture">
                            <a href="./article?aId=${ent.aId}" ><img alt="${ent.title}" src="${ent.imgUrl}"></a>
                        </div>
                        <!-- 又主体和作者，时间和分享 -->
                        <div class="detail">
                            <h3><a href="./article?aId=${ent.aId}">${ent.title}</a></h3>
                            <div class="sourceAndtime">
                                <a class="source" target="_blank" href="${ent.authorUrl}" >${ent.author}</a>
                                <span class="time">${ent.indexTimeShow}</span>
                            </div>
                        </div>
                        <!-- 清除浮动 -->
                        <div class="clear"></div>
                    </li>
                </c:forEach>
            </ul>

        </div>
    </div>
    <div class="wrap-right pull-right">
        <div class="right-ad-box"></div>

        <link rel="stylesheet" type="text/css" href="https://static.huxiucdn.com/www/css/moment.css">
        <!-- 24小时内发表的新闻 -->
        <div id="moment"></div>
        <div class="box-moder moder-story-list">
            <h3>24小时</h3>
            <span class="pull-right project-more story-more"><a href="#" class="transition index-24-right js-index-24-right" target="_blank">查看全部</a></span>
            <span class="span-mark"></span>

            <div class="story-box-warp hour-box-warp">
                <div class="nano">
                    <div class="overthrow nano-content description" tabindex="0">
                        <ul class="box-list mt-box-list">
                            <!--公共24小时列表部分-->
                            <li>
                                <div class="story-content">
                                    <div class="mt-story-title js-story-title" story-data-show="true">
                                        <p class="transition hour-arrow">
                                            <span class="icon icon-caret js-mt-index-icon"></span>
                                        </p>
                                        <ul class="hour-head">
                                            <li><img class="hour-tx" src="sy-img/touxiang.jpg" alt="头像"></li>
                                            <li>
                                                <p>果然黑</p>
                                                <p>3分钟前</p>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="mt-index-info-parent">
                                        <div class="story-info mt-story-info">
                                            <p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">#苹果至少要等到2019年才能摆脱对三星的依赖#  作为苹果现有LCD显示屏长期的供货商，LG Display可做到2019年实现OLED显示屏的全面发货，明年年底可以实现少量的发货。目前，LG与苹果就一些协商预付款的细节问题讨论到最后阶段。<a href="#" target="_blank" class="mt-index-cont2-a">[&nbsp原文&nbsp]</a>
                                            </p>
                                            <div class="mt-index-end">
                                                <div class="mt-index-realend">...</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="nano-pane">
                        <div class="nano-slider" style="height: 179px; transform: translate(0px, 0px);"></div>
                    </div>
                </div>
            </div>
            <div class="js-more-moment" data-cur_page="0"></div>
        </div>
        <div class="placeholder"></div>
        <!--24小时部分结束1-->

    </div>
</div>


<%--<c:forEach var="tech" items="${techs}" >
    <c:out value="${tech.dataTime}" /> <br>
    <c:out value="${tech.indexTimeShow}"/> <br>
    <c:out value="${tech.aId}" /> <br>
    <c:out value="${tech.imgUrl}" /> <br>
    <c:out value="${tech.author}" /> <br>
    <c:out value="${tech.title}" /> <br>
    <c:out value="${tech.type}" /> <br>
    <c:out value="${tech.click}" /> <br><br><br>
    <c:out value="${tech.context}" /> <br> <br>
</c:forEach>--%>

<%@include file="footer.jsp"%>

<!-- 遇到的问题：
    1.静态资源拦截请求
 -->

</body>

</html>
