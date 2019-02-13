<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- 开始EL表达式 -->
    <!-- java逻辑代码 -->
    <h3>EL标签</h3>
    <%request.getParameter("account");%>
    <!-- java值的输出 -->
    <%=request.getParameter("account")%>
    <br>

    <!-- Model对象值 -->
    ${username}
    <!-- 结束EL表达式 -->

    <!-- 开始JSTL表达式 -->
    <%--
        <c:out>	用于在JSP中显示数据，就像<%= ... >
        <c:set>	用于保存数据
        <c:remove>	用于删除数据
        <c:catch>	用来处理产生错误的异常状况，并且将错误信息储存起来
        <c:if>	与我们在一般程序中用的if一样
        <c:choose>	本身只当做<c:when>和<c:otherwise>的父标签
        <c:when>	<c:choose>的子标签，用来判断条件是否成立
        <c:otherwise>	<c:choose>的子标签，接在<c:when>标签后，当<c:when>标签判断为false时被执行
        <c:import>	检索一个绝对或相对 URL，然后将其内容暴露给页面
        <c:forEach>	基础迭代标签，接受多种集合类型
        <c:forTokens>	根据指定的分隔符来分隔内容并迭代输出
        <c:param>	用来给包含或重定向的页面传递参数
        <c:redirect>	重定向至一个新的URL.
        <c:url>	使用可选的查询参数来创造一个URL
    --%>

    <!-- JSTL配合EL使用。 -->
    <h3>JSTL标签</h3>
    <c:out value="aaaa"/>
    <c:out value="${requestScope.account}" default="xtl" />
    <c:out value="${username}" default="xtl" />
    <br>
    <h5>if使用</h5>
    <br>
    <c:if test="${username!=null}">
        <c:out value="${username}"/>
    </c:if>

    <!-- 结束JSTL表达式 -->

    <!-- 开始练习 -->
    <br>
    <br>
    <c:out value="获取session中保存的用户名"/>
    <br>
    ${userMessage.userName}

</body>
</html>
