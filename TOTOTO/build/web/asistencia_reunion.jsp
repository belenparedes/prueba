<%-- 
    Document   : asistencia_reunion
    Created on : 15-ene-2019, 12:26:25
    Author     : DELL
--%>

<%@page import="java.sql.CallableStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h1>REUNION</h1>
            <%@include file="coneccion.jsp" %>
           
    <center>
        <form action="asistencia_reunion.jsp" method="post">
            <table border="1">
                
                <tr><td>CODIGO DE REUNION:</td> <td><input type="text" name="codigo" VALUE="<% PreparedStatement ps=conex.prepareStatement("Select max(COD_REUN +1) COD_REUN from REUNION");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
    {
        out.print(rs.getString("COD_REUN"));
}
%>"></td></TR>
                <tr><td>MOTIVO DE REUNION:</td> <td><input type="text" name="motivo"></td></tr>
                <tr><td>FECHA REUNION:</td> <td><input type="text" name="fechas" class="campofecha" size="12"></td></tr>
                <tr><td>HORA DE REUNION:</td> <td><input type="text" name="horar"></td></tr>
                <tr><td>LUGAR DE REUNION:</td> <td><input type="text" name="lugarr"></td></tr>
                <tr><td>QUIEN CONVOCA:</td> <td><input type="text" name="quienc"></td></tr>
                 <tr><td> A QUIEN CONVOCA:</td> <td><select name="cod_aso">
                            <%
                            PreparedStatement p=conex.prepareStatement("select * from ASOCIACION");
                            ResultSet r=p.executeQuery();
                            while(r.next()==true)
                            {
                            %>
                            <option value="<% out.print(r.getString("NOM_ASO")); %>"> <% out.print(r.getString("NOM_ASO")); %></option>
                            <%
                            }
                            %></select></td></TR>
                 <TR><td><input type="submit" name="ingreso" value="INGRESAR"></td><td><input type="reset" name="limpio" value="LIMPIAR"></td></TR>
             </table>
        </form> 
                  <%
       
        if(request.getParameter("ingreso")!=null)
    {
    int id_r=Integer.parseInt(request.getParameter("codigo"));
    String motivo=request.getParameter("motivo");
    String fecha=request.getParameter("fechas");
    String lugar=request.getParameter("lugarr");
    String hora=request.getParameter("horar");
    String convoc=request.getParameter("quienc");
    String aquiconvo=request.getParameter("cod_aso");
        try
        {
            CallableStatement cs=conex.prepareCall("{ call sp_ingreso_reunion(?,?,?,?,?,?,?)}");
            cs.setInt(1,id_r);
            cs.setString(2,motivo);
            cs.setString(3,fecha);
            cs.setString(5,hora);
            cs.setString(4,lugar);
            cs.setString(6,convoc);
            cs.setString(7,aquiconvo);
            
            cs.execute();
        response.sendRedirect("reporte_reunion.jsp");
        
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
