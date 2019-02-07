<%-- 
    Document   : coneccion
    Created on : 06-nov-2018, 11:18:26
    Author     : paul-PC
--%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@include file="conex.jsp"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <center>
              <h1>BUSQUEDA DE MAQUINARIA</h1>
        <form action="busqueda_maquinaria.jsp" method="post">
       <table border="2"> 
           <th colspan="3"> SELECCIONE LA MAQUINARIA:
            <select name="codigo">
                <%
                    PreparedStatement ps=conex.prepareStatement("select * from maquinaria");
                    ResultSet rs=ps.executeQuery();
                     while(rs.next()==true)
                    {
                %>
                <option value="<%out.print(rs.getString("codigo_m"));%>"><%out.print(rs.getString("nom_m"));%></option>
                <%}%>
            </select>
            <input type="submit" name="buscar" value="Buscar">
       </th> </form>
            
        <tr><th colspan="3">LISTADO MAQUINARIA</th></tr>
        <tr><th>CODIGO MAQUINARIA</th>
            <th>NOMBRE MAQUINARIA</th>
            <th>MARCA MAQUINARIA</th></tr>
        <%
            if(request.getParameter("buscar")!=null)
            {
                int c=Integer.parseInt(request.getParameter("codigo"));
                PreparedStatement ps1=conex.prepareStatement("select * from maquinaria where codigo_m="+c+"");
                ResultSet rs1=ps1.executeQuery();
                while(rs1.next()==true) 
                {%>
                <tr><td><%out.print(rs1.getString("codigo_m"));%></td>
                    <td><%out.print(rs1.getString("nom_m"));%></td>
                    <td><%out.print(rs1.getString("marca_m"));%></td></tr>  
                <% } }%>

        </table>
       </center>
    </body>
</html>
