
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Форма входа</title>
</head>
<body>
<style>
    @import url('https://fonts.googleapis.com/css?family=Roboto');
    body {
        font-family: 'Roboto', sans-serif;
        background: #ddd;
        color: #777777;
        margin: 0;
    }
    form{
        background: #fff;
        height: 140px;
        width: 240px;
        margin: 4% auto;
        padding: 16px;
    }
    input{
        padding: 4px;
        width: 100%;
    }
    p{
        text-align: center;

    }
</style>
<form action="<%=request.getContextPath()%>/admin/login" method="post">
    <p><input type="text" placeholder="Логин" name="login"></p>
    <p><input type="password" placeholder="Пароль" name="pass"></p>
    <p><input type="submit" value="Вход" style=" color: #ffffff; font-size: 16px; text-shadow: 0px 0px 1px RGBA(0,0,0,1); background: #803f99; border: 1px solid #68337c; padding: 8px 16px; width: 100%; cursor: pointer; margin: 0 0 16px 0; "></p>
</form>
</body>
</html>
