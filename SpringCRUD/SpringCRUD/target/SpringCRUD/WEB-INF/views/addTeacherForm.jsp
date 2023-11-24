<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Teacher Form</title>
</head>
<body>

    <h2>Add Teacher Form</h2>

    <form:form method="POST" modelAttribute="teacher" action="${pageContext.request.contextPath}/teachers/add">
        <label for="name">Name:</label>
        <form:input path="name" id="name" /> <br />

        <label for="expertise">Expertise:</label>
        <form:input path="expertise" id="expertise" /> <br />

        <input type="submit" value="Add Teacher" />
    </form:form>

</body>
</html>