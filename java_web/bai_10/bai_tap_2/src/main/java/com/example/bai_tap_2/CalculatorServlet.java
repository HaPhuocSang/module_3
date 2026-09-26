package com.example.bai_tap_2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "calculator", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(req.getParameter("firstOperand"));
        double secondOperand = Double.parseDouble(req.getParameter("secondOperand"));
        String operation = req.getParameter("operation");
        String operator = "";
        double result = 0;
        if (operation.equals("addition")) {
            result = firstOperand + secondOperand;
            operator = "+";
        }
        else if (operation.equals("subtraction")) {
            result = firstOperand - secondOperand;
            operator = "-";
        }
        else if (operation.equals("multiplication")) {
            result = firstOperand * secondOperand;
            operator = "*";
        }
        else {
            result = firstOperand / secondOperand;
            operator = "/";
        }
        req.setAttribute("firstOperand", firstOperand);
        req.setAttribute("secondOperand", secondOperand);
        req.setAttribute("operation", operator);
        req.setAttribute("result", result);
        req.getRequestDispatcher("calculator.jsp").forward(req, resp);
    }
}
