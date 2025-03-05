package test;
import java.sql.*;
import java.util.*;
public class DBCon3 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
        
		try(sc;) {
			System.out.println("Enter The Book-Code:");
			int bCode=Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter the Book-Name:");
			String bName= sc.nextLine();
			
			System.out.println("Enter the Book-Author:");
			String bAuthor= sc.nextLine();
			
			System.out.println("Enter the Book-Price:");
		    float bPrice= Float.parseFloat(sc.nextLine());
		    
		    System.out.println("Enter the Book-Qty:");
		    int bQty=Integer.parseInt(sc.nextLine());
		    
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con=DriverManager.getConnection
		    		("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		    
		    Statement stm=con.createStatement();
		    int k=stm.executeUpdate
		    		("insert into BookDetails71 values("+bCode+",'"+bName+"','"+bAuthor+"',"+bPrice+","+bQty+")");
		    
		    if(k>0) {
		    	System.out.println("Book Details inserted Successfully...");
		    	
		    }
		    con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
