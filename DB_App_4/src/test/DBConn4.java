package test;
import java.sql.*;
import java.util.*;
public class DBConn4 {

	public static void main(String[] args) {
		
Scanner sc=new Scanner(System.in);
        
		try(sc;) {
			System.out.println("Enter The Product-Code:");
			int pCode=Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter the Product-Name:");
			String pName= sc.nextLine();
			
			System.out.println("Enter the Product-Price:");
		    float pPrice= Float.parseFloat(sc.nextLine());
		    
		    System.out.println("Enter the Product-Qty:");
		    int pQty=Integer.parseInt(sc.nextLine());
		    
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection
		    		("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		    
		    Statement stm=con.createStatement();
		    int k=stm.executeUpdate
		    		("insert into Product71 values("+pCode+",'"+pName+"',"+pPrice+","+pQty+")");
		    
		    if(k>0) {
		    	System.out.println("Book Details inserted Successfully...");
		    	
		    }
		    con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
