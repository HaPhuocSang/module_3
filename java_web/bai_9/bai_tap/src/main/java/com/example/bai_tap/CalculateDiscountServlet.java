package com.example.bai_tap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CalculateDiscountServlet", value = "/calculate-discount")
public class CalculateDiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        double discountAmount = listPrice * discountPercent * 0.01;
        request.setAttribute("discountAmount", discountAmount);
        request.getRequestDispatcher("calculate-discount.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
