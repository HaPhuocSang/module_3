package com.example.bai_tap_1.controller;

import com.example.bai_tap_1.service.ClientService;
import com.example.bai_tap_1.service.IClientService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "clientController", value = "")
public class ClientController extends HttpServlet {
    private final IClientService clientService = new ClientService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clientList", clientService.findAll());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
