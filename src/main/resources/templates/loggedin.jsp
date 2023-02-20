<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="com.example.budgetducklings.filter.*"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Welcome back duckie!</title>
</head>

<body>

<jsp:useBean id="login" class="com.example.duckapi.login.LoginBean" />

<jsp:setProperty property="*" name="login" />

<%
    LoginDao loginDao = new LoginDao();
    boolean status = LoginDao.validate(login);
    if (status) {
        System.out.print("<h3>You have logged in successfully</h3>");
    }
%>
</body>

</html>