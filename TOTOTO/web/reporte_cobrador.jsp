<%-- 
    Document   : reporte_cobrador
    Created on : 09-ene-2019, 11:04:18
    Author     : DELL
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="coneccion.jsp"%>
        <form action="reporte_cobrador" method="post">
            <table border="2">
                <tr>
                    <th colspan="13">---------REPORTE COBRADOR-----------<th>
                </tr>
                <tr>
                    <th colspan="13"><a href="ingreso_cobrador.jsp"><img src="imagen/descarga.png" height="50" width="50" ></a></th>
                </tr>
                <tr><th>CODIGO</th>
                    <th>CEDULA</th>
                    <th>NOMBRE</th>
                    <th>DIRECCION</th>
                    <th>TELEFONO</th>
                    <th>EMAIL</th>
                    <th>OBSERVACION</th>
                    <th colspan="3">ACCION</th>
                </tr>
                <%
                    PreparedStatement ps=conex.prepareStatement("select * from COBRADOR");
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()==true) 
                {
                    try
                    {
                %>
                <tr>
                    <td><%out.print(rs.getString("NUM_COBRADOR"));%></td>
                    <td><%out.print(rs.getString("CED_COB"));%></td>
                    <td><%out.print(rs.getString("NOM_COB"));%></td>
                    <td><%out.print(rs.getString("DIRC_COB"));%></td>
                    <td><%out.print(rs.getString("TELF_COB"));%></td>
                    <td><%out.print(rs.getString("EMAIL_COB"));%></td>
                    <td><%out.print(rs.getString("OBSERVACION_COB"));%></td>
                    <td><a href="actualizar_cobrador.jsp?id=<%=rs.getString("NUM_COBRADOR")%>"><img src="imagen/descarga.png" height="50" width="50" ></a></td>
                    <td><img src="imagen/images.png" height="50" width="50" ></td>
                    <td><img src="imagen/51418.png" height="50" width="50" ></td>
                </tr>
                <%
                    } 
                
            catch(Exception e)
        {
            out.print("ERROR AL GUARDAR "+e);
        }
}      %>
            </table>
        </form>
    </body>
</html>




