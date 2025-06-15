<%-- File: src/main/webapp/WEB-INF/views/converter.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>

<h1>Currency Converter</h1>

<form action="/converter" method="post">
    <label for="rate">Exchange Rate (VND/USD):</label><br>
    <input type="text" id="rate" name="rate" value="${rate}"><br><br>

    <label for="usd">USD Amount:</label><br>
    <input type="text" id="usd" name="usd" value="${usd}"><br><br>

    <button type="submit">Convert</button>
</form>

<hr>

<%-- Chỉ hiển thị khối này nếu có kết quả 'vnd' trong model --%>
<c:if test="${vnd != null}">
    <h2>Result:</h2>
    <p>${usd} USD = ${vnd} VND</p>
</c:if>

</body>
</html>