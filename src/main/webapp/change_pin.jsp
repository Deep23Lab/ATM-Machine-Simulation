<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Change PIN</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <h2>Change PIN</h2>
        <form action="PinChangeServlet" method="post">
            <label for="oldPin">Old PIN:</label>
            <input type="password" id="oldPin" name="oldPin" required><br>
            <label for="newPin">New PIN:</label>
            <input type="password" id="newPin" name="newPin" required><br>
            <input type="submit" value="Change PIN">
        </form>
        <p class="message success"><%= request.getParameter("message") %></p>
        <p class="message error"><%= request.getParameter("error") %></p>
        <p><a href="account.jsp">Back to Account</a></p>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>

