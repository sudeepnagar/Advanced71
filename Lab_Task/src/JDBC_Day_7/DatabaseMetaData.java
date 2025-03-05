package JDBC_Day_7;

import java.sql.*;


public class DatabaseMetaData {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
	          System.out.println("***********DatabaseMetaData**************");
	          
	    java.sql.DatabaseMetaData dmd= con.getMetaData();
	         
	         System.out.println("Prod-version: "+dmd.getDatabaseProductVersion());
	         System.out.println("Prod-Name: "+dmd.getDatabaseProductName());
	         System.out.println("Driver-Name: "+dmd.getDriverName());
	         System.out.println("Max-Col in a table: "+dmd.getMaxColumnsInTable());
	         
	      
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
