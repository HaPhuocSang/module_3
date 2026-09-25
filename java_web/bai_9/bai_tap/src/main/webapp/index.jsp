<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form action="/calculate-discount" method="post">
    <label for="productDescription">Mô tả sản phẩm:
        <input type="text" name="productDescription"/>
    </label>
    <br>
    <label for="listPrice">Giá niêm yết của sản phẩm:
        <input type="number" name="listPrice"/>
    </label>
    <br>
    <label for="discountPercent">Giá sau khi đã được chiết khấu
        <input type="number" name="discountPercent"/>
    </label>
    <br>
    <button type="submit">Tính chiết khấu</button>
</form>
</body>
</html>