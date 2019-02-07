<%-- 
    Document   : actualizar_datos
    Created on : 09-ene-2019, 13:21:37
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
              <%@include file="coneccion.jsp" %>        
        <% 
                  
              if(request.getParameter("actualizar")!=null)
                {
               String cod=request.getParameter("cod");
               String desc=request.getParameter("desc");
               float dim=Float.parseFloat(request.getParameter("dim"));
               int cod_s=Integer.parseInt(request.getParameter("cod_so"));
                 
try{             

    String sql="update LOCAL set DESC_LOCAL='"+desc+"',DIMEN_LOCAL="+dim+",ID_SOCIO="+cod_s+"  where NUM_LOCAL='"+cod+"'";
    PreparedStatement psa=conex.prepareStatement(sql);
    psa.executeUpdate();
    
  response.sendRedirect("REPORTE_LOCAL.jsp");
}
catch(Exception e)
    
{
    out.print("Error al actualizar");
}
                        }

                     %>
    </body>
</html>
