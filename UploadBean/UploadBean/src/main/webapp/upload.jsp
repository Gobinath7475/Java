<%
try {
    String filename = "home.jsp";
    String filepath = "e:\\";

    // Replace backslashes with forward slashes to avoid escaping issues
    filepath = filepath.replace("\\", "/");

    response.setContentType("application/octet-stream");
    response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath + filename);

    int i;
    while ((i = fileInputStream.read()) != -1) {
        out.write(i);
    }
    fileInputStream.close();
} catch (Exception e) {
    out.print("Error: " + e.getMessage());
}
%>
