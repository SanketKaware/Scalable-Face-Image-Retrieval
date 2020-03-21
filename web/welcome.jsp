<%-- 
    Document   : welcome
    Created on : Nov 27, 2014, 2:45:54 PM
    Author     : Owner
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.aissms.sfir.MainGui.code.MainFrame"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


        
        <%@ page import="java.sql.*" %>
<%@ page import="com.mysql.jdbc.Driver" %>
   
   <HTML>
    <HEAD>
        <TITLE>The tableName Database Table </TITLE>
    </HEAD>

    <BODY>
        
        <H1>The Database Table (use your generated ID while login......!) </H1>

        <% 
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/project", "root", "root");

            Statement statement = connection.createStatement() ;
            ResultSet resultset = 
                statement.executeQuery("select id,username,mobileno,email from userdb") ; 
        %>

        <TABLE BORDER="1">
            <TR>
                <TH>ID</TH>
                <TH>Name</TH>
                <TH>EMAIL</TH>
                
            </TR>
            <% while(resultset.next()){ %>
            <TR>
                <TD> <%= resultset.getInt("id") %></td>
                <TD> <%= resultset.getString("username") %></TD>
                <TD> <%= resultset.getString("email") %></TD>
            </TR>
            <% } %>
        </TABLE>
        
        <a href="logout.jsp" class="text-center">Logout</a><br><br>
        <a href="index.html" class="text-center">Home</a>
        
    </BODY>
</HTML>
  
       
   
