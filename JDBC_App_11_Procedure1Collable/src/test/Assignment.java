package test;

import java.util.*;
import java.sql.*;

public class Assignment {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			CallableStatement cs = con.prepareCall("{call InsertEmployee71(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			System.out.println("Enter the Emp-Id:");
			String eId = s.nextLine();
			System.out.println("Enter the Emp-Name:");
			String eName = s.nextLine();
			System.out.println("Enter the Emp-desg");
			String edesg = s.nextLine();
			System.out.println("Enter the Emp-HNO:");
			String hNo = s.nextLine();
			System.out.println("Enter the Emp-SName:");
			String sName = s.nextLine();
			System.out.println("Enter the Emp-City:");
			String city = s.nextLine();
			System.out.println("Enter the Emp-State:");
			String state = s.nextLine();
			System.out.println("Enter the Emp-PinCode:");
			int pinCode = Integer.parseInt(s.nextLine());
			System.out.println("Enter the Emp-MailId:");
			String mId = s.nextLine();
			System.out.println("Enter the Emp-PhoneNo:");
			long phNo = Long.parseLong(s.nextLine());
			System.out.println("Enter the Emp-bsal:");
			int bsal = Integer.parseInt(s.nextLine());
			System.out.println("Enter the Emp-hra:");
			int hra = Integer.parseInt(s.nextLine());
			System.out.println("Enter the Emp-da:");
			int da = Integer.parseInt(s.nextLine());
			int totsal = hra+da+bsal;
			
			
			cs.setString(1, eId);
			cs.setString(2, eName);
			cs.setString(3, edesg);
			cs.setString(4, hNo);
			cs.setString(5, sName);
			cs.setString(6, city);
			cs.setString(7, state);
			cs.setInt(8, pinCode);
			cs.setString(9, mId);
			cs.setLong(10, phNo);
			cs.setInt(11,bsal);
			cs.setInt(12,hra);
			cs.setInt(13,totsal);
			cs.setInt(14,da);
			cs.execute();//Procedure executed
			System.out.println("Employee details inserted Successfully...");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
