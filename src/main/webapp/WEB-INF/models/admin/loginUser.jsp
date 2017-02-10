<%@ page import="main.java.utilites.LoginDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String login = request.getParameter("login");
    String pass = request.getParameter("pass");
    if (login != null & pass != null) {
        boolean isAuth = LoginDAO.auth(login, pass);
        if (isAuth) {
            LoginDAO.addAuthSession(request, pass);
            response.sendRedirect(request.getContextPath() + "/admin");
        }else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
%>
