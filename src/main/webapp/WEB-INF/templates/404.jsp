<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="findPage" class="main.java.entity.Page" type="java.lang.Object" scope="request"/>
<html>
<head>
    <title>
        <jsp:getProperty name="findPage" property="title"/>
    </title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/assets/css/page.css">
</head>
<body>
<div id="wrapper">
    <%@include file="html/header.html" %>
    <div id="content-wrapper">
        <div id="menu">
            <jsp:include page="menu.jsp"/>
        </div>
        <div id="content">
            <h1>
                <span><jsp:getProperty name="findPage" property="header"/></span>
            </h1>
            <p>
                <img src="<%=request.getContextPath()%>/static/assets/img/404.png">
            </p>
        </div>
    </div>
    <%@include file="html/footer.html" %>
</div>
</body>
</html>
