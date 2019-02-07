<%-- 
    Document   : ingreso_mensualidad
    Created on : 09-ene-2019, 9:53:27
    Author     : DELL
--%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
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
        <h1>INGRESO NUEVO LOCAL</h1>
        <form action="ingreso_local.jsp" method="post">
<table border="5">
    <tr><th COLSPAN ="2">---------NUEVO LOCAL---------</th></tr>
    <TR><td>NUMERO LOCAL</td><td><input type="text" name="codigo"  VALUE="<% PreparedStatement ps=conex.prepareStatement("Select max(NUM_LOCAL ) NUM_LOCAL from LOCAL");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
    {
        out.print(rs.getString("NUM_LOCAL"));
}
%>"></td></TR>
    <TR><td>DESCRIPCION</td><td><input type="text" name="des"></td></TR>
    <TR><td>DIMENCION</td><td><input type="text" name="dimen"></td></TR>
    <TR><td>CODIGO DEL SOCIO</td><td><select name="cod_socio">
                            <%
                            PreparedStatement p=conex.prepareStatement("select * from SOCIO");
                            ResultSet r=p.executeQuery();
                            while(r.next()==true)
                            {
                            %>
                            <option value="<% out.print(r.getString("ID_SOCIO")); %>"> <% out.print(r.getString("NOM_SOCIO")); %></option>
                            <%
                            }
                            %></select></td></TR>
    <TR><td><input type="submit" name="ingreso" value="INGRESAR"></td><td><input type="reset" name="limpio" value="LIMPIAR"></td></TR>
</table>
</form>
        
        <%
       
        if(request.getParameter("ingreso")!=null)
    {
    String id_m=request.getParameter("codigo");
    String des=request.getParameter("des");
    int dimen=Integer.parseInt(request.getParameter("dimen"));
    int cod_s=Integer.parseInt(request.getParameter("cod_socio"));
        try
        {
            CallableStatement cs=conex.prepareCall("{ call sp_ingreso_local(?,?,?,?)}");
            cs.setString(1,id_m);
            cs.setString(2,des);
            cs.setInt(3,dimen);
            cs.setInt(4,cod_s);       
            
            cs.execute();
        response.sendRedirect("reporte_local.jsp");
         
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
