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

public final class actualizar_005fcobrador_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <h1>Actualizacion de un Socio</h1>\n");
      out.write("        <form action=\"actualizar_cobrador.jsp\" method=\"post\"> \n");
      out.write("\n");
      out.write("            <table>\n");
      out.write("            ");

               int i=Integer.parseInt(request.getParameter("id"));
               PreparedStatement ps=conex.prepareStatement("select * from COBRADOR where NUM_COBRADOR="+i);
               ResultSet rs=ps.executeQuery();
               
            while(rs.next()){
            
      out.write("\n");
      out.write("                <tr><th></th></tr>              \n");
      out.write("                <tr><td> CODIGO</td><td><input type=\"text\" name=\"cod_c\" value=\"");
out.print(Integer.parseInt(rs.getString("NUM_COBRADOR")));
      out.write("\"></td></tr>               \n");
      out.write("                <tr><td>CEDULA</td><td><input type=\"text\" name=\"cedula\" value=\"");
out.print(rs.getString("CED_COB"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td>NOMBRE</td><td><input type=\"text\" name=\"nombre\" value=\"");
out.print(rs.getString("NOM_COB"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td> DIRECCION</td><td><input type=\"text\" name=\"direccion\" value=\"");
out.print(rs.getString("DIRC_COB"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td> TELEFONO</td><td><input type=\"text\" name=\"telefono\" value=\"");
out.print(rs.getString("TELF_COB"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td>EMAIL</td><td><input type=\"text\" name=\"email\" value=\"");
out.print(rs.getString("EMAIL_COB"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td> OBSERVACION</td><td><input type=\"text\" name=\"observacion\" value=\"");
out.print(rs.getString("OBSERVACION_COB"));
      out.write("\" ></td></tr>\n");
      out.write("                <tr><td><input type=\"submit\" name=\"actualizar\" value=\"actualizar\"></td><td><input type=\"reset\" name=\"limpiar\" value=\"limpiar\"></td></tr>\n");
      out.write("            </table>\n");
      out.write("           </form>\n");
      out.write("          </center>\n");
      out.write("              ");
 
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
    PreparedStatement psa=conex.prepareStatement(sql);
    psa.executeUpdate();
    
  response.sendRedirect("reporte_cobrador.jsp");
}
catch(Exception e)
    
{
    out.print("Error al actualizar"+e);
}
                        }

                     
      out.write("\n");
      out.write("                \n");
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
