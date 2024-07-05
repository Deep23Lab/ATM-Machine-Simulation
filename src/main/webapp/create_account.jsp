<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Account</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Create a New Account</h2>
    <form action="CreateAccountServlet" method="post">
        <label for="accountHolderName">Account Holder Name:</label>
        <input type="text" id="accountHolderName" name="accountHolderName" required><br><br>
        <input type="submit" value="Create Account">
    </form>
    <p style="color:red;"><%= request.getParameter("error") %></p>
</body>
</html>
