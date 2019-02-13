<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <title>视觉网</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
    <meta name="author" content="视觉网">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/build.css">
    <link rel="stylesheet" type="text/css" href="css/activity.css">
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <link href="css/zzsc.css" rel="stylesheet" type="text/css"/>
    <link href="css/dlzc.css" rel="stylesheet" type="text/css"/>
    <script language="javascript" type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/main.js"></script>
    <script language="javascript" type="text/javascript" src="js/popwin.js"></script>
    <script language="javascript" type="text/javascript" src="js/login.js"></script>
    <link rel="stylesheet" type="text/css" href="css/nanoscroller.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>

<header id="top" role="banner" class="transition">
    <!--搜索弹窗 开始-->
    <div class="box">
        <div class="box2">
            <div class="icon icon-search-close js-show-search-box"><a class="close"></a></div>
            <div class="search-content overlay-dialog-animate">
                <div class="search-input">
                    <form role="search" method="get" action="./search.html" onsubmit="return checkinput()">
                        <button type="submit"></button>
                        <input placeholder="请输入关键字" name="s" id="search-input">
                    </form>
                </div>
                <div class="search-history hide" id="history">
                    <span>我的搜索历史</span>
                    <ul class="transition" id="history_ul">
                        <li class="transition"><a href="#">数码</a></li>
                        <li class="transition"><a href="#">科技</a></li>
                        <li class="transition"><a href="#">科技</a></li>
                        <li class="transition"><a href="#">互联网</a></li>
                        <li class="transition"><a href="#">汽车之家</a></li>
                    </ul>
                    <div class="pull-right empty-history js-empty-history">清空历史</div>
                </div>
                <div class="search-history search-hot">
                    <strong>热搜词</strong>
                    <ul>
                        <li class="transition"><a href="#">数码</a></li>
                        <li class="transition"><a href="#">科技</a></li>
                        <li class="transition"><a href="#">互联网</a></li>
                        <li class="transition"><a href="#">汽车之家</a></li>
                        <li class="transition"><a href="#">Uber</a></li>
                        <li class="transition"><a href="#">支付宝</a></li>
                        <li class="transition"><a href="#">大数据</a></li>
                        <li class="transition"><a href="#">创业</a></li>
                        <li class="transition"><a href="#">旅游</a></li>
                        <li class="transition"><a href="#">美团</a></li>
                        <li class="transition"><a href="#">社交</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--搜索弹窗 结束-->
    <script>
        function checkinput(){
            var input = $("#search-input").val();
            if(input ==  null || input == ''){
                return false;
            }
            return true;
        }
    </script>

    <!-- 菜单栏 -->
    <div class="container">
        <!-- Logo -->
        <div class="navbar-header transition">
            <a href="#" title="首页"><img src="images/logo.jpg" alt="视觉网" title="首页" /></a>
        </div>
        <!-- 列表 -->
        <ul class="nav navbar-nav navbar-left" id="jsddm">
            <li class="nav-news"><a href="#" target="_blank">推荐<span class="nums-prompt nums-prompt-topic"></span></a></li>
            <li class="nav-news"><a href="#" target="_blank">大数据</a></li>
            <li class="nav-news"><a href="#" target="_blank">科技<span class="nums-prompt"></span></a></li>
            <li class="nav-news"><a href="#" target="_blank">财经<em class="nums-prompt"></em></a></li>
            <li class="nav-news"><a href="#" target="_blank">国际</a></li>
            <li class="nav-news"><a href="#" target="_blank">军事</a></li>
            <li class="nav-news"><a href="#" target="_blank">娱乐</a></li>
        </ul>
        <!-- 登入注册 -->
        <ul class="nav navbar-nav navbar-right transition  xiala main_nav">
            <li class="search-li js-show-search-box"><a><i class="icon icon-search "></i></a><span>搜索</span></li>

            <c:if test="${userMessage==null}">
                <li class="login-link-box" ><a class="cd-signin">登录</a></li>
                <li ><a class="cd-signup" >注册</a></li>
                <!-- 登入注册显示 -->
                <div class="cd-user-modal">
                    <div class="cd-user-modal-container">
                        <div id="cd-login">

                            <!-- 登录表单 -->
                            <div class="modal-alert-title">登录虎嗅</div>
                            <div class="register" >
                                <div class="register-top" id="reg-top"><i><a id="qrcode" href="#"></a></i></div>
                                <div class="register-con" id="rc">
                                    <div class="login-form username-box " style="margin-top:52px;">
                                        <!-- 后期想办法开通手机注册 -->
                                        <!-- <a class="js-open-sms-login sms-text">短信快捷登录</a> -->
                                        <form method="post" action="login">
                                            <label class="login-label transition" >
                                                <input id="login_username" class="login-input" placeholder="手机号／邮箱／Sense账号" name="account">
                                            </label>
                                            <label class="login-label">
                                                <input id="login_password" class="login-input password" type="password" placeholder="输入6～24位密码" name="password">
                                            </label>
                                            <div class="login-operation">
                                                <label><input id="autologin" type="checkbox" name="autologin">&nbsp;2周内自动登录</label>
                                                <a href="/user/reset_password" class="js-forget-passward pull-right">忘记密码</a>
                                            </div>
                                            <button type="submit" class="js-btn-login btn-login">登&nbsp;录</button>
                                        </form>
                                    </div>
                                    <div class="js-open-register register-text">极速注册</div>
                                    <!-- 后期开通 -->
                                    <!-- <div class="third-box">
                                        <div class="title"><span>第三方登录</span></div>
                                        <a href="#"><i class="icon-modal icon-login-qq"></i></a>
                                        <a class="js-login-switch"><i class="icon-modal icon-login-wx"></i></a>
                                        <a href="#"><i class="icon-modal icon-login-wb"></i></a>
                                        <a href="#"><i class="icon-modal icon-login-zfb"></i></a>
                                    </div> -->
                                </div>
                            </div>
                            <!-- 后期开发 -->
                            <div class="saoma" id="sm">
                                <div class="qr-code" style="text-align:center">
                                    <div class="title">微信登录</div>
                                    <div class="waiting panelContent">
                                        <div class="wrp_code"><img class="qrcode lightBorder" src="images/150943753529.png"></div>
                                        <div class="info">
                                            <div class="status status_browser js_status" id="wx_default_tip">
                                                <p>请使用微信扫描二维码登录</p>
                                                <p>"虎嗅网"</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="screen-tu" id="screen"></div>
                            </div>
                        </div>
                        <div id="cd-signup"> <!-- 注册表单 -->
                            <div class="modal-alert-title">极速注册</div>
                            <div class="user-register-box">
                                <div class="login-form sms-box">
                                    <form method="post" action="./regist" >
                                        <label class="login-label transition" >
                                            <input id="regist_username" class="login-input" placeholder="手机号／邮箱／Sense账号" name="account">
                                        </label>
                                        <label class="login-label">
                                            <input id="regist_password" class="login-input password" type="password" placeholder="输入6～24位密码" name="password">
                                        </label>
                                        <label class="login-label">
                                            <input id="regist_supper_password" class="login-input password" type="password" placeholder="输入6～24位超级密保" name="supperPassword">
                                        </label>
                                        <button type="submit" class="js-btn-login btn-login">注&nbsp;册</button>
                                    </form>
                                </div>
                                <div class="js-user-login register-text">已有账号，立即登录</div></div>
                        </div>
                        <a href="" class="cd-close-form ">关闭</a>
                    </div>
                </div>

                <script src="js/d-login.js"></script>
            </c:if>
            <c:if test="${userMessage!=null}">
                <li id="showUserName">${userMessage.userName}</li>
                <ul id="showAndOut">
                    <li>个人信息</li>
                    <li>注销</li>
                </ul>
            </c:if>
            <li><a class="cd-tougao">投稿</a></li>
        </ul>
    </div>

</header>


<!-- include的两种用法

 <%--1.<%@include file="header.jsp"%>--%>先包含后编译
 ＜jsp:include page=”relativeURI” flush=”true” /＞先编译后包含


 -->