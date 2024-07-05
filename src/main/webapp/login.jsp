<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <h2>ATM Login</h2>
        <form action="AccountServlet" method="post">
            <label for="accountNumber">Account Number:</label>
            <input type="text" id="accountNumber" name="accountNumber" required><br>
            <label for="pin">PIN:</label>
            <input type="password" id="pin" name="pin" required><br>
            <input type="submit" value="Login">
        </form>
        <p>Don't have an account? <a href="create_account.jsp">Create a new account</a></p>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>


