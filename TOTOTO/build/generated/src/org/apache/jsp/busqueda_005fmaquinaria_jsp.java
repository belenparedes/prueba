package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public final class busqueda_005fmaquinaria_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/conex.jsp");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <center>\n");
      out.write("              <h1>BUSQUEDA DE MAQUINARIA</h1>\n");
      out.write("        <form action=\"busqueda_maquinaria.jsp\" method=\"post\">\n");
      out.write("       <table border=\"2\"> \n");
      out.write("           <th> SELECCIONE LA MAQUINARIA:\n");
      out.write("            <select name=\"codigo\">\n");
      out.write("                ");

                    PreparedStatement ps=conex.prepareStatement("select * from maquinaria");
                    ResultSet rs=ps.executeQuery();
                     while(rs.next()==true)
                    {
                
      out.write("\n");
      out.write("                <option value=\"");
out.print(rs.getString("codigo_m"));
      out.write('"');
      out.write('>');
out.print(rs.getString("nom_m"));
      out.write("</option>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <input type=\"submit\" name=\"buscar\" value=\"Buscar\">\n");
      out.write("       </th> </form>\n");
      out.write("            \n");
      out.write("        <tr><th colspan=\"3\">LISTADO MAQUINARIA</th></tr>\n");
      out.write("        <tr><th>CODIGO MAQUINARIA</th>\n");
      out.write("            <th>NOMBRE MAQUINARIA</th>\n");
      out.write("            <th>MARCA MAQUINARIA</th></tr>\n");
      out.write("        ");

            if(request.getParameter("buscar")!=null)
            {
                int c=Integer.parseInt(request.getParameter("codigo"));
                PreparedStatement ps1=conex.prepareStatement("select * from maquinaria where codigo_m="+c+"");
                ResultSet rs1=ps1.executeQuery();
                while(rs1.next()==true) 
                {
      out.write("\n");
      out.write("                <tr><td>");
out.print(rs1.getString("codigo_m"));
      out.write("</td>\n");
      out.write("                    <td>");
out.print(rs1.getString("nom_m"));
      out.write("</td>\n");
      out.write("                    <td>");
out.print(rs1.getString("marca_m"));
      out.write("</td></tr>  \n");
      out.write("                ");
 } }
      out.write("\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("       </center>\n");
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
