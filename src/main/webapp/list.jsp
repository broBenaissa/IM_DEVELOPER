<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <title>Portfolio Items</title>
    <link rel="stylesheet" href="css/style2.css">
    
</head>
<body>
    <h1>Portfolio Items</h1>
    <table align=center class="portfolio-list-item">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>URL</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${projet}" var="projet">
                <tr>
                    <td>${projet.id}</td>
                    <td>${projet.name}</td>
                    <td>${projet.description}</td>
                    <td>${projet.url}</td>
                    <td><a class="button" href="PortfolioServlet?action=edit&id=${projet.id}"> edit</a></td>
                    <td><a class="button" href="PortfolioServlet?action=delete&id=${projet.id}"> Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<p><a href="edit.jsp" class="button">Add New Item</a></p></body>
</html>

