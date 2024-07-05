<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>ATM Simulation - Home</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("username") %>!</h1>
    <ul>
        <li><a href="balance">Account Balance Inquiry</a></li>
        <li><a href="withdraw.jsp">Cash Withdrawal</a></li>
        <li><a href="deposit.jsp">Cash Deposit</a></li>
        <li><a href="pinchange.jsp">PIN Change</a></li>
        <li><a href="history">Transaction History</a></li>
    </ul>
    <form action="logout" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>