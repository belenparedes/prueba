package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public final class actualizar_005flocal_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
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
      out.write("    ");
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
      out.write(" \n");
      out.write("    <center>\n");
      out.write("        <h1>ACTUALIZAR SOCIO</h1>\n");
      out.write("        <form action=\"actualizar_local.jsp\" method=\"post\"> \n");
      out.write("\n");
      out.write("            <table>\n");
      out.write("            ");

               int i=Integer.parseInt(request.getParameter("id"));
               PreparedStatement ps=conex.prepareStatement("select * from LOCAL where NUM_LOCAL="+i);
               ResultSet rs=ps.executeQuery();
               
            while(rs.next()){
            
      out.write("\n");
      out.write("                <tr><th></th></tr>              \n");
      out.write("                <tr><td> CODIGO</td><td><input type=\"text\" name=\"cod\" value=\"");
out.print(Integer.parseInt(rs.getString("NUM_LOCAL")));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td>DESCRIPCION</td><td><input type=\"text\" name=\"desc\" value=\"");
out.print(rs.getString("DESC_LOCAL"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td>DIMENSION</td><td><input type=\"text\" name=\"dim\" value=\"");
out.print(rs.getString("DIMEN_LOCAL"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td> SOCIO</td><td><input type=\"text\" name=\"cod_so\" value=\"");
out.print(rs.getString("ID_SOCIO"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td><input type=\"submit\" name=\"actualizar\" value=\"actualizar\"></td><td><input type=\"reset\" name=\"limpiar\" value=\"limpiar\"></td></tr>\n");
      out.write("            </table>\n");
      out.write("           </form>\n");
      out.write("          </center>\n");
      out.write("               \n");
      out.write("              ");
 
                  }
              if(request.getParameter("actualizar")!=null)
                {
               
               String cod=request.getParameter("cod");
               String desc=request.getParameter("desc");
               String dim=request.getParameter("dim");
               int cod_s=Integer.parseInt(request.getParameter("cod_so"));
                 
try{             

    String sql="update LOCAL set NUM_LOCAL='"+cod+"',DESC_LOCAL='"+desc+"',DIMEN_LOCAL='"+dim+"',ID_SOCIO='"+cod_s+"";
    PreparedStatement psa=conex.prepareStatement(sql);
    psa.executeUpdate();
    
  response.sendRedirect("REPORTE_LOCAL.jsp");
}
catch(Exception e)
    
{
    out.print("Error al actualizar");
}
                        }

                     
      out.write("\n");
      out.write("              \n");
      out.write("    </body>\n");
      out.write("</html>");
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
