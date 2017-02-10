<%@ page import="main.java.utilites.PageDAO" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String menuHTML ="";
    HashMap<String, Integer> pagesURLs = PageDAO.getPagesID();
    for (Map.Entry<String,Integer> entryset: pagesURLs.entrySet()) {
        menuHTML+="<li><a href=\""+request.getContextPath()+"/admin/edit?id="+entryset.getValue()+"\">"+entryset.getKey()+"</a></li>\n";
    }
%>
<ul><%=menuHTML%></ul>
<p>Действия</p>
<a href="<%=request.getContextPath()%>/admin">Добавить страницу >>></a>
<a href="<%=request.getContextPath()%>">Вернуться на сайт >>></a>