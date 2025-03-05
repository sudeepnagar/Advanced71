package test;
import java.sql.*;
import java.sql.DriverManager;

public class DBCon1 {

	public static void main(String[] args) {
		
		try {
			//step-1 : Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//step-2 : Creating Connection to Database Product
		    Connection con= DriverManager.getConnection
		    		("jdbc:oracle:thin:@Localhost:1521:xe","system","tiger");
		    
		    //step -3 : Preparing JDBC-statement
		    Statement stm= con.createStatement();
		    
		    //step-4 : Executing query
		    ResultSet rs= stm.executeQuery("select * from BookDetails71");
		    System.out.println("---------BookDetails---------");
		    while(rs.next())
		    {
		    	System.out.println(rs.getInt(1)+"\t"
		    	                   + rs.getString(2)+"\t"
		    	                   +rs.getString(3)+"\t"
		    	                   +rs.getString(4)+"\t"
		    	                   +rs.getString(5));
		    }//end of while
		    
		    //step-5 : Close the Connection from Database product
		    con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
