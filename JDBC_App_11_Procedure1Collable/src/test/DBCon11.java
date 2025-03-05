package test;
import java.util.*;
import java.sql.*;
public class DBCon11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			CallableStatement cs = con.prepareCall("{call InsertCustomer71(?,?,?,?,?,?,?,?,?)}");
			
			System.out.println("Enter the Cust-Id:");
			String cId = s.nextLine();
			System.out.println("Enter the Cust-Name:");
			String cName = s.nextLine();
			System.out.println("Enter the Cust-HNO:");
			String hNo = s.nextLine();
			System.out.println("Enter the Cust-SName:");
			String sName = s.nextLine();
			System.out.println("Enter the Cust-City:");
			String city = s.nextLine();
			System.out.println("Enter the Cust-State:");
			String state = s.nextLine();
			System.out.println("Enter the Cust-PinCode:");
			int pinCode = Integer.parseInt(s.nextLine());
			System.out.println("Enter the Cust-MailId:");
			String mId = s.nextLine();
			System.out.println("Enter the Cust-PhoneNo:");
			long phNo = Long.parseLong(s.nextLine());
			
			cs.setString(1, cId);
			cs.setString(2, cName);
			cs.setString(3, hNo);
			cs.setString(4, sName);
			cs.setString(5, city);
			cs.setString(6, state);
			cs.setInt(7, pinCode);
			cs.setString(8, mId);
			cs.setLong(9, phNo);
			cs.execute();//Procedure executed
			System.out.println("Customer details inserted Successfully...");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
