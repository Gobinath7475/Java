<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher Form</title>
</head>
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