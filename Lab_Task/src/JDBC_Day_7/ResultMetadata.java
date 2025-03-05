package JDBC_Day_7;

import java.sql.*;

public class ResultMetadata {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
	 
	    java.sql.DatabaseMetaData dmd= con.getMetaData();
	    System.out.println("*******ResultsetmetaData***********");
	    PreparedStatement ps=con.prepareStatement
	    		("select * from student_info");
	    ResultSet rs = ps.executeQuery();
	    ResultSetMetaData metaData = rs.getMetaData();
	    System.out.println("****structure of table student_info******");
	    System.out.println("Number of columns: "+metaData.getColumnCount());
	    System.out.println("first Column Name:"+metaData.getColumnName(1));
	    System.out.println("first Coloumn Data type: "+metaData.getColumnTypeName(1));
	    
	    System.out.println("*******ParametermetaData***********");
	    PreparedStatement ps1=con.prepareStatement("insert into student_info values(?,?,?,?,?,?,?)");
	    java.sql.ParameterMetaData pm=ps1.getParameterMetaData();
	    System.out.println("Para-count: "+pm.getParameterCount());
	    
	    
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
