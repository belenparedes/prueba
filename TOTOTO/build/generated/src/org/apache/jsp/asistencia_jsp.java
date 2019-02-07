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

public final class asistencia_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>ASISTENCIA</h1>\n");
      out.write("        <form action=\"asistencia.jsp\" method=\"post\">\n");
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
      out.write("        <center>\n");
      out.write("            <table>\n");
      out.write("                   <tr><td>INGRESE EL ID DE LA ASOCIACION</td><td><select name=\"id_aso\">\n");
      out.write("                      ");

                        PreparedStatement ps1=conex.prepareStatement("select * from ASOCIACION");
                ResultSet rs1=ps1.executeQuery();
                while (rs1.next()==true)
                {         

            
      out.write("\n");
      out.write("                        <option value=\"");
out.print(rs1.getString("COD_ASO"));
      out.write("\"> ");
out.print(rs1.getString("NOM_ASO"));
      out.write("</option>\n");
      out.write("                       ");
 }
                       
      out.write("         \n");
      out.write("                    </select></td><td><input type=\"submit\" name=\"boton\" value=\"BUSCAR\"></td></tr>\n");
      out.write("            ");

        if(request.getParameter("boton")!=null)
        {
           String us= request.getParameter("id_aso");
           PreparedStatement pss=conex.prepareStatement("SELECT ID_SOCIO, NOM_SOCIO  FROM SOCIO,ASOCIACION  WHERE SOCIO.COD_ASO=ASOCIACION.COD_ASO AND ASOCIACION.COD_ASO='"+us+"'");
          ResultSet rs=pss.executeQuery();
          while (rs.next()==true)
          {
           
      out.write(" \n");
      out.write("                   <tr><td>");
out.print(rs.getString("ID_SOCIO"));
      out.write("</td><td>");
out.print(rs.getString("NOM_SOCIO"));
      out.write("</td><td><input type=\"checkBox\" name=\"asisten\" value=\"s\"></td><td><input type=\"text\" name=\"ojet\"></td></tr>       \n");
      out.write("           ");
 }
      out.write(" \n");
      out.write("        <tr><td><input type=\"submit\" name=\"guardar\" value=\"GUARDAR\"></td></tr>\n");
      out.write("               ");
 } 
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
        }
      out.write("             \n");
      out.write("        </table>\n");
      out.write("    </center>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
