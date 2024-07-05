<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Account Menu</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <h2>Welcome to Your Account</h2>
        <div class="hero">
            <h1>Manage Your Account</h1>
            <p>Select an option below to proceed:</p>
            <p class="message success"><%= request.getParameter("message") %></p>
            <a href="balance.jsp" class="btn">Check Balance</a><br><br>
            <a href="transaction_history.jsp" class="btn btn-secondary">Transaction History</a><br><br>
            <a href="withdraw.jsp" class="btn">Withdraw Money</a><br><br>
            <a href="deposit.jsp" class="btn btn-secondary">Deposit Money</a><br><br>
            <a href="change_pin.jsp" class="btn">Change PIN</a>
        </div>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>

