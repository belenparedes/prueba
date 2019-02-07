<%-- 
    Document   : REPORTE_LOCAL
    Created on : 09-ene-2019, 10:28:21
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
        <form action="REPORTE_LOCAL.jsp" method="post">
            <center>
            <table border="2">
                <tr>
                    <th colspan="13">---------REPORTE LOCAL-----------<th>
                </tr>
                <tr>
                    <th colspan="7"><a href="ingreso_local.jsp"><img src="imagen/descarga.png" height="50" width="50" ></a></th>
                </tr>
                <tr><th>NUMERO LOCAL</th>
                    <th>DESCRIPCION</th>
                    <th>SOCIO</th>
                    <th colspan="3">ACCION</th>
                </tr>
                <%
                    PreparedStatement ps=conex.prepareStatement("SELECT LOCAL.*, NOM_SOCIO FROM LOCAL, SOCIO WHERE LOCAL.ID_SOCIO=SOCIO.ID_SOCIO");
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()==true) 
                {
                    try
                    {
                %>
                <tr>
                    <td><%out.print(rs.getString("NUM_LOCAL"));%></td>
                    <td><%out.print(rs.getString("DESC_LOCAL"));%></td>
                     <td><%out.print(rs.getString("NOM_SOCIO"));%></td>
                    <td><a href="actualizar_local.jsp?id=<%=rs.getString("NUM_LOCAL")%>"><img src="imagen/images.png" height="50" width="50" ></a></td>
                    <td><a href="ver_detalle_local.jsp?id=<%=rs.getString("NUM_LOCAL")%>"><img src="imagen/descarga.png" height="50" width="50" ></a></td>
                    <td><a href="eliminar.jsp?id=<%=rs.getString("NUM_LOCAL")%>"><img src="imagen/51418.png" height="50" width="50" ></a></td>
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

