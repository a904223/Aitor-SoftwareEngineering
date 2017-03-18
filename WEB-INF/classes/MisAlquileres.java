import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class MisAlquileres extends HttpServlet {
	int i=0;
	Connection connection;
     

  public void destroy() {
    System.out.println("Nothing to do...");
  }
	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            connection=DriverManager.getConnection("jdbc:odbc:Database"); 
        } catch(Exception e) {
            e.printStackTrace();
        }
  } 
          

  public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	res.setContentType("text/html");


    PrintWriter out = null;
    try {
      out=res.getWriter();
    } catch (IOException io) {
      System.out.println("Exception"); 
	
    }
	res.setContentType("text/html");
    PrintWriter toClient = res.getWriter();
    toClient.println("<!DOCTYPE HTML>");
	toClient.println("<HTML>");
    toClient.println("<HEAD>");
	toClient.println("<title>Bills</title>");
	toClient.println("<link rel=\"StyleSheet\" type=\"text/css\" href=\"pattern.css\">");
	toClient.println("</head>");
    toClient.println("<BODY >");
	toClient.println("<div class=\"header\">");
	toClient.println("<img align=\"left\" src=\"Logo ERP Tecnun.png\">");
	toClient.println("<h1 align=\"center\">Bills</h1>");
	toClient.println("</div>");
	toClient.println("<meta align=\"right\" http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
	toClient.println("<TR>");
	
   try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery("Select Customer,Product,Bill_date FROM bills");
   
   while (result.next()) {
        
		i=i+1;
		String Customer=result.getString("Customer");
		String Product=result.getString("Product");
		String Bill_date=result.getString("Bill_date");
		toClient.println("<style type='text/css'>");
		toClient.println("  #overlay"+ i + " {");
		toClient.println("visibility: hidden;");
		toClient.println("position: right;");
		toClient.println("top: 200px;");
		toClient.println("width:400px;");
		toClient.println("height:50px;");
		toClient.println("text-align:center;");
		toClient.println("z-index: 1000;");
		toClient.println("margin-right: 5%;");
		toClient.println("border: 2px blue solid;");
		toClient.println("background-color: FFFFFF;");
		toClient.println("}");
		toClient.println("</style>");
		toClient.println("<script type='text/javascript'>");
		toClient.println("function overlay" + i +" () {");
		toClient.println("el = document.getElementById(\"overlay" + i + "\");");
		toClient.println("el.style.visibility = (el.style.visibility == \"visible\") ? \"hidden\" : \"visible\";");
		toClient.println("}");
		toClient.println("</script>");
		toClient.println( "<div style=\"text-align:right;\" id=overlay" + i + ">");
		toClient.println( "<div>");
		toClient.println( "<B> Customer:  </B>");
		toClient.println(Customer);
		toClient.println( "<B> Price:  </B>" );
		toClient.println( Product);
		toClient.println( "<B> Date:  </B>");
		toClient.println( Bill_date);
		toClient.println("</div>");
		toClient.println( "</div>");
		toClient.println("<center>");
		toClient.println("<TD>");
		toClient.print( "<button class=\"boton grisn\" caption=overlay" + i + "  dialog onclick=overlay" + i + "()>" + Customer + "</button>" );
		toClient.println("</TD>");
		toClient.println("</center>");
            
        }
		}
		catch(SQLException e) {
            e.printStackTrace();
            System.out.println("nada");
        }
		
        

    
	toClient.println("</TR>");
    toClient.println( "</TABLE>");
	toClient.println("<ul class=\"navbar\">");
	toClient.println("<li class=\"dropdown\">");
	toClient.println("<a class=\"dropbtn\"><font face=\"Arial\">Menu</font></a>");
	toClient.println("<div class=\"dropdown-content\">");
	toClient.println("<a class=\"active\" href=\"Pedido.html\">Orders</a>");
	toClient.println("<a href=\"customers.html\">Customers</a>");
	toClient.println("<a href=\"producttxt.html\">Products</a>");
	toClient.println("<a href=\"accounting.html\">Accounting</a>");
	toClient.println("<a href=\"bills.html\">Bills</a>");
	toClient.println("</div>");
	toClient.println("</li>");
	toClient.println("</ul>");
	toClient.println("</BODY>");
    toClient.println("</HTML>");
	toClient.flush();
    toClient.close();
	}
	}
  
     

 
