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

   public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=null;
		
		try {
            out=response.getWriter();
        } catch (IOException io) {
            System.out.println("Error opening PrintWriter");
        }
		
        
        
            
		try {
            
            String strcont = request.getParameter("filas");
            String strvuelta = request.getParameter("vuelta");
            System.out.println("strcont: " + strcont);
            System.out.println("vuelta: " + strvuelta);
            int cont = Integer.parseInt(strcont);
            
            String[] sql = new String[cont];
            
            String name = request.getParameter("name");
            System.out.println("name: " + name);
            String[] name2 = name.split(",");
            System.out.println("name2: " + name2);
            
            String surname = request.getParameter("surname");
            String[] surname2 = surname.split(",");
            
            Statement statement=connection.createStatement();
            
            for (int i=1; i<cont; i++){
                System.out.println("name2: " + name2[i]);
                name2[i] = name2[i].replace("\"", "");
                name2[i] = name2[i].replace("]", "");
                
                surname2[i] = surname2[i].replace("\"", "");
                surname2[i] = surname2[i].replace("]", "");
                
                sql[i]="UPDATE Employees SET Nombre = '" + name2[i] + "', Apellidos = '" + surname2[i] + "' WHERE IDEmployee = " + i + "";
                System.out.println("sql: " +sql[i]);
                
                System.out.println("Ha entrado en el for del try");
                statement.executeUpdate(sql[i]);
            }
            
			out.flush();
			out.close();
			
			
		}catch(SQLException e){
			e.printStackTrace ();
			System.out.println("Resulset:  Exception: " + e);
		}  
			out.close();
		}
}