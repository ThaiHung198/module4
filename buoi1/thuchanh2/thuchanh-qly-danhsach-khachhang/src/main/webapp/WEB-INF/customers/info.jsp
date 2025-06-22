<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

There are ${customers.size()} customer(s) in list.

<c:forEach var="c" items="${customers}">
    <tr>
        <td><c:out value="${c.id}"/></td>
        <td><a href="info.jsp?id=${c.id}">${c.name}</a></td>
        <td><c:out value="${c.email}"/></td>
        <td><c:out value="${c.address}"/></td>
    </tr>
</c:forEach>
