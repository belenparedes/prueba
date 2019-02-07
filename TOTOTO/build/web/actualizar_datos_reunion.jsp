<%-- 
    Document   : actualizar_datos_reunion
    Created on : 15-ene-2019, 16:11:24
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
               int cod=Integer.parseInt(request.getParameter("cod_r"));
               String motivo=request.getParameter("moti");
               String fecha=request.getParameter("fe");
               String hora=request.getParameter("horas");
               String lugar=request.getParameter("lugarr");
               String convoco=request.getParameter("convo");
               String quien_convo1=request.getParameter("quienconvo");
                               
try{             

    String sql="update REUNION set ASUNTO_REUN='"+motivo+"',FECHA_REUN='"+fecha+"',HORA_REUN='"+hora+"',LUGAR_REUN='"+lugar+"',QUIEN='"+convoco+"', A_QUIEN='"+quien_convo1+"' where COD_REUN="+cod+"";
    PreparedStatement ps1=conex.prepareStatement(sql);
    ps1.executeUpdate();
    
  response.sendRedirect("reporte_reunion.jsp");

}
catch(Exception e)
    
{
    out.print("Error al actualizar"+e);
}
                }

                     %>

    </body>
</html>
