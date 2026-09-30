<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30/09/2026
  Time: 4:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
    <c:import url="library/library.jsp"/>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-7 col-lg-6">
            <div class="card shadow">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0 text-center"> Thêm sản phẩm </h4>
                </div>
                <div class="card-body">
                    <form action="/?action=add" method="post">
                        <div class="mb-3">
                            <label for="id" class="form-label"> Mã sản phẩm </label>
                            <input type="number" class="form-control" id="id" name="id" placeholder="Nhập mã sản phẩm" required>
                        </div>
                        <div class="mb-3">
                            <label for="name" class="form-label"> Tên sản phẩm </label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Nhập tên sản phẩm" required>
                        </div>
                        <div class="mb-3">
                            <label for="price" class="form-label"> Giá </label>
                            <input type="number" class="form-control" id="price" name="price" placeholder="Nhập giá sản phẩm" min="0" required>
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label"> Mô tả </label>
                            <input type="text" class="form-control" id="description" name="description" placeholder="Nhập mô tả" required>
                        </div>
                        <div class="d-flex justify-content-between mt-4">
                            <a href="/" class="btn btn-secondary"> Quay lại </a>
                            <button type="submit" class="btn btn-primary"> Thêm sản phẩm </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
