<%@ page import="main.java.utilites.PageDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    Integer id=Integer.parseInt(request.getParameter("id"));
    if (id!=0){
        PageDAO.deletePage(id);
    }
    response.sendRedirect(request.getContextPath()+"/admin");
%>

