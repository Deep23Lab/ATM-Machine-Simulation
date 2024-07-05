package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnection;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String accountNumber = (String) session.getAttribute("accountNumber");
        double amount = Double.parseDouble(request.getParameter("amount"));

        if (accountNumber == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            // Update the balance
            PreparedStatement ps = con.prepareStatement("UPDATE users SET balance = balance + ? WHERE account_number = ?");
            ps.setDouble(1, amount);
            ps.setString(2, accountNumber);
            ps.executeUpdate();

            // Record the transaction
            PreparedStatement ps1 = con.prepareStatement("INSERT INTO transactions (account_number, type, amount) VALUES (?, 'deposit', ?)");
            ps1.setString(1, accountNumber);
            ps1.setDouble(2, amount);
            ps1.executeUpdate();

            con.commit();
            response.sendRedirect("account.jsp?message=Deposit successful");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("account.jsp?error=Transaction failed");
        }
    }
}
