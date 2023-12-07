<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher Form</title>
</head>
<style>
	body {
	 font-family: 'Roboto', sans-serif;
	 background-color: #f8f9fa;
	 margin: 0;
	 padding: 0;
 }
 
 .container {
	 width: 80%;
	 margin: 20px auto;
 }
 
 a {
	 text-decoration: none;
	 color: #007bff;
 }
 
 h3 {
	 color: #343a40;
 }
 
 table {
	 width: 100%;
	 border-collapse: collapse;
	 margin-top: 20px;
	 background-color: #fff;
	 box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
 }
 
 thead {
	 background-color: #007bff;
	 color: #fff;
 }
 
 th, td {
	 padding: 15px;
	 text-align: left;
	 border-bottom: 1px solid #dee2e6;
 }
 
 tbody tr:hover {
	 background-color: #f2f5f8;
 }
 
 .actions a {
	 color: #28a745;
	 margin-right: 10px;
	 transition: color 0.3s;
 }
 
 .actions a:hover {
	 color: #218838;
 }
 
 .add-link {
	 display: block;
	 margin-top: 20px;
	 padding: 10px;
	 background-color: #28a745;
	 color: #fff;
	 text-align: center;
	 text-transform: uppercase;
	 border-radius: 5px;
	 text-decoration: none;
	 transition: background-color 0.3s;
 }
 
 .add-link:hover {
	 background-color: #218838;
 }
 
 </style>
<body>
    <a href="<c:url value='/teachers/add'/>">Add Teacher</a>

				<c:choose>
					<c:when test="${teachers != null}">
						<h3>List of Teachers</h3>
						<table cellpadding="5" cellspacing="5">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Expertise</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="t" items="${teachers}">
									<tr>
										<td>${t.id}</td>
										<td>${t.name}</td>
										<td>${t.expertise}</td>
										<td><a href="<%=request.getContextPath()%>/teachers/Update/${t.id}">Update</a>
											&nbsp; <a href="<%=request.getContextPath()%>/teachers/delete/${t.id}"
												onclick="return confirm('Do you really want to delete?')">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						No User found in the DB!
					</c:otherwise>
				</c:choose>
			</body>

			</html>