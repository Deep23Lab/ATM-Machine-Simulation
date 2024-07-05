<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Check Balance</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <h2>Check Balance</h2>
        <form action="BalanceServlet" method="get">
            <input type="submit" value="View Balance">
        </form>
        <p class="message success">Your current balance is: <%= request.getAttribute("balance") %></p>
        <p class="message error"><%= request.getParameter("error") %></p>
        <p><a href="account.jsp">Back to Account</a></p>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>


    