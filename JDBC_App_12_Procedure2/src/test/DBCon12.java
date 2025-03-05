package test;
import java.util.*;
import java.sql.*;

public class DBCon12 {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		
		try(s;) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","System","tiger");
			
			CallableStatement cs=con.prepareCall
					("{call RetrieveCustomer71(?,?,?,?,?,?,?,?,?)}");
			
			System.out.println("Enter the Cust-Id to retrieve details:");
			String cId=s.nextLine();
			cs.setString(1, cId);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6,Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.BIGINT);
			cs.execute();//Procedure Executed
			
			System.out.println("**********Customer Details********");
			System.out.println("Cust-Id:"+cId);
			System.out.println("Cust-Name:"+cs.getString(2));
			System.out.println("Cust-HNO:"+cs.getString(3));
			System.out.println("Cust-SName:"+cs.getString(4));
			System.out.println("Cust-City:"+cs.getString(5));
			System.out.println("Cust-State:"+cs.getString(6));
			System.out.println("Cust-PinCode:"+cs.getInt(7));
			System.out.println("Cust-MailId:"+cs.getString(8));
			System.out.println("Cust-PhoneNo:"+cs.getLong(9));
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
