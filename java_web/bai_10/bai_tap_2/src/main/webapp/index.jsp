<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <c:import url="/views/library/library.jsp"/>
</head>
<body>
<div class="container mt-3">
    <h1>Simple Calculator</h1>
    <fieldset class="border p-3 mt-4">
        <legend class="float-none w-auto px-2">Calculator</legend>
        <form action="/calculator" method="post">
            <div class="row mb-2">
                <label class="col-4 col-form-label" for="firstOperand">First operand:</label>
                <div class="col-5">
                    <input type="number" class="form-control" id="firstOperand" name="firstOperand" required>
                </div>
            </div>
            <div class="row mb-2">
                <label class="col-4 col-form-label" id="operation">Operator:</label>
                <div class="col-5">
                    <select class="form-select" name="operation" id="operation">
                        <option value="addition" selected>Addition</option>
                        <option value="subtraction">Subtraction</option>
                        <option value="multiplication">Multiplication</option>
                        <option value="division">Division</option>
                    </select>
                </div>
            </div>
            <div class="row mb-2">
                <label class="col-4 col-form-label" for="secondOperand">Second operand:</label>
                <div class="col-5">
                    <input type="number" class="form-control" name="secondOperand" id="secondOperand" required>
                </div>
            </div>
            <div class="row">
                <div class="offset-4 col-5">
                    <button type="submit" class="btn btn-primary">
                        Calculate
                    </button>
                </div>
            </div>
        </form>
    </fieldset>
</div>
</body>
</html>