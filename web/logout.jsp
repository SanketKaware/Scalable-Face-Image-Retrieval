<%-- 
    Document   : error
    Created on : Nov 27, 2014, 2:45:33 PM
    Author     : Owner
--%>

<%@page import="com.aissms.sfir.MainGui.code.MainFrame"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Logout successfully done......!</h1>
    </body>
</html>
<%

response.sendRedirect("index.html");
System.exit(0);

%>