<%@ page import="main.java.entity.Page" %>
<%@ page import="main.java.utilites.PageDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Integer id = Integer.parseInt(request.getParameter("id"));
    Page pageEdit = PageDAO.getPageByID(id);
%>
<html>
<head>
    <title>
        Панель управления сайтом
    </title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/assets/css/admin.css">
    <script src="http://js.nicedit.com/nicEdit-latest.js" type="text/javascript"></script>
    <script type="text/javascript">bkLib.onDomLoaded(nicEditors.allTextAreas);</script>

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
            <form action="<%=request.getContextPath()%>/admin/delete" method="post">
                <input type="hidden" value="<%=pageEdit.getId()%>" name="id">
                <input type="submit" value="Удалить страницу">
            </form>
            <form action="<%=request.getContextPath()%>/admin/update" method="post">
                <input name="id" value="<%=pageEdit.getId()%>" type="hidden">
                <p>
                    URL
                </p>
                <input name="url" value="<%=pageEdit.getUri()%>" type="text">
                <p>
                    Загаловок
                </p>
                <input name="header" value="<%=pageEdit.getHeader()%>" type="text">
                <p>
                    Title
                </p>
                <input name="title" value="<%=pageEdit.getTitle()%>"  type="text">
                <p>Содержимое</p>
                <textarea name="content"><%=pageEdit.getContent()%></textarea>
                <input value="Сохранить страницу" type="submit">
            </form>
        </div>
    </div>
</div>
</body>
</html>
