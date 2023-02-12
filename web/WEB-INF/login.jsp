<%-- 
    Document   : login
    Created on : 11-Feb-2023, 4:12:07 PM
    Author     : Densa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="post">
        <h1>Login</h1><br>
        Username: <input type="text" name="username" value="${username}" placeholder="Username"><br>
        Password: <input type="text" name="password" value="${password}" placeholder="Password"><br>
        <input type="submit" value="Log in">
        </form>
        <p>${message}</p>
    </body>
</html>
