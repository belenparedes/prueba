<%-- 
    Document   : eliminar
    Created on : 15-ene-2019, 10:51:51
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
            String sql= "DELETE FROM LOCAL WHERE NUM_LOCAL='"+i+"'";
            PreparedStatement operacion=conex.prepareStatement(sql);
            operacion.executeUpdate();
            //response.sendRedirect("REPORTE_LOCAL.jsp");
           %>
           <script>
        alert("SE HA ELIMINADO");
        window.location="REPORTE_LOCAL.jsp";
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
