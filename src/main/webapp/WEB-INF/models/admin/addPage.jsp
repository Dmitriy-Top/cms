<%@ page import="main.java.utilites.PageDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String url=request.getParameter("url");
    String header=request.getParameter("header");
    String title=request.getParameter("title");
    String content=request.getParameter("content");
    Boolean isSave =false;
    if (url!=null&header!=null&title!=null&content!=null){
        isSave=PageDAO.savePage(url,title,header,content);
    }
    response.sendRedirect(request.getContextPath()+"/admin");
%>

