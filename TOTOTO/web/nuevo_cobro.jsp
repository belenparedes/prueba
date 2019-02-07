<%-- 
    Document   : nuevo_cobro
    Created on : 29-ene-2019, 11:18:14
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
        <h1>NUEVO COBRO DE MENSUAL</h1>
        <form action="nuevo_cobro.jsp" method="post">
<table border="5">
    <tr><th COLSPAN ="2">---------NUEVO COBRO DE MENSUALIDAD---------</th></tr>
    <TR><td>NUMERO MENSUAL</td><td><input type="text" name="codigo"  VALUE="<% PreparedStatement ps=conex.prepareStatement("Select max(NUM_MENS +1) NUM_MMENS from MENSUALIDAD");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
    {
        out.print(rs.getString("NUM_MENS"));
}
%>"></td></TR>
    <tr><td>FECHA QUE COBRO:</td> <td><input type="text" name="fecham" class="campofecha" size="12"></td></tr>
    <TR><td>MES QUE HA CANCELADO:</td><td><input type="text" name="mes" ></td></TR>
    <TR><td>VALOR A CANCELAR</td><td><input type="text" name="valor"></td></TR>
    <TR><td>MULTA:</td><td><input type="text" name="multa"></td></TR>
    <TR><td>TOTAL MENSUAL:</td><td><input type="text" name="total"></td></TR>
    <TR><td>NUMERO LOCAL:</td><td><input type="text" name="local"></td></TR>
    <TR><td>CODIGO DEL COBRADOR:</td><td><input type="text" name="cobrador"></td></TR>
    <TR><td><input type="submit" name="ingreso" value="INGRESAR"></td><td><input type="reset" name="limpio" value="LIMPIAR"></td></TR>
</table>
</form>
        <%  

            %>
        
        <%
       
        if(request.getParameter("ingreso")!=null)
    {
    int cod_mens=Integer.parseInt(request.getParameter("codigo"));
    String fecha=request.getParameter("fecham");
    String mess=request.getParameter("mes");
    double  valorm=Double.parseDouble("valor");
    double  multam=Double.parseDouble("multa");
    double  totalm=Double.parseDouble("total");
    String num_lo=request.getParameter("local");
    String num_co=request.getParameter("cobrador");
        try
        {
            CallableStatement cs=conex.prepareCall("{ call sp_nuevo_cobro(?,?,?,?,?,?,?,?)}");
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

