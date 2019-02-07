<%-- 
    Document   : maquinaria
    Created on : 05-feb-2019, 9:03:36
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.sql.Connection"
        import="java.sql.DriverManager"
        import="java.sql.PreparedStatement"
        import="java.sql.ResultSet"
        import="java.sql.Statement"
        %>
 <%@include file="coneccion.jsp"%>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
    <center>
        <h1>INGRESO DE NUEVA MAQUINARIA</h1>
        <form action="maquinaria.jsp" method="post">
<table border="2">
    <tr><th COLSPAN ="2">NUEVA MAQUINARIA</th></tr>
    <TR><td>NUMER0 MAQUINARIA</td><td><input type="text" name="codigo"></td></TR>
    <TR><td>NOMBRE MAQUINARIA</td><td><input type="text" name="nom"></td></TR>
    <TR><td>MARCA MAQUINARIA </td><td><input type="text" name="marc"></td></TR>
    <TR><td><input type="submit" name="ingreso" value="INGRESAR"></td></TR>
</table>
</form>
        <%
       
        if(request.getParameter("ingreso")!=null)
    {
    int cod=Integer.parseInt(request.getParameter("codigo"));
    String nomb_m=request.getParameter("nom");
    String marc=request.getParameter("marc");
        try
        {
            PreparedStatement ps2=conex.prepareStatement("insert into maquinaria values ("+cod+",'"+nomb_m+"','"+marc+"')");                
            ps2.execute();
    } 
catch (Exception e)
{
    out.print("error" +e);
}
}
%>
    </center>
    
    </body>
</html>
