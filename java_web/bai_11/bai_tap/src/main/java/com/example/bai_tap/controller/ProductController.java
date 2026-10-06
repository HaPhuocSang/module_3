package com.example.bai_tap.controller;

import com.example.bai_tap.dto.ProductDto;
import com.example.bai_tap.entity.Category;
import com.example.bai_tap.entity.Product;
import com.example.bai_tap.service.category.CategoryService;
import com.example.bai_tap.service.product.IProductService;
import com.example.bai_tap.service.product.ProductService;
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
    private final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAdd(req, resp);
                break;
            case "category":
                showProductsByCategory(req, resp);
                break;
            case "search":
                search(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void showProductsByCategory(HttpServletRequest req, HttpServletResponse resp) {
        String categoryIdParam = req.getParameter("id");
        if (categoryIdParam == null || categoryIdParam.isEmpty()) {
            showList(req, resp);
            return;
        }
        int categoryId = Integer.parseInt(categoryIdParam);
        List<ProductDto> productList = productService.findByCategoryId(categoryId);
        req.setAttribute("productList", productList);
        req.setAttribute("selectedCategoryId", categoryId);
        req.setAttribute("categories", categoryService.findAll());
        try {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAdd(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Category> categories = categoryService.findAll();
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/views/add.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {
        String keyword = req.getParameter("keyword");
        if (keyword == null || keyword.trim().isEmpty()) {
            showList(req, resp);
            return;
        }
        List<ProductDto> products = productService.findProductByName(keyword.trim());
        req.setAttribute("productList", products);
        req.setAttribute("keyword", keyword);
        try {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        int page = 1;
        int pageSize = 10;
        String pageParam = req.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            page = Integer.parseInt(pageParam);
        }
        int totalProducts = productService.getTotalProducts();
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);
        List<ProductDto> productList = productService.findByPage(page, pageSize);
        req.setAttribute("productList", productList);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("categories", categoryService.findAll());
        try {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
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
                showList(req, resp);
        }
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) {
        Product product = getInfoProduct(req);
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
        ProductDto product = productService.getProduct(id);
        List<Category> categories = categoryService.findAll();
        req.setAttribute("product", product);
        req.setAttribute("categories", categories);
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
        Product product = getInfoProduct(req);
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

    private Product getInfoProduct(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        return new Product(id, name, price, description, idCategory);
    }

}
