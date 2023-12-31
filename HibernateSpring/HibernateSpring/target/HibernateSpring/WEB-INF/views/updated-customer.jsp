<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Customer</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
    <div class="container">
        <div class="col-md-offset-2 col-md-7">
            <h2 class="text-center">Update Customer</h2>
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title">Customer Details</div>
                </div>
                <div class="panel-body">
                    <form:form action="saveCustomer" cssClass="form-horizontal" method="post" modelAttribute="customer">
                        <!-- hidden field for id -->
                        <form:hidden path="id" />
                        <div class="form-group">
                            <label for="firstname" class="col-md-3 control-label">First Name</label>
                            <div class="col-md-9">
                                <form:input path="firstName" cssClass="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastname" class="col-md-3 control-label">Last Name</label>
                            <div class="col-md-9">
                                <form:input path="lastName" cssClass="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-md-3 control-label">Email</label>
                            <div class="col-md-9">
                                <form:input path="email" cssClass="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <!-- Button -->
                            <div class="col-md-offset-3 col-md-9">
                                <form:button cssClass="btn btn-primary">Update</form:button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>