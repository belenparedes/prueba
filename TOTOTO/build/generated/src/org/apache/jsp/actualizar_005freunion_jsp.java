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

public final class actualizar_005freunion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <h1>Actualizacion</h1>\n");
      out.write("        <form action=\"actualizar_datos_reunion.jsp\" method=\"post\"> \n");
      out.write("\n");
      out.write("            <table>\n");
      out.write("            ");

               int i=Integer.parseInt(request.getParameter("id"));
               PreparedStatement ps=conex.prepareStatement("select * from REUNION where COD_REUN="+i);
               ResultSet rs=ps.executeQuery();
               
            while(rs.next()){
            
      out.write("\n");
      out.write("                <tr><th></th></tr>              \n");
      out.write("                <tr><td> CODIGO</td><td><input type=\"text\" name=\"cod_r\" value=\"");
out.print(Integer.parseInt(rs.getString("COD_REUN")));
      out.write("\"></td></tr>               \n");
      out.write("                <tr><td>MOTIVO</td><td><input type=\"text\" name=\"moti\" value=\"");
out.print(rs.getString("ASUNTO_REUN"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td>FECHA</td><td><input type=\"text\" name=\"fe\" value=\"");
out.print(rs.getString("FECHA_REUN"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td> HORA</td><td><input type=\"text\" name=\"horas\" value=\"");
out.print(rs.getString("HORA_REUN"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td> LUGAR</td><td><input type=\"text\" name=\"lugarr\" value=\"");
out.print(rs.getString("LUGAR_REUN"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td>QUIEN CONVOCO</td><td><input type=\"text\" name=\"convo\" value=\"");
out.print(rs.getString("QUIEN"));
      out.write("\"></td></tr>\n");
      out.write("                <tr><td>A QUIEN CONVOCO</td><td><input type=\"text\" name=\"quienconvo\" value=\"");
out.print(rs.getString("A_QUIEN"));
      out.write("\" ></td></tr>\n");
      out.write("                <tr><td><input type=\"submit\" name=\"actualizar\" value=\"actualizar\"></td><td><input type=\"reset\" name=\"limpiar\" value=\"limpiar\"></td></tr>\n");
      out.write("            </table>\n");
      out.write("           </form>\n");
      out.write("    </center><form>\n");
      out.write("              ");
 
                  }
              if(request.getParameter("actualizar")!=null)
                {
               int cod=Integer.parseInt(request.getParameter("cod_r"));
               String motivo=request.getParameter("moti");
               String fecha=request.getParameter("fe");
               String hora=request.getParameter("horas");
               String lugar=request.getParameter("lugarr");
               String convoco=request.getParameter("convo");
               String quien_convo1=request.getParameter("quienconvo");
                               
try{             

    String sql="update REUNION set MOTIVO_REUN='"+motivo+"',FECHA_REUN='"+fecha+"',HORA_REUN='"+hora+"',LUGAR_REUN='"+lugar+"',QUIEN='"+convoco+"',A_QUIEN='"+quien_convo1+"' where COD_REUN="+i+"";
    PreparedStatement ps1=conex.prepareStatement(sql);
    ps1.executeUpdate();
    
  response.sendRedirect("reporte_reunion.jsp");

}
catch(Exception e)
    
{
    out.print("Error al actualizar");
}
                }

                     
      out.write("\n");
      out.write("             </form>   \n");
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
