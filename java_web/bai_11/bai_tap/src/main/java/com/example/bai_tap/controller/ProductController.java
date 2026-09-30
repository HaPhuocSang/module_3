package com.example.bai_tap.controller;

import com.example.bai_tap.entity.Product;
import com.example.bai_tap.service.IProductService;
import com.example.bai_tap.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "")
public class ProductController extends HttpServlet {
    private final IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                req.getRequestDispatcher("/views/add.jsp").forward(req, resp);
                break;
            case "search":
                search(req, resp);
                break;
            default:
                showList(req, resp);

        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {
        String search = req.getParameter("search");
        if (search == null || search.trim().isEmpty()) {
            showList(req, resp);
            return;
        }
        List<Product> products = productService.findProductByName(search.trim());
        req.setAttribute("productList", products);
        req.setAttribute("search", search);
        try {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("productList", productService.findAll());
        try {
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addProduct(req, resp);
                break;
            case "showEdit":
                showEdit(req, resp);
                break;
            case "edit":
                editProduct(req, resp);
                break;
            case "delete":
                deleteById(req, resp);
                break;
            default:
                ;
        }
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        long price = Long.parseLong(req.getParameter("price"));
        String description = req.getParameter("description");
        Product product = new Product(id, name, price, description);
        boolean isSuccess = productService.updateProduct(product);
        String mess = "Edit Not Success";
        if (isSuccess) {
            mess = "Edit Success";
        }
        try {
            resp.sendRedirect("/?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getProduct(id);
        req.setAttribute("product", product);
        try {
            req.getRequestDispatcher("/views/edit.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) {
        int deleteId = Integer.parseInt(req.getParameter("productId"));
        boolean isSuccess = productService.deleteProduct(deleteId);
        String mess = "Delete Not Success";
        if (isSuccess) {
            mess = "Delete Success";
        }
        try {
            resp.sendRedirect("/?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        long price = Long.parseLong(req.getParameter("price"));
        String description = req.getParameter("description");
        Product product = new Product(id, name, price, description);
        boolean isSuccess = productService.addProduct(product);
        String mess = "Add Not Success";
        if (isSuccess) {
            mess = "Add Success";
        }
        try {
            resp.sendRedirect("/?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
