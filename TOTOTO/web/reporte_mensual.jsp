<%-- 
    Document   : reporte_mensual
    Created on : 29-ene-2019, 10:54:55
    Author     : DELL
--%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="coneccion.jsp"%>
        <form action="reporte_mensual.jsp" method="post">
            <center>
            <table border="2">
                <tr>
                    <th colspan="13">---------REPORTE MENSUAL-----------<th>
                </tr>
                
                    <th colspan="8"><a href="nuevo_cobro.jsp"><img src="imagen/descarga.png" height="50" width="50" ></a></th>
               
                <tr><th>NUMERO MENSUAL</th>
                    <th>FECHA QUE CANCELO</th>
                    <th>MES CANCELADO</th>
                    <th>NUMERO DE LOCAL</th>
                    
                    <th colspan="4">ACCION</th>
                </tr>
                <%
                    PreparedStatement ps=conex.prepareStatement("SELECT* FROM COBRO");
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()==true) 
                {
                    try
                    {
                %>
                <tr>
                    <td><%out.print(rs.getString("NUM_MENS"));%></td>
                    <td><%out.print(rs.getString("FECHA_MENS"));%></td>
                      <td><%out.print(rs.getString("NUM_COBADOR"));%></td>
                    <td><img src="imagen/images.png" height="50" width="50" ></td>
                    <td><img src="imagen/descarga.png" height="50" width="50" ></td>
                    <td><img src="imagen/51418.png" height="50" width="50" ></td>
                    <td><img src="imagen/abcd.png" height="50" width="50" ></td>
                     </tr>
                <%
                    } 
                
            catch(Exception e)
        {
            out.print("ERROR AL GUARDAR "+e);
        }
}      %>
            </table>
            </center>
        </form>
    </body>
</html>

