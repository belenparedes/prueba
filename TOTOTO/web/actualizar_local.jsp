<%-- 
    Document   : actualizar_local
    Created on : 09-ene-2019, 11:49:47
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
        <h1>ACTUALIZAR SOCIO</h1>
        <form action="actualizar_datos.jsp" method="post"> 

            <table>
            <%
               String i=request.getParameter("id");
               PreparedStatement ps=conex.prepareStatement("select * from LOCAL where NUM_LOCAL='"+i+"'");
               ResultSet rs=ps.executeQuery();
               
            while(rs.next()){
            %>
                <tr><th></th></tr>              
                <tr><td> CODIGO</td><td><input type="text" name="cod" value="<%out.print(rs.getString("NUM_LOCAL"));%>"></td></tr>
                <tr><td>DESCRIPCION</td><td><input type="text" name="desc" value="<%out.print(rs.getString("DESC_LOCAL"));%>"></td></tr>
                <tr><td>DIMENSION</td><td><input type="text" name="dim" value="<%out.print(Float.parseFloat(rs.getString("DIMEN_LOCAL")));%>"></td></tr>
                <tr><td> SOCIO</td><td><input type="text" name="cod_so" value="<%out.print(rs.getString("ID_SOCIO"));%>"></td></tr>
                <tr><td><input type="submit" name="actualizar" value="actualizar"></td><td><input type="reset" name="limpiar" value="limpiar"></td></tr>
            </table>
           </form>
          </center>
               
              <% 
                  }
              if(request.getParameter("actualizar")!=null)
                {
               
               String desc=request.getParameter("desc");
               float dim=Integer.getInteger(request.getParameter("dim"));
               int cod_s=Integer.parseInt(request.getParameter("cod_so"));
                 
try{             

    String sql="update LOCAL set DESC_LOCAL='"+desc+"',DIMEN_LOCAL="+dim+",ID_SOCIO="+cod_s+"  where NUM_LOCAL='"+i+"'";
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