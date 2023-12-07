<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Upload File Request Page</title>
</head>
<body>
    <form action="/app/home/uploadFile" method="post" enctype="multipart/form-data">
        <input type="text" name="name" value="YourName" />
        <input type="file" name="file" />
        <button type="submit">Upload</button>
    </form>
</body>
</html>
