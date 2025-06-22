<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Selected Condiments</title>
</head>
<body>

<h1>Your selected condiments:</h1>

<c:choose>
  <c:when test="${not empty selectedCondiments}">
    <ul>
      <c:forEach items="${selectedCondiments}" var="condiment">
        <li>${condiment}</li>
      </c:forEach>
    </ul>
  </c:when>
  <c:otherwise>
    <p>You did not select any condiment.</p>
  </c:otherwise>
</c:choose>

<br>
<a href="${pageContext.request.contextPath}/">Back to selection</a>

</body>
</html>