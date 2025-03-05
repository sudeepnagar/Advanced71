package test;

import java.util.*;
import java.sql.*;
public class DBCon13 {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		
		try(s;) {
			
            Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","System","tiger");
			
			CallableStatement cs=con.prepareCall
					("{call ?:= retreiveCust71(?)}");
			
			System.out.println("Enter the Cust-Id to retrieve PhoneNo:");
			String cId = s.nextLine();
			cs.setString(2, cId);
			cs.registerOutParameter(1, Types.BIGINT);
			cs.execute();//Procedure Executed...
			System.out.println("Cust-Id:"+cId);
			System.out.println("Cust-PhoneNo:"+cs.getLong(1));
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
