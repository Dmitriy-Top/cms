<%@ page import="main.java.entity.Page" %>
<%@ page import="main.java.utilites.PageDAO" %>
<%@ page contentType="text/html; UTF=8" language="java" pageEncoding="UTF-8" %>
<%
String path = request.getRequestURI().split(request.getContextPath())[1]; //получаем URI запроса без артифакта приложения
Page findPage = PageDAO.getPageByPath(path); //получаем из бд страницу
request.setAttribute("findPage",findPage);
request.getRequestDispatcher(findPage.getTemplatePath()).include(request,response); //отправляем на отрисовку


%>
<!--path is:<%=path%>-->

