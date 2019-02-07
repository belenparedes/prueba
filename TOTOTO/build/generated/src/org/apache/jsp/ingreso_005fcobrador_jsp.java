package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public final class ingreso_005fcobrador_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
      out.write("    <center>\n");
      out.write("        <h1>INGRESO DE NUEVO COBRADOR</h1>\n");
      out.write("        <form action=\"ingreso_cobrador.jsp\" method=\"post\">\n");
      out.write("<table border=\"5\">\n");
      out.write("    <tr><th COLSPAN =\"2\">---------NUEVO COBRADOR---------</th></tr>\n");
      out.write("    <TR><td>NUMERO COBRADOR</td><td><input type=\"text\" name=\"codigo\"  VALUE=\"");
 PreparedStatement ps=conex.prepareStatement("Select max(NUM_COBRADOR +1) NUM_COBRADOR from COBRADOR");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
    {
        out.print(rs.getString("NUM_COBRADOR"));
}

      out.write("\"></td></TR>\n");
      out.write("    <TR><td>CEDULA</td><td><input type=\"text\" name=\"ced\"></td></TR>\n");
      out.write("    <TR><td>NOMBRE</td><td><input type=\"text\" name=\"nomb\"></td></TR>\n");
      out.write("    <TR><td>DIRECCION</td><td><input type=\"text\" name=\"dirc\"></td></TR>\n");
      out.write("    <TR><td>TELEFONO</td><td><input type=\"text\" name=\"telf\"></td></TR>\n");
      out.write("    <TR><td>EMAIL</td><td><input type=\"text\" name=\"ema\"></td></TR>\n");
      out.write("    <TR><td>OBSERVACION</td><td><input type=\"text\" name=\"obs\"></td></TR>\n");
      out.write("    <TR><td><input type=\"submit\" name=\"ingreso\" value=\"INGRESAR\"></td><td><input type=\"reset\" name=\"limpio\" value=\"LIMPIAR\"></td></TR>\n");
      out.write("</table>\n");
      out.write("</form>\n");
      out.write("        ");
  

            
      out.write("\n");
      out.write("        \n");
      out.write("        ");

       
        if(request.getParameter("ingreso")!=null)
    {
    int id_c=Integer.parseInt(request.getParameter("codigo"));
    String cedu=request.getParameter("ced");
    String nom=request.getParameter("nomb");
    String direc=request.getParameter("dirc");
    String telfo=request.getParameter("telf");
    String email=request.getParameter("ema");
    String obser=request.getParameter("obs");
        try
        {
            CallableStatement cs=conex.prepareCall("{ call sp_ingreso_socio(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1,id_c);
            cs.setString(2,cedu);
            cs.setString(3,nom);
            cs.setString(4,direc);
            cs.setString(5,telfo);
            cs.setString(6,email);
            cs.setString(7,obser);
            
            cs.execute();
        response.sendRedirect("reporte_cobrador.jsp");
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
