<%-- 
    Document   : coneccion
    Created on : 09-ene-2019, 9:52:39
    Author     : DELL
--%>

<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.sql.Connection"
        import="java.sql.DriverManager"
        import="java.sql.PreparedStatement"
        import="java.sql.ResultSet"
        import="java.sql.Statement"
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
        Connection conex=null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://DESKTOP-I8RSKA1;"+"database=ASOCIACION_5J;"+"user=sa;"+"password=uti2017;";
            conex=DriverManager.getConnection(connectionURL);
            out.print(" CONECCION");  
        }
        catch(Exception e)
        {
            out.print("ERROR EN LA CONECCION");  
        }
%>
    </body>
</html>
