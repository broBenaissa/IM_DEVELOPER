<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="UTF-8">
  <title>ImDevelopper</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
  <a class="btn btn-primary mr-2" href=DeveloperHome.jsp >Back</a>
	<center>
		<h1>Project</h1>
			<br>
			<br>
        <h2>
        	<a class="btn btn-primary mr-2" href="new">Add New project</a>
        	&nbsp;&nbsp;&nbsp;
        	<a class="btn btn-primary" href="list">List All projects</a>
        	
        </h2>
        	<br>
        
	</center>
	<br>
    <div align="center">
                <caption><h2>List of projects</h2></caption>
    
        <table class="table table-bordered" class="user-list" border="1" cellpadding="5">            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Image Url</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="projet" items="${listProjet}">
                <tr>
                    <td><c:out value="${projet.id}" /></td>
                    <td><c:out value="${projet.name}" /></td>
                    <td><c:out value="${projet.description}" /></td>
                    <td><c:out value="${projet.image}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${projet.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${projet.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
