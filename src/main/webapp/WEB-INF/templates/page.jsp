<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="findPage" class="main.java.entity.Page" type="java.lang.Object" scope="request"/>
<html>
<head>
    <title><jsp:getProperty name="findPage" property="title"/></title>
</head>
<body>
<h1><jsp:getProperty name="findPage" property="header"/></h1>
<p><jsp:getProperty name="findPage" property="content"/></p>
</body>
</html>
