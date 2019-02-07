<%-- 
    Document   : eliminar_reunion
    Created on : 15-ene-2019, 16:40:35
    Author     : DELL
--%>
<%@page import="java.sql.CallableStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%@include file="coneccion.jsp" %>     
    <%
        try
        {
            String i=request.getParameter("id");
            String sql= "DELETE FROM REUNION WHERE COD_REUN='"+i+"'";
            PreparedStatement operacion=conex.prepareStatement(sql);
            operacion.executeUpdate();
            
           %>
           <script>
        alert("SE HA ELIMINADO");
        window.location="reporte_reunion.jsp";
    </script>
           <%
        }
        catch(Exception e)
{
    out.print("Error al eliminar"+e);
}
    %>
    </body>
</html>
