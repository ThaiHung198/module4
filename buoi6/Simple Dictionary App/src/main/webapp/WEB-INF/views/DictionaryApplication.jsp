<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Từ điển Anh - Việt</title>
</head>
<body>

<h1>Từ điển Anh - Việt đơn giản</h1>

<form action="/lookup" method="post">
  <input type="text" name="englishWord" placeholder="Nhập từ tiếng Anh" value="${englishWord}"/>
  <input type="submit" value="Dịch"/>
</form>

<hr>

<%-- Chỉ hiển thị kết quả nếu có --%>
<c:if test="${not empty result}">
  <h3>Kết quả:</h3>
  <p>Từ tiếng Anh: <strong>${englishWord}</strong></p>
  <p>Nghĩa tiếng Việt: <strong>${result}</strong></p>
</c:if>

</body>
</html>