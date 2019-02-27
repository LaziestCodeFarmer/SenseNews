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
            <div id="type" style="display: none;">${type}</div>
        </ul>


    </div>
</div>


<%@include file="footer.jsp"%>


</body>

</html>