<%-- 
    Document   : ver_detalle_local
    Created on : 15-ene-2019, 11:40:14
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
        <h1>DETALLE DE LA INFORMACION DEL LOCAL SELECCIONADO</h1>
        <%@include file="coneccion.jsp"%>
        <%
          try
          {
              String i=request.getParameter("id");
            String sql= "SELECT * FROM LOCAL WHERE NUM_LOCAL='"+i+"'";
            PreparedStatement consulta=conex.prepareStatement(sql);
            ResultSet busc= consulta.executeQuery();
          
        %>
    <center>
        <table border="1">
           
            <%
                while (busc.next())
                {
                    
                
                        %>
                        <tr>
                            <th>NUMERO LOCAL</th>
                            <TD><%out.print(busc.getString("NUM_LOCAL"));%></TD>
                        </tr>   
                        <tr>
                            <th>DESCRIPCION LOCAL</th>
                            <TD><%out.print(busc.getString("DESC_LOCAL"));%></TD>
                        </tr>   
                        <tr>
                            <th>DIMENSION LOCAL</th>
                            <TD><%out.print(busc.getString("DIMEN_LOCAL"));%></TD>
                        </tr>  
                         <tr>
                            <th>CODIGO DEL SOCIO</th>
                            <TD><%out.print(busc.getString("ID_SOCIO"));%></TD>
                        </tr>  
                        <%
                            }
                    }
                           catch(Exception e)
                                {
                                     out.print("Error al eliminar"+e);
                                }
                        %>
                        
        </table>
    </center>
        
    </body>
</html>
