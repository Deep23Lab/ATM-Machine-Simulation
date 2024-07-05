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
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.DBConnection;

import java.util.ArrayList;
import java.util.List;

@WebServlet("/TransactionHistoryServlet")
public class TransactionHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String accountNumber = (String) session.getAttribute("accountNumber");

        if (accountNumber == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM transactions WHERE account_number = ?");
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            List<String> transactions = new ArrayList<>();
            while (rs.next()) {
                String transaction = "Type: " + rs.getString("type") + ", Amount: " + rs.getDouble("amount") + ", Date: " + rs.getTimestamp("date");
                transactions.add(transaction);
            }
            request.setAttribute("transactions", transactions);
            request.getRequestDispatcher("transaction_history.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("account.jsp?error=Internal server error");
        }
    }
}

