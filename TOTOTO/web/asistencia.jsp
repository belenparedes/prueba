<%-- 
    Document   : asistencia
    Created on : 15-ene-2019, 18:04:42
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
        <h1>ASISTENCIA</h1>
        <form action="asistencia.jsp" method="post">
        <%@include file="coneccion.jsp"%>
        <center>
            <table>
                   <tr><td>ASOCIACION</td><td><select name="id_aso">
                      <%
                        PreparedStatement ps1=conex.prepareStatement("select * from ASOCIACION");
                ResultSet rs1=ps1.executeQuery();
                while (rs1.next()==true)
                {
            %>
                        <option value="<%out.print(rs1.getString("COD_ASO"));%>"> <%out.print(rs1.getString("NOM_ASO"));%></option>
                       <% }
                       %>         
                    </select></td><td><input type="submit" name="boton" value="BUSCAR"></td></tr>
            <%
        if(request.getParameter("boton")!=null)
        {
           String us= request.getParameter("id_aso");
           PreparedStatement pss=conex.prepareStatement("SELECT ID_SOCIO, NOM_SOCIO  FROM SOCIO,ASOCIACION  WHERE SOCIO.COD_ASO=ASOCIACION.COD_ASO AND ASOCIACION.COD_ASO='"+us+"'");
          ResultSet rs=pss.executeQuery();
          while (rs.next()==true)
          {
           %> 
                   <tr><td><%out.print(rs.getString("ID_SOCIO"));%></td><td><%out.print(rs.getString("NOM_SOCIO"));%></td><td><input type="checkBox" name="asisten" value="s"></td><td><input type="text" name="ojet"></td></tr>       
           <% }%> 
        <tr><td><input type="submit" name="guardar" value="GUARDAR"></td></tr>
               <% } 
        if(request.getParameter("guardar")!=null)
        {
    String id_so=request.getParameter("ID_SOCIO");
    int cod_re=Integer.parseInt(request.getParameter("COD_REUN"));
    String asis=request.getParameter("asisten");
    String objs=request.getParameter("ojet");
           try
        {
            CallableStatement cs=conex.prepareCall("{ call sp_ingreso_socio_reun(?,?,?,?)}");
            cs.setString(1,id_so);
            cs.setInt(2,cod_re);
            cs.setString(3,asis);
            cs.setString(4,objs);
 
            cs.execute();
        }
        catch(Exception e)
        {
            out.print("ERROR AL GUARDAR "+e);
        }
        }%>             
        </table>
    </center>
        </form>
    </body>
</html>