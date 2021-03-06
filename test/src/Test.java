/** works connecting to my access DB **/

import java.sql.*;
public class Test
{
 public static void main(String[] args)
 {
 try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

String dataSourceName = "Source";
String dbURL = "jdbc:odbc:" + dataSourceName;
Connection con = DriverManager.getConnection(dbURL, "",""); 
// try and create a java.sql.Statement so we can run queries
Statement s = con.createStatement();
s.execute("SELECT * FROM Users1");
//s.execute("SELECT Salary FROM Employee"); // select the data from the table
ResultSet rs = s.getResultSet(); // get any ResultSet that came from our query
if (rs != null) // if rs == null, then there is no ResultSet to view
while ( rs.next() ) // this will step through our data row-by-row
{
/* the next line will get the first column in our current row's ResultSet 
 as a String ( getString( columnNumber) ) and output it to the screen */ 
System.out.println("Data from column_name: " + rs.getString("Username"));
}

s.close(); // close the Statement to let the database know we're done with it
con.close(); // close the Connection to let the database know we're done with it
 


 
 
 }
 
 catch (Exception err) {
System.out.println("ERROR: " + err);
 }
 }
}