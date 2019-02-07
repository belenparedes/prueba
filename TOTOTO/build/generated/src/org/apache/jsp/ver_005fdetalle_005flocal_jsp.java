package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public final class ver_005fdetalle_005flocal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>DETALLE DE LA INFORMACION DEL LOCAL SELECCIONADO</h1>\n");
      out.write("        ");
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
      out.write("        <form action=\"REPORTE_LOCAL.jsp\" method=\"post\">\n");
      out.write("            <center>\n");
      out.write("            <table border=\"2\">\n");
      out.write("                <tr>\n");
      out.write("                    <th colspan=\"13\">---------REPORTE LOCAL-----------<th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th colspan=\"7\"><a href=\"ingreso_local.jsp\"><img src=\"imagen/descarga.png\" height=\"50\" width=\"50\" ></a></th>\n");
      out.write("                </tr>\n");
      out.write("                <tr><th>NUMERO LOCAL</th>\n");
      out.write("                    <th>DESCRIPCION</th>\n");
      out.write("                    <th>DIMENCION</th>\n");
      out.write("                    <th>SOCIO</th>\n");
      out.write("                    <th colspan=\"3\">ACCION</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    PreparedStatement ps=conex.prepareStatement("select * from LOCAL");
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()==true) 
                {
                    try
                    {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
out.print(rs.getString("NUM_LOCAL"));
      out.write("</td>\n");
      out.write("                    <td>");
out.print(rs.getString("DESC_LOCAL"));
      out.write("</td>\n");
      out.write("                    <td>");
out.print(rs.getString("DIMEN_LOCAL"));
      out.write("</td>\n");
      out.write("                    <td>");
out.print(rs.getString("ID_SOCIO"));
      out.write("</td>\n");
      out.write("                    <td><a href=\"actualizar_local.jsp?id=");
      out.print(rs.getString("NUM_LOCAL"));
      out.write("\"><img src=\"imagen/images.png\" height=\"50\" width=\"50\" ></a></td>\n");
      out.write("                    <td><img src=\"imagen/descarga.png\" height=\"50\" width=\"50\" ></td>\n");
      out.write("                    <td><a href=\"eliminar.jsp?id=");
      out.print(rs.getString("NUM_LOCAL"));
      out.write("\"><img src=\"imagen/51418.png\" height=\"50\" width=\"50\" ></a></td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    } 
                
            catch(Exception e)
        {
            out.print("ERROR AL GUARDAR "+e);
        }
}      
      out.write("\n");
      out.write("            </table>\n");
      out.write("            </center>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
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
