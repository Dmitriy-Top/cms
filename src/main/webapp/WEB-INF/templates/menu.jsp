<%@ page import="main.java.utilites.PageDAO" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String menuHTML ="";
    HashMap<String, String> pagesURLs = PageDAO.getPagesUrls();
    for (Map.Entry<String,String> entryset: pagesURLs.entrySet()) {
        menuHTML+="<li><a href=\""+request.getContextPath()+entryset.getValue()+"\">"+entryset.getKey()+"</a></li>\n";
    }
%>
<ul><%=menuHTML%></ul>

