<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title> Application</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"></head>
<body>
<a class="btn btn-primary mr-2" href=DeveloperHome.jsp >Back</a>

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
        
        <caption class="h3 mb-3 text-center">
            	<h2 class="text-center mb-4">
            		<c:if test="${service != null}">
            			Edit Service
            		</c:if>
            		<c:if test="${service == null}">
            			Add New Service
            		</c:if>
            	</h2>
            </caption>
	</center>
    <div align="center">
		<c:if test="${service != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${service == null}">
			<form action="insert" method="post">
        </c:if>
        <table class="table table-bordered">
   
        		<c:if test="${service != null}">
        			<input type="hidden" name="id" value="<c:out value='${service.id}' />" />
        		</c:if>            
            <tr>
                <th>Service Name</th>
                <td>
                	<input type="text" class="form-control" name="name"
                			value="<c:out value='${service.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Description</th>
                <td>
                	<input type="text" class="form-control" name="description"
                			value="<c:out value='${service.description}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Price</th>
                <td>
                	<input type="text" class="form-control-file" name="price"
                			value="<c:out value='${service.price}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit"  class="btn btn-primary"  value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
