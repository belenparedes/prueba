<%-- 
    Document   : ingreso_cobrador
    Created on : 09-ene-2019, 10:57:20
    Author     : DELL
--%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.CallableStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta charset="utf-8" /> 
      <link href="calendario_dw/calendario_dw-estilos.css" type="text/css" rel="STYLESHEET">
	<style type="text/css">
	body{
		font-family: tahoma, verdana, sans-serif;
	}
	</style>
	<script type="text/javascript" src="calendario_dw/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="calendario_dw/calendario_dw.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		$(".campofecha").calendarioDW();
	})
	</script>
    </head>
    <body>
        <%@include file="coneccion.jsp"%>
    <center>
        <h1>INGRESO DE NUEVO COBRADOR</h1>
        <form action="ingreso_cobrador.jsp" method="post">
<table border="5">
    <tr><th COLSPAN ="2">---------NUEVO COBRADOR---------</th></tr>
    <TR><td>NUMERO COBRADOR</td><td><input type="text" name="codigo"  VALUE="<% PreparedStatement ps=conex.prepareStatement("Select max(NUM_COBRADOR +1) NUM_COBRADOR from COBRADOR");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
    {
        out.print(rs.getString("NUM_COBRADOR"));
}
%>"></td></TR>
    <TR><td>CEDULA</td><td><input type="text" name="ced"></td></TR>
    <TR><td>NOMBRE</td><td><input type="text" name="nomb"></td></TR>
    <TR><td>DIRECCION</td><td><input type="text" name="dirc"></td></TR>
    <TR><td>TELEFONO</td><td><input type="text" name="telf"></td></TR>
    <TR><td>EMAIL</td><td><input type="text" name="ema"></td></TR>
    <TR><td>OBSERVACION</td><td><input type="text" name="obs"></td></TR>
    <TR><td><input type="submit" name="ingreso" value="INGRESAR"></td><td><input type="reset" name="limpio" value="LIMPIAR"></td></TR>
</table>
</form>
        <%  

            %>
        
        <%
       
        if(request.getParameter("ingreso")!=null)
    {
    int id_c=Integer.parseInt(request.getParameter("codigo"));
    String cedu=request.getParameter("ced");
    String nom=request.getParameter("nomb");
    String direc=request.getParameter("dirc");
    String telfo=request.getParameter("telf");
    String email=request.getParameter("ema");
    String obser=request.getParameter("obs");
        try
        {
            CallableStatement cs=conex.prepareCall("{ call sp_ingreso_cobrador(?,?,?,?,?,?,?)}");
            cs.setInt(1,id_c);
            cs.setString(2,cedu);
            cs.setString(3,nom);
            cs.setString(4,direc);
            cs.setString(5,telfo);
            cs.setString(6,email);
            cs.setString(7,obser);
            
            cs.execute();
        response.sendRedirect("reporte_cobrador.jsp");
       
        }
        catch(Exception e)
        {
            out.print("ERROR AL GUARDAR "+e);
        }
    } 
%>
    </center>
    
    </body>
</html>
