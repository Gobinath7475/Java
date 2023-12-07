<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Student Form</title>
</head>
<body>

    <h2>Edit Student Form</h2>

    <form:form method="POST" modelAttribute="student" action="${pageContext.request.contextPath}/students/update/${student.sid}">
        <label for="sname">Name:</label>
        <form:input path="sname" id="sname" /> <br />

        <label for="sdept">Department:</label>
        <form:input path="sdept" id="sdept" /> <br />

        <input type="submit" value="Update Student" />
    </form:form>

</body>
</html>
