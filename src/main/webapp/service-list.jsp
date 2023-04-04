<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title> Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<center>
		<h1>Service</h1>
			<br>
			<br>
        <h2>
        	<a class="btn btn-primary mr-2" href="new">Add New Service</a>
        	&nbsp;&nbsp;&nbsp;
        	<a class="btn btn-primary" href="list">List All Services</a>
        	
        </h2>
        	<br>
        
	</center>
	<br>
    <div align="center">
                <caption><h2>List of Services</h2></caption>
    
        <table class="table table-bordered" class="user-list" border="1" cellpadding="5">            <tr>
                <th>ID</th>
                <th>Service Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="service" items="${listService}">
                <tr>
                    <td><c:out value="${service.id}" /></td>
                    <td><c:out value="${service.name}" /></td>
                    <td><c:out value="${service.description}" /></td>
                    <td><c:out value="${service.price}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${service.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${service.id}' />">Delete</a>                    	
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
