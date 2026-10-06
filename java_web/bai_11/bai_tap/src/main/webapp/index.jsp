<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ</title>
    <c:import url="views/library/library.jsp"/>
</head>
<body>

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="fw-bold">Quản lý sản phẩm</h2>
        <a href="/?action=add" class="btn btn-primary">+ Thêm sản phẩm</a>
    </div>
    <c:if test="${not empty param.mess}">
        <div class="alert alert-warning" role="alert">
                ${param.mess}
        </div>
    </c:if>
    <form action="/" method="get" class="row g-2 mb-4">
        <input type="hidden" name="action" value="search">
        <label for="search"></label>
        <div class="col-md-8">
            <input type="text" id="search" name="keyword" class="form-control" placeholder="Nhập tên sản phẩm cần tìm..." value="${keyword}">
        </div>
        <div class="col-md-2">
            <button type="submit" class="btn btn-success w-100">🔍 Tìm kiếm</button>
        </div>
        <div class="col-md-2">
            <a href="/" class="btn btn-secondary w-100">Làm mới</a>
        </div>
    </form>
    <div class="mb-4">
        <label for="category" class="form-label">Chọn danh mục</label>
        <form action="/" method="get">
            <input type="hidden" name="action" value="category">
            <select name="id" id="category" class="form-select" onchange="this.form.submit()">
                <option value="">
                    -- Chọn danh mục --
                </option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}"${category.id == selectedCategoryId ? 'selected' : ''}>${category.name}</option>
                </c:forEach>
            </select>
        </form>
    </div>
    <div class="card shadow-sm">
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered table-hover align-middle">
                    <thead class="table-dark">
                    <tr>
                        <th class="text-center">STT</th>
                        <th>Mã sản phẩm</th>
                        <th>Tên sản phẩm</th>
                        <th>Giá</th>
                        <th>Mô tả</th>
                        <th>Thương hiệu</th>
                        <th class="text-center">Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${productList}" varStatus="status">
                        <tr>
                            <td class="text-center">${status.count}</td>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td><fmt:formatNumber value="${product.price}" pattern="0"/></td>
                            <td>${product.description}</td>
                            <td>${product.category}</td>
                            <td class="text-center">
                                <form action="/?action=showEdit" method="post">
                                    <label for="productId" style="display: none"></label>
                                    <input type="hidden" name="id" value="${product.id}">
                                    <button class="btn btn-warning btn-sm" type="submit">Sửa</button>
                                </form>
                                <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="getIdProduct('${product.id}')">
                                    Xóa
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<nav aria-label="Page navigation">
    <ul class="pagination justify-content-center">
        <c:forEach begin="1" end="${totalPages}" var="page">
            <li class="page-item ${page == currentPage ? 'active' : ''}">
                <a class="page-link"
                   href="/?action=list&page=${page}">
                        ${page}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <form action="/?action=delete" method="post">
        <input type="hidden"  name="productId" id="productId">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Xác nhận xóa</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Bạn có muốn xóa sản phẩm này
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Thoát</button>
                    <button type="submit" class="btn btn-primary">Xác nhận</button>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    function getIdProduct(id){
        document.getElementById("productId").value = id;
    }
</script>
</body>
</html>