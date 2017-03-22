import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowInfoEmployees extends HttpServlet{
    
    Connection connection;
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
        
        out = response.getWriter();
        
        String sql = "SELECT Nombre, Apellidos, Email, [Mobile Phone], [Date of Birth], [Job Title], Department, Salary, [Works with Commision], Commision(% on sales) FROM Employees";
        
        try {
            Statement statement=connection.createStatement();
            
            ResultSet result = statement.executeQuery(sql);
            
            int count=result2.getInt("Total");
            //System.out.println(count);
            
            String resString = "";
            String resString2 = "";
            String resString3Year="";
            String resString3Month = "";
            String resString3Day = "";
            boolean first = true;
            while(result.next() && result3.next()) {
                if (!first) {
                    resString += "\t";
                    resString2 += "\t";
                    resString3Year += "/";
                    resString3Month += "/";
                    resString3Day += "/";
                } else {
                    first = false;
                }
                resString += result.getString("Nombre");
                resString2 += result.getString("Day Off");
                //resString += " " + result.getString("surname") + "\"";
                resString3Year += result3.getString("yr");
                resString3Month += result3.getString("mnth");
                resString3Day += result3.getString("dy");
            }
            
            String[] palabrasSeparadas = resString.split("\t");
            String[] DayOff = resString2.split("\t");
            //String[] SqlDate = resString3.split("/");
            String[] SqlYear = resString3Year.split("/");
            String[] SqlMonth = resString3Month.split("/");
            String[] SqlDay = resString3Day.split("/");
            
            int columnas=7;
            
            System.out.println("SqlDay[0]: " + SqlDay[0]);
            System.out.println("SqlMonth[0]: " + SqlMonth[0]);
            System.out.println("SqlYear[0]: " + SqlYear[0]);
            System.out.println("Day Off[0]: " + DayOff[0]);
                
            System.out.println("Long year: " + SqlYear.length);
            System.out.println("Long month: " + SqlMonth.length);
            System.out.println("Long day: " + SqlDay.length);
            
        
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Working timetable</title>");
            out.println("<meta charset=\"utf-8\"> <link rel=\"StyleSheet\" type=\"text/css\" href=\"pattern.css\"><link rel=\"StyleSheet\" type=\"text/css\" href=\"tabla.css\"><link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css\"> <script src=\"//code.jquery.com/jquery-1.10.2.js\"></script> <script src=\"//code.jquery.com/ui/1.11.1/jquery-ui.js\"></script> <style> #draggable { width: 100px; background-color: rgba(173, 255, 47, 0.2); border-radius: 26px; border-width: 5px; height: 100px; padding: 0.5em; } #droppable td{ width: 100px; height: 100px; padding: 0.5em; } </style> <script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script> <script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script> <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script> <script src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.js\"></script> <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">");
            out.println("<script> $( function() { $( \"#draggable\" ).draggable({ revert: \"valid\" }); $( \'#droppable td\' ).droppable({ drop: function ( event, ui ) { var parenttd = $(this).attr(\'id\'); alert(\"parenttd=\" + parenttd); $( this ) .find( \"p\" ) .html( \"Day Off!\" ); } }) }); </script>");
            out.println("</head>");
            out.println("<body bgcolor=\"#FFFFFF\" text=\"#631818\">");
            out.println("<div class=\"header\"><img align=\"left\" src=\"Logo ERP Tecnun.png\"><h1 align=\"center\">ACCOUNTING - Staff</h1></div><ul class=\"navbar\"><li class=\"dropdown\"><a class=\"dropbtn\"><font face=\"Arial\">Menu</font></a><div class=\"dropdown-content\"><a class=\"active\" href=\"orders.html\">Orders</a><a href=\"customers.html\">Customers</a><a href=\"producttxt.html\">Products</a><a href=\"accounting.html\">Accounting</a><a href=\"bills.html\">Bills</a></div></li></ul><div id=\"draggable\" class=\"ui-widget-content\"> <p>Day Off</p> </div> <br /><br />");
            out.println("<p align=\"center\"><font size=\"6\"><b>WORKING TIMETABLE</b></font></p>");
            out.println("<input type=\"hidden\" name=\"day\" value=\"" + Day + "\">");
            out.println("<input type=\"hidden\" name=\"month\" value=\"" + Month + "\">");
            out.println("<input type=\"hidden\" name=\"year\" value=\"" + Year + "\">");
            out.println("<p align=\"center\">");
            out.println("<TABLE id=\"droppable\" border=\"1\" class=\"tabla\" cellspacing=\"0\">");
            
            int[] dias=new int[8];
            for (int i=0; i< (count+1); i++) {
                out.println("<TR>");
                for (int j=0; j< (columnas+1); j++) {
                    if (i==0) {
                        switch (j) {

                            case 0: out.println ("<TD>&nbsp</TD>");
                                    break;
                            case 1: out.println ("<TH><h1>Monday, " + negativo*((l+(j-1))+7*(semana-2)) + "</h1></TH>");
                                    dias[j]=negativo*((l+(j-1))+7*(semana-2));
                                    if (j>=(h-2)) {negativo=1;}
                                    System.out.println("I: " + i + " j: " + j + " dias: " + dias[j] );
                                    break;
                            case 2: out.println ("<TH><h1>Tuesday, " + negativo*((l+(j-1))+7*(semana-2)) + "</h1></TH>");
                                    dias[j]=negativo*((l+(j-1))+7*(semana-2));
                                    if (j>=(h-2)) {negativo=1;}
                                    System.out.println("I: " + i + " j: " + j + " dias: " + dias[j] );
                                    break;
                            case 3: out.println ("<TH><h1>Wednesday, " + negativo*((l+(j-1))+7*(semana-2)) + "</h1></TH>");
                                    dias[j]=negativo*((l+(j-1))+7*(semana-2));
                                    if (j>=(h-2)) {negativo=1;}
                                    System.out.println("I: " + i + " j: " + j + " dias: " + dias[j] );
                                    break;
                            case 4: out.println ("<TH><h1>Thursday, " + negativo*((l+(j-1))+7*(semana-2)) + "</h1></TH>");
                                    dias[j]=negativo*((l+(j-1))+7*(semana-2));
                                    if (j>=(h-2)) {negativo=1;}
                                    System.out.println("I: " + i + " j: " + j + " dias: " + dias[j] );
                                    break;
                            case 5: out.println ("<TH><h1>Friday, " + negativo*((l+(j-1))+7*(semana-2)) + "</h1></TH>");
                                    dias[j]=negativo*((l+(j-1))+7*(semana-2));
                                    if (j>=(h-2)) {negativo=1;}
                                    System.out.println("I: " + i + " j: " + j + " dias: " + dias[j] );
                                    break;
                            case 6: out.println ("<TH><h1>Saturday, " + (negativo*(l+(j-1))+7*(semana-2)) + "</h1></TH>");
                                    dias[j]=negativo*((l+(j-1))+7*(semana-2));
                                    if (j>=(h-2)) {negativo=1;}
                                    System.out.println("I: " + i + " j: " + j + " dias: " + dias[j] );
                                    break;
                            case 7: out.println ("<TH><h1>Sunday, " + negativo*((l+(j-1))+7*(semana-2)) + "</h1></TH>");
                                    dias[j]=negativo*((l+(j-1))+7*(semana-2));
                                    if (j>=(h-2)) {negativo=1;}
                                    System.out.println("I: " + i + " j: " + j + " dias: " + dias[j] );
                                    break;

                        }
                    }
                    if (i!=0) { 
                        switch (j) {
                                    case 0: out.println ("<TH>" + palabrasSeparadas[i-1] + "</TH>");
                                            break;
                                    case 1: if (dias[j]==Integer.parseInt(SqlDay[i-1]) && Month==Integer.parseInt(SqlMonth[i-1]) && Year==Integer.parseInt(SqlYear[i-1]) && Integer.parseInt(DayOff[i-1])==1) {
                                                out.println ("<TD id=\"" + i + ".1\"><p>Day Off</p></TD>");
                                            }else { out.println ("<TD id=\"" + i + ".1\"><p>&nbsp</p></TD>");}
                                            break;
                                    case 2: if (dias[j]==Integer.parseInt(SqlDay[i-1]) && Month==Integer.parseInt(SqlMonth[i-1]) && Year==Integer.parseInt(SqlYear[i-1]) && Integer.parseInt(DayOff[i-1])==1) {
                                                out.println ("<TD id=\"" + i + ".2\"><p>Day Off</p></TD>");
                                            }else { out.println ("<TD id=\"" + i + ".2\"><p>&nbsp</p></TD>");}
                                            break;
                                    case 3: if (dias[j]==Integer.parseInt(SqlDay[i-1]) && Month==Integer.parseInt(SqlMonth[i-1]) && Year==Integer.parseInt(SqlYear[i-1]) && Integer.parseInt(DayOff[i-1])==1) {
                                                out.println ("<TD id=\"" + i + ".3\"><p>Day Off</p></TD>");
                                            }else { out.println ("<TD id=\"" + i + ".3\"><p>&nbsp</p></TD>");}
                                            break;
                                    case 4: if (dias[j]==Integer.parseInt(SqlDay[i-1]) && Month==Integer.parseInt(SqlMonth[i-1]) && Year==Integer.parseInt(SqlYear[i-1]) && Integer.parseInt(DayOff[i-1])==1) {
                                                out.println ("<TD id=\"" + i + ".4\"><p>Day Off</p></TD>");
                                            }else { out.println ("<TD id=\"" + i + ".4\"><p>&nbsp</p></TD>");}
                                            break;
                                    case 5: if (dias[j]==Integer.parseInt(SqlDay[i-1]) && Month==Integer.parseInt(SqlMonth[i-1]) && Year==Integer.parseInt(SqlYear[i-1]) && Integer.parseInt(DayOff[i-1])==1) {
                                                out.println ("<TD id=\"" + i + ".5\"><p>Day Off</p></TD>");
                                            }else { out.println ("<TD id=\"" + i + ".5\"><p>&nbsp</p></TD>");}
                                            break;
                                    case 6: if (dias[j]==Integer.parseInt(SqlDay[i-1]) && Month==Integer.parseInt(SqlMonth[i-1]) && Year==Integer.parseInt(SqlYear[i-1]) && Integer.parseInt(DayOff[i-1])==1) {
                                                out.println ("<TD id=\"" + i + ".6\"><p>Day Off</p></TD>");
                                            }else { out.println ("<TD id=\"" + i + ".6\"><p>&nbsp</p></TD>");}
                                            break;
                                    case 7: if (dias[j]==Integer.parseInt(SqlDay[i-1]) && Month==Integer.parseInt(SqlMonth[i-1]) && Year==Integer.parseInt(SqlYear[i-1]) && Integer.parseInt(DayOff[i-1])==1) {
                                                out.println ("<TD id=\"" + i + ".7\"><p>Day Off</p></TD>");
                                            }else { out.println ("<TD id=\"" + i + ".7\"><p>&nbsp</p></TD>");}
                                            break;
                        }
                    }
                }
                out.println("</TR>");
            }
            out.println("</TABLE>  <p align=\"center\">");
            out.println("</body>");
            out.println("</html>");
            out.flush();
            out.close();
            
            //out.println(resString);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Resulset: " + sql + " Exception: " + e);
        }
        out.close();

        // String strFilas = request.getParameter("employee");
        // int intFilas = Integer.parseInt(strFilas);
        // int intColumnas = 7 ;
        
        
        // String[] name=new String[intFilas] ;
        
        // for (int a=0; a<intFilas ; a++) {
            // name [a] = request.getParameter("name" + (a+1));
        // }
    }
}