<%-- 
    Document   : ver_detalle_reunion
    Created on : 15-ene-2019, 16:51:26
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
        <h1>DETALLE DE LA INFORMACION DE LA REUNION SELECCIONADO</h1>
        <%@include file="coneccion.jsp"%>
        <%
          try
          {
              String i=request.getParameter("id");
            String sql= "SELECT * FROM REUNION WHERE COD_REUN='"+i+"'";
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
                            <th>CODIGO </th>
                            <TD><%out.print(busc.getString("COD_REUN"));%></TD>
                        </tr>   
                        <tr>
                            <th>MOTIVO</th>
                            <TD><%out.print(busc.getString("ASUNTO_REUN"));%></TD>
                        </tr>   
                        <tr>
                            <th>FECHA</th>
                            <TD><%out.print(busc.getString("FECHA_REUN"));%></TD>
                        </tr>  
                         <tr>
                             <th>HORA</th>
                            <TD><%out.print(busc.getString("HORA_REUN"));%></TD>
                        </tr>  
                        <tr>
                             <th>LUGAR</th>
                            <TD><%out.print(busc.getString("LUGAR_REUN"));%></TD>
                        </tr> 
                        <tr>
                             <th>QUIEN CONVOCO</th>
                            <TD><%out.print(busc.getString("QUIEN"));%></TD>
                        </tr> 

<tr>
                             <th> A QUIEN CONVOCO</th>
                            <TD><%out.print(busc.getString("A_QUIEN"));%></TD>
                        </tr>                         <%
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

