package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnection;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
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

            // Check the current balance
            PreparedStatement ps = con.prepareStatement("SELECT balance FROM users WHERE account_number = ?");
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");

                // Check if the balance is sufficient for withdrawal
                if (balance >= amount) {
                    // Update the balance
                    PreparedStatement ps1 = con.prepareStatement("UPDATE users SET balance = balance - ? WHERE account_number = ?");
                    ps1.setDouble(1, amount);
                    ps1.setString(2, accountNumber);
                    ps1.executeUpdate();

                    // Record the transaction
                    PreparedStatement ps2 = con.prepareStatement("INSERT INTO transactions (account_number, type, amount) VALUES (?, 'withdrawal', ?)");
                    ps2.setString(1, accountNumber);
                    ps2.setDouble(2, amount);
                    ps2.executeUpdate();

                    con.commit();
                    response.sendRedirect("account.jsp?message=Withdrawal successful");
                } else {
                    response.sendRedirect("account.jsp?error=Insufficient balance");
                }
            } else {
                response.sendRedirect("account.jsp?error=Account not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("account.jsp?error=Transaction failed");
        }
    }
}

