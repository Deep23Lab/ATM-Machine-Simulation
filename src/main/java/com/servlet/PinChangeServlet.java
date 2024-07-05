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

@WebServlet("/PinChangeServlet")
public class PinChangeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String accountNumber = (String) session.getAttribute("accountNumber");
        String oldPin = request.getParameter("oldPin");
        String newPin = request.getParameter("newPin");

        if (accountNumber == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE users SET pin = ? WHERE account_number = ? AND pin = ?");
            ps.setString(1, newPin);
            ps.setString(2, accountNumber);
            ps.setString(3, oldPin);
            int updatedRows = ps.executeUpdate();

            if (updatedRows > 0) {
                response.sendRedirect("account.jsp?message=PIN changed successfully");
            } else {
                response.sendRedirect("account.jsp?error=Invalid old PIN");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("account.jsp?error=Transaction failed");
        }
    }
}
