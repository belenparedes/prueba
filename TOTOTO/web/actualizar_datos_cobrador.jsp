<%-- 
    Document   : actualizar_datos_cobrador
    Created on : 09-ene-2019, 13:35:12
    Author     : DELL
--%>
 
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="coneccion.jsp"%>
        <% 
                  
              if(request.getParameter("actualizar")!=null)
                {
               String cod_co=request.getParameter("cod_c");
               String ced=request.getParameter("cedula");
               String nom=request.getParameter("nombre");
               String dir=request.getParameter("direccion");
               String telf=request.getParameter("telefono");
               String email=request.getParameter("email");
               String obs=request.getParameter("observacion");
                               
try{             

    String sql="update COBRADOR set CED_COB='"+ced+"',NOM_COB='"+nom+"',DIRC_COB='"+dir+"',TELF_COB='"+telf+"',EMAIL_COB='"+email+"',OBSERVACION_COB='"+obs+"' where NUM_COBRADOR='"+cod_co+"'";
    PreparedStatement ps1=conex.prepareStatement(sql);
    ps1.executeUpdate();
    
  response.sendRedirect("reporte_cobrador.jsp");

}
catch(Exception e)
    
{
    out.print("Error al actualizar");
}
                }

                     %>
    </body>
</html>
