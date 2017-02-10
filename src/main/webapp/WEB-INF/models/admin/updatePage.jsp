<%@ page import="main.java.utilites.PageDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    Integer id=Integer.parseInt(request.getParameter("id"));
    String url=request.getParameter("url");
    String header=request.getParameter("header");
    String title=request.getParameter("title");
    String content=request.getParameter("content");
    Boolean isSave =false;
    if (id!=0&url!=null&header!=null&title!=null&content!=null){
        PageDAO.updatePage(id,url,title,header,content);
    }
    response.sendRedirect(request.getContextPath()+"/admin/edit?id="+id);
%>

