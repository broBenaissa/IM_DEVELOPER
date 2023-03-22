<!-- edit.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Portfolio Item</title>
</head>
<body>
    <h1>Edit Portfolio Item</h1>
    <form method="post" action="PortfolioServlet">
        <input type="hidden" name="action" value="${item != null ? 'update' : 'add'}"/>
        <c:if test="${item != null}">
            <input type="hidden" name="id" value="${item.id}"/>
        </c:if>
        <p>Name: <input type="text" name="name" value="${item != null ? item.name : ''}"/></p>
        <p>Description: <input type="text" name="description" value="${item != null ? item.description : ''}"/></p>
           <p>URL: <input type="text" name="url" value="${item != null ? item.url : ''}"/></p>
    <p><input type="submit" value="Save"/></p>
</form>
<p><a href="PortfolioServlet">Cancel</a></p>
</body>
</html>