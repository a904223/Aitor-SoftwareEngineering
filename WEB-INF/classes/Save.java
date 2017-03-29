import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Save extends HttpServlet {
    Connection connection;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url="jdbc:odbc:Database";
            connection=DriverManager.getConnection(url); 
			
        } catch(Exception e) {
            System.out.println("Problem creating connection");
            e.printStackTrace();
        }
    }

   public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out=null;
		
		try {
            out=res.getWriter();
        } catch (IOException io) {
            System.out.println("Error opening PrintWriter");
        }
		
        String strcont = req.getParameter("cont");
        int cont = Integer.parseInt(strcont);
        String[] name;
        String sql="";
        
        for (int i=1; i<(cont + 1); i++){
            name[i] = req.getParameter("name" + i);
            sql="UPDATE Employees SET Nombre = '" + name + "'";
            System.out.println("sql: " +sql);
        }
		try {
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            
			// out.println("<html>");
			// out.println("<head>");
			// out.println("</head>");
			// out.println("<body>");
			// out.println("<BR>");
			// out.println("<H2> You have deleted succesfully</H2>");
			// out.println("<a href='campaigns.html'>go back</a>");
			// out.println("</body>");
			// out.println("</html>");
			out.flush();
			out.close();
			
			
		}catch(SQLException e){
			e.printStackTrace ();
			System.out.println("Resulset: " + sql + " Exception: " + e);
		}  
			out.close();
		}
}