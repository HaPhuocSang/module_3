<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <c:import url="./views/library/library.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <h2 class="text-center">Danh sách khách hàng</h2>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Tên</th>
                <th scope="col">Ngày sinh</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Ảnh</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="client" varStatus="status" items="${clientList}">
                    <tr>
                        <th scope="row">${status.count}</th>
                        <td>${client.name}</td>
                        <td>${client.birthday}</td>
                        <td>${client.address}</td>
                        <td><img src="./views/images/${client.img}" style="width: 40px; height: 40px" alt="ảnh khách hàng"></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>