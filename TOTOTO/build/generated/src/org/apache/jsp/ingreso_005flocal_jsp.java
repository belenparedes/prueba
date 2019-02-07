package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public final class ingreso_005flocal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/coneccion.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("      <meta charset=\"utf-8\" /> \n");
      out.write("      <link href=\"calendario_dw/calendario_dw-estilos.css\" type=\"text/css\" rel=\"STYLESHEET\">\n");
      out.write("\t<style type=\"text/css\">\n");
      out.write("\tbody{\n");
      out.write("\t\tfont-family: tahoma, verdana, sans-serif;\n");
      out.write("\t}\n");
      out.write("\t</style>\n");
      out.write("\t<script type=\"text/javascript\" src=\"calendario_dw/jquery-1.4.4.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"calendario_dw/calendario_dw.js\"></script>\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function(){\n");
      out.write("\t\t$(\".campofecha\").calendarioDW();\n");
      out.write("\t})\n");
      out.write("\t</script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");

        Connection conex=null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL="jdbc:sqlserver://DESKTOP-I8RSKA1;"+"database=ASOCIACION_5J;"+"user=sa;"+"password=uti2017;";
            conex=DriverManager.getConnection(connectionURL);
            out.print(" CONECCION");  
        }
        catch(Exception e)
        {
            out.print("ERROR EN LA CONECCION");  
        }

      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <center> \n");
      out.write("        <h1>INGRESO NUEVO LOCAL</h1>\n");
      out.write("        <form action=\"ingreso_local.jsp\" method=\"post\">\n");
      out.write("<table border=\"5\">\n");
      out.write("    <tr><th COLSPAN =\"2\">---------NUEVO LOCAL---------</th></tr>\n");
      out.write("    <TR><td>NUMERO LOCAL</td><td><input type=\"text\" name=\"codigo\"  VALUE=\"");
 PreparedStatement ps=conex.prepareStatement("Select max(NUM_LOCAL ) NUM_LOCAL from LOCAL");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
    {
        out.print(rs.getString("NUM_LOCAL"));
}

      out.write("\"></td></TR>\n");
      out.write("    <TR><td>DESCRIPCION</td><td><input type=\"text\" name=\"des\"></td></TR>\n");
      out.write("    <TR><td>DIMENCION</td><td><input type=\"text\" name=\"dimen\"></td></TR>\n");
      out.write("    <TR><td>CODIGO DEL SOCIO</td><td><select name=\"cod_socio\">\n");
      out.write("                            ");

                            PreparedStatement p=conex.prepareStatement("select * from SOCIO");
                            ResultSet r=p.executeQuery();
                            while(r.next()==true)
                            {
                            
      out.write("\n");
      out.write("                            <option value=\"");
 out.print(r.getString("ID_SOCIO")); 
      out.write("\"> ");
 out.print(r.getString("NOM_SOCIO")); 
      out.write("</option>\n");
      out.write("                            ");

                            }
                            
      out.write("</select></td></TR>\n");
      out.write("    <TR><td><input type=\"submit\" name=\"ingreso\" value=\"INGRESAR\"></td><td><input type=\"reset\" name=\"limpio\" value=\"LIMPIAR\"></td></TR>\n");
      out.write("</table>\n");
      out.write("</form>\n");
      out.write("        \n");
      out.write("        ");

       
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
        response.sendRedirect("reporte_mensualidad.jsp");
         
        }
        catch(Exception e)
        {
            out.print("ERROR AL GUARDAR "+e);
        }
    } 

      out.write("\n");
      out.write("    </center>\n");
      out.write("    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
