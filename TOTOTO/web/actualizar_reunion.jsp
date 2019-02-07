<%-- 
    Document   : actualizar_reunion
    Created on : 15-ene-2019, 15:52:37
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
    <center>
        <h1>Actualizacion</h1>
        <form action="actualizar_datos_reunion.jsp" method="post"> 

            <table>
            <%
               int i=Integer.parseInt(request.getParameter("id"));
               PreparedStatement ps=conex.prepareStatement("select * from REUNION where COD_REUN="+i);
               ResultSet rs=ps.executeQuery();
               
            while(rs.next()){
            %>
                <tr><th></th></tr>              
                <tr><td> CODIGO</td><td><input type="text" name="cod_r" value="<%out.print(Integer.parseInt(rs.getString("COD_REUN")));%>"></td></tr>               
                <tr><td>MOTIVO</td><td><input type="text" name="moti" value="<%out.print(rs.getString("ASUNTO_REUN"));%>"></td></tr>
                <tr><td>FECHA</td><td><input type="text" name="fe" value="<%out.print(rs.getString("FECHA_REUN"));%>"></td></tr>
                <tr><td> HORA</td><td><input type="text" name="horas" value="<%out.print(rs.getString("HORA_REUN"));%>"></td></tr>
                <tr><td> LUGAR</td><td><input type="text" name="lugarr" value="<%out.print(rs.getString("LUGAR_REUN"));%>"></td></tr>
                <tr><td>QUIEN CONVOCO</td><td><input type="text" name="convo" value="<%out.print(rs.getString("QUIEN"));%>"></td></tr>
                <tr><td>A QUIEN CONVOCO</td><td><input type="text" name="quienconvo" value="<%out.print(rs.getString("A_QUIEN"));%>" ></td></tr>
                <tr><td><input type="submit" name="actualizar" value="actualizar"></td><td><input type="reset" name="limpiar" value="limpiar"></td></tr>
            </table>
           </form>
    </center><form>
              <% 
                  }
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

    String sql="update REUNION set ASUNTO_REUN='"+motivo+"',FECHA_REUN='"+fecha+"',HORA_REUN='"+hora+"',LUGAR_REUN='"+lugar+"',QUIEN='"+convoco+"',A_QUIEN='"+quien_convo1+"' where COD_REUN="+i+"";
    PreparedStatement ps1=conex.prepareStatement(sql);
    ps1.executeUpdate();
    
  response.sendRedirect("reporte_reunion.jsp");

}
catch(Exception e)
    
{
    out.print("Error al actualizar");
}
                }

                     %>
             </form>   
    </body>
</html>