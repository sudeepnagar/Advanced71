package test;

import java.util.*;
import java.sql.*;
public class DBCon15 {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		try(s;) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			Statement stm=con.createStatement();
			System.out.println("********Insert Operation on Bank71*****");
			System.out.println("Enter the AccNo:");
			long accNo=Long.parseLong(s.nextLine());
			System.out.println("Enter the Cust-Name:");
			String name=s.nextLine();
			System.out.println("Enter the Cust-Balance:");
			float bal=Float.parseFloat(s.nextLine());
			System.out.println("Enter the Cust-AccType:");
			String accType = s.nextLine();
			stm.addBatch("insert into Bank71 values("+accNo+",'"+name+"',"+bal+",'"+accType+"')");
			
			System.out.println("******Update Operation on BookDetails71*****");
			System.out.println("Enter the BookCode to perform Update operation:");
			int bCode = Integer.parseInt(s.nextLine());
			System.out.println("Enter the new Book Price:");
			float nPrice = Float.parseFloat(s.nextLine());
			System.out.println("Enter the new Book Qty:");
			int nQty = Integer.parseInt(s.nextLine());
			stm.addBatch("update BookDetails71 set price="+nPrice+",qty="+nQty+" where code="+bCode);

			int k[] =stm.executeBatch();
			
			for(int i : k)
			{
			  System.out.println("Query Executed : "+i);
			}
			
			stm.clearBatch();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
