<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Deposit Money</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <h2>Deposit Money</h2>
        <form action="DepositServlet" method="post">
            <label for="amount">Deposit Amount:</label>
            <input type="number" id="amount" name="amount" required><br>
            <input type="submit" value="Deposit">
        </form>
        <p class="message success"><%= request.getParameter("message") %></p>
        <p class="message error"><%= request.getParameter("error") %></p>
        <p><a href="account.jsp">Back to Account</a></p>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>

