import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PasswordChange extends HttpServlet{
    
    Connection connection;
    private static int h = 0;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url="jdbc:odbc:Database";
            connection=DriverManager.getConnection(url);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=null;
        
        try {
            out=response.getWriter();
        } catch (IOException io) {
            System.out.println("Error opening PrintWriter");
        }
        
        String usuario = request.getParameter("usuario");
        String pass_actual = request.getParameter("pass_actual");
        System.out.println("pass_actual: " +pass_actual);
        String pass_nueva1 = request.getParameter("pass_nueva1");
        String pass_nueva2 = request.getParameter("pass_nueva2");
        
        // if(usuario==null) {
            // System.out.println("Problem reading username from request");
            // return;
        // }
        if(pass_actual==null) {
          System.out.println("Problem reading the actual password from request");
          return;
        }
        // if(pass_nueva1==null) {
          // System.out.println("Problem reading the new password from request");
          // return;
        // }
        // if(pass_nueva2==null) {
          // System.out.println("Problem reading the new password from request");
          // return;
        // }
        
                
        String sql_user = "SELECT Usuario FROM Employees WHERE Usuario='" + usuario + "'"; 
        String sql_insert = "UPDATE Employees SET Contrasena = '" + pass_nueva1 + "' WHERE Usuario='" + usuario + "'";
        System.out.println(sql_user);
        
        try{
            Statement statement=connection.createStatement();
            Statement statement2=connection.createStatement();
            statement2.executeUpdate(sql_insert);
            statement2.close();
            ResultSet result = statement.executeQuery(sql_user);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Password Change</title>");
            out.println("<link rel=StyleSheet type=text/css href=pattern.css>");
            out.println("</head>");
            out.println("<body bgcolor=\"#FFFFFF\" text=\"#631818\">");
            out.println("<div class=\"header\"><img align=\"left\" src=\"Logo ERP Tecnun.png\"><h1 align=\"center\">PASSWORD CHANGE</h1></div><ul class=\"navbar\"><li class=\"dropdown\"><a class=\"dropbtn\"><font face=\"Arial\">Menu</font></a><div class=\"dropdown-content\"><a class=\"active\" href=\"Pedido.html\">Orders</a><a href=\"customers.html\">Customers</a><a href=\"producttxt.html\">Products</a><a href=\"accounting.html\">Accounting</a><a href=\"bills.html\">Bills</a></div></li></ul>");
            out.println("<p align=\"center\"><font size=\"6\"><b>PASSWORD CHANGE</b></font></p>");
            out.println("<p align=\"center\">AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA</p>");
            out.println("</body>");
            out.println("</html>");
            out.flush();
            out.close();
            
            //out.println(resString);
           

            // String strFilas = request.getParameter("employee");
            // int intFilas = Integer.parseInt(strFilas);
            // int intColumnas = 7 ;
            
            
            // String[] name=new String[intFilas] ;
            
            // for (int a=0; a<intFilas ; a++) {
                // name [a] = request.getParameter("name" + (a+1));
            // }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Resulset: " + sql_user + " Exception: " + e);
        }
        out.close();
    }
}