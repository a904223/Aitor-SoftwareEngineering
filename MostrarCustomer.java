import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MostrarCustomer extends HttpServlet {
    Connection connection;
     
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    System.out.println("Iniciando MostrarCustomer...");
  }

  public void destroy() {
    System.out.println("There is nothing to do...");
  }
  public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    //HttpSession session = req.getSession(true);
    //String sesion = (String)session.getAttribute("sesion");
    
    ResultSet result1=null;
    String Customer="";
    ArrayList<String> CustomerA= new ArrayList<String>();
    ArrayList<String> ProductA= new ArrayList<String>();
    ArrayList<String> PriceA= new ArrayList<String>();
    ArrayList<String> DateA= new ArrayList<String>();
    
    //String sql2 = "SELECT * FROM  Customer ";
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url="jdbc:odbc:Database";
            System.out.println("1");
            connection=DriverManager.getConnection(url); 
            System.out.println("2");
            FileWriter fileWriter = new FileWriter("E:\\apache-tomcat-5.5.12\\webapps\\ErpTecnun\\log.txt", true);
            PrintWriter toFile = new PrintWriter(fileWriter);
            toFile.println(" ok:");
            fileWriter.close();
            Statement statement = connection.createStatement();
            System.out.println("3");
          
             result1=statement.executeQuery("SELECT * FROM  Customer");
            System.out.println("4");
            while (result1.next() ){
                CustomerA.add(result1.getString(1));
                ProductA.add(result1.getString(2));
                PriceA.add(result1.getString(3));
                DateA.add(result1.getString(4));
                //Customer=result1.getString("Customer");
                //System.out.println(result1.getString("Customer"));
            }
           //devolverPaginaHTML(resp, "", "", "", "", result1);
            connection.close(); 
            
            
            
        } catch(Exception e) {
            System.out.println("Problem creating connection");
            FileWriter fileWriter = new FileWriter("E:\\apache-tomcat-5.5.12\\webapps\\ErpTecnun\\log.txt", true);
            PrintWriter toFile = new PrintWriter(fileWriter);
            toFile.println("no ok:");
            fileWriter.close();
            e.printStackTrace();
        }
                 
    //FileWriter fileWriter = new FileWriter("E:\\apache-tomcat-5.5.12\\webapps\\ErpTecnun\\MisPedidos.txt", true);
    //PrintWriter toFile = new PrintWriter(fileWriter);
    
    //toFile.println("> " + strCustomer + "\t" + strProduct + "\t" + strPrice + "\t" + strDate + "\t" + sesion);
    //fileWriter.close();
    devolverPaginaHTML(resp, Customer, ProductA, PriceA, DateA, CustomerA);
  }
    
  public void devolverPaginaHTML(HttpServletResponse resp, String customer, ArrayList<String> ProductA, ArrayList<String> PriceA, ArrayList<String> DateA, ArrayList<String> CustomerA ) {

    resp.setContentType("text/html");

    PrintWriter out = null;
    try {
        //while (result1.next() ){
               // String Customer=result1.getString("Customer");
                //System.out.println(Customer);
           // }
      out=resp.getWriter();
    } catch (IOException io) {
      System.out.println("There has been an exception");    
    }
       
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Orders</TITLE>");
    out.println("<link rel=\"Stylesheet\" type=\"text/css\" href=\"pattern.css\">");
    out.println("</HEAD>");
    out.println("<BODY background=\"gris.jpg\">");
    out.println("<div class=\"header\"><img align=\"left\" src=\"Logo ERP Tecnun.png\"><h1 align=\"center\">ACCOUNTING - Staff</h1></div><ul class=\"navbar\"><li class=\"dropdown\"><a class=\"dropbtn\"><font face=\"Arial\">Menu</font></a><div class=\"dropdown-content\"><a class=\"active\" href=\"Pedido.html\">Orders</a><a href=\"customers.html\">Customers</a><a href=\"producttxt.html\">Products</a><a href=\"accounting.html\">Accounting</a><a href=\"bills.html\">Bills</a></div></li></ul>");
    out.println("<center>");
    //while (result1.next()){
        //String Customer=result1.getString("Customer");
        
   out.println("<B><font align=\"center\" size=\"7\" color=\"#088A85\" face=\"Calibri\">ORDERS</FONT></B>");
   out.println("<form action=\"Delete\">");
   
    for (int i=0; i<CustomerA.size();i++){
    
    out.println("<P><font size=\"5\" color=\"#04B4AE\" face=\"Calibri\"> <B>Customer: </B><font color=\"#000000\">" + CustomerA.get(i) + "</font></FONT>");
    out.println("<BR><font size=\"5\" color=\"#04B4AE\" face=\"Calibri\"> <B>Product: </B><font color=\"#000000\">" + ProductA.get(i) + "</font></FONT>");
    out.println("<BR><font size=\"5\" color=\"#04B4AE\" face=\"Calibri\"> <B>Price: </B><font color=\"#000000\">" + PriceA.get(i) + "</font></FONT>");
    out.println("<BR><font size=\"5\" color=\"#04B4AE\" face=\"Calibri\"> <B>Date: </B><font color=\"#000000\">" + DateA.get(i) + "</font></FONT>");
    out.println("<input type=\"submit\" name=\"delete\"value=delete:" + CustomerA.get(i) + ">");
   
    
    
  }
   out.println("</form>");
    out.println("<BR><a href=\"Pedido.html\">Back to menu</a>");
    out.println("</center>");
    out.println("</BODY>");
   

    out.println("</HTML>");

    out.flush();
    out.close();
  }
     
  public String getServletInfo() {
    return "Este servlet lee los datos de un formulario y los muestra en pantalla";
  }
}