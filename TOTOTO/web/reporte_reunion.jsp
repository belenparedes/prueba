<%-- 
    Document   : reporte_reunion
    Created on : 15-ene-2019, 15:39:30
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
        <form action="reporte_reunion.jsp" method="post">
            <center>
            <table border="2">
                <tr>
                    <th colspan="13">---------REPORTE REUNION-----------<th>
                </tr>
                <tr>
                    <th colspan="7"><a href="asistencia_reunion.jsp"><img src="imagen/descarga.png" height="50" width="50" ></a></th>
                </tr>
                <tr><th>CODIGO</th>
                    <th>ASUNTO</th>
                    <th>FECHA</th>
                    
                    <th colspan="4">ACCION</th>
                </tr>
                <%
                    PreparedStatement ps=conex.prepareStatement("SELECT* FROM REUNION");
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()==true) 
                {
                    try
                    {
                %>
                <tr>
                    <td><%out.print(rs.getString("COD_REUN"));%></td>
                    <td><%out.print(rs.getString("ASUNTO_REUN"));%></td>
                     <td><%out.print(rs.getString("FECHA_REUN"));%></td>
                    <td><a href="actualizar_reunion.jsp?id=<%=rs.getString("COD_REUN")%>"><img src="imagen/images.png" height="50" width="50" ></a></td>
                    <td><a href="ver_detalle_reunion.jsp?id=<%=rs.getString("COD_REUN")%>"><img src="imagen/descarga.png" height="50" width="50" ></a></td>
                    <td><a href="eliminar_reunion.jsp?id=<%=rs.getString("COD_REUN")%>"><img src="imagen/51418.png" height="50" width="50" ></a></td>
                    <td><a href="asistencia.jsp?id=<%=rs.getString("COD_REUN")%>"><img src="imagen/abcd.png" height="50" width="50" ></a></td>
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

