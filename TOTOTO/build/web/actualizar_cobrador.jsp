<%-- 
    Document   : actualizar_cobrador
    Created on : 09-ene-2019, 11:50:11
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
        <h1>Actualizacion de un Socio</h1>
        <form action="actualizar_datos_cobrador.jsp" method="post"> 

            <table>
            <%
               int i=Integer.parseInt(request.getParameter("id"));
               PreparedStatement ps=conex.prepareStatement("select * from COBRADOR where NUM_COBRADOR="+i);
               ResultSet rs=ps.executeQuery();
               
            while(rs.next()){
            %>
                <tr><th></th></tr>              
                <tr><td> CODIGO</td><td><input type="text" name="cod_c" value="<%out.print(Integer.parseInt(rs.getString("NUM_COBRADOR")));%>"></td></tr>               
                <tr><td>CEDULA</td><td><input type="text" name="cedula" value="<%out.print(rs.getString("CED_COB"));%>"></td></tr>
                <tr><td>NOMBRE</td><td><input type="text" name="nombre" value="<%out.print(rs.getString("NOM_COB"));%>"></td></tr>
                <tr><td> DIRECCION</td><td><input type="text" name="direccion" value="<%out.print(rs.getString("DIRC_COB"));%>"></td></tr>
                <tr><td> TELEFONO</td><td><input type="text" name="telefono" value="<%out.print(rs.getString("TELF_COB"));%>"></td></tr>
                <tr><td>EMAIL</td><td><input type="text" name="email" value="<%out.print(rs.getString("EMAIL_COB"));%>"></td></tr>
                <tr><td> OBSERVACION</td><td><input type="text" name="observacion" value="<%out.print(rs.getString("OBSERVACION_COB"));%>" ></td></tr>
                <tr><td><input type="submit" name="actualizar" value="actualizar"></td><td><input type="reset" name="limpiar" value="limpiar"></td></tr>
            </table>
           </form>
    </center><form>
              <% 
                  }
              if(request.getParameter("actualizar")!=null)
                {
               
               String ced=request.getParameter("cedula");
               String nom=request.getParameter("nombre");
               String dir=request.getParameter("direccion");
               String telf=request.getParameter("telefono");
               String email=request.getParameter("email");
               String obs=request.getParameter("observacion");
                               
try{             

    String sql="update COBRADOR set CED_COB='"+ced+"',NOM_COB='"+nom+"',DIRC_COB='"+dir+"',TELF_COB='"+telf+"',EMAIL_COB='"+email+"',OBSERVACION_COB='"+obs+"'";
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
             </form>   
    </body>
</html>