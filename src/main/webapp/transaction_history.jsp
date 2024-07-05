<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Transaction History</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <h2>Transaction History</h2>
        <form action="TransactionHistoryServlet" method="get">
            <input type="submit" value="View Transaction History">
        </form>
        <ul>
            <c:forEach var="transaction" items="${transactions}">
                <li>${transaction}</li>
            </c:forEach>
        </ul>
        <p class="message error"><%= request.getParameter("error") %></p>
        <p><a href="account.jsp">Back to Account</a></p>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>

