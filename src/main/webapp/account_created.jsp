<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Account Created</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Account Created Successfully</h2>
    <p>Your account number is: <%= request.getAttribute("accountNumber") %></p>
    <p>Your PIN is: <%= request.getAttribute("pin") %></p>
    <p>Please save these details securely.</p>
    <p><a href="login.jsp">Go to Login</a></p>
</body>
</html>
