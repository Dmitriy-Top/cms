
<%@ page import="main.java.utilites.LoginDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String nickName = "";
    String JSESSIONID = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("JSESSIONID".equals(cookie.getName())) {
                JSESSIONID = cookie.getValue();
            }
        }
    }
    if (!LoginDAO.isAuthenticated(JSESSIONID)) {
        response.sendRedirect(request.getContextPath()+"/login");
    }
%>
<html>
<head>
    <title>
        Панель управления сайтом
    </title>
    <script src="http://js.nicedit.com/nicEdit-latest.js" type="text/javascript"></script>
    <script type="text/javascript">bkLib.onDomLoaded(nicEditors.allTextAreas);</script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/assets/css/admin.css">
</head>
<body>
<div id="wrapper">
    <div id="content-wrapper">
        <div id="menu">
            <p>Редактировать страницу:</p>
                <jsp:include page="/admin/menu"/>
        </div>
        <div id="content">
            <h1>
                <span>Панель управления сайтом</span>
            </h1>
            <h2>Добавить новую страницу</h2>
            <form action="<%=request.getContextPath()%>/admin/add" method="post">
                <p>
                    URL
                </p>
                <input name="url" value="/" type="text">
                <p>
                    Загаловок
                </p>
                <input name="header" type="text">
                <p>
                    Title
                </p>
                <input name="title" type="text">
                <p>Содержимое</p>
                <textarea name="content" style="width: 600px;"></textarea>
                <input value="Создать страницу" type="submit">
            </form>
        </div>
    </div>
</div>
</body>
</html>
