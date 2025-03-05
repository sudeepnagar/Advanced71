package test;
import java.util.*;
import java.sql.*;
public class DBCon6 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
        
		try(sc;) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","");
			
			Statement stm= con.createStatement();
			
			System.out.println("Enter the NonSelect-Query(Create/Insert/Update/Delete)");
			String qry=sc.nextLine();
			int k=stm.executeUpdate(qry);
			
			if(k>=0)
			{
				System.out.println("Query executed Successfull...");
				System.out.println("The value in k:"+k);
				
			}
			con.close();
			
		} catch (SQLSyntaxErrorException sqe) {
			System.out.println(sqe.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
