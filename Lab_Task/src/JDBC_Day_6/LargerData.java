package JDBC_Day_6;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
public class LargerData {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		try(s;) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			PreparedStatement ps1=con.prepareStatement
					("insert into emp_info values(?,?,?,?,?,?)");
			
			System.out.println("Enter emp-Id:");
			String eId=s.nextLine();
			System.out.println("Enter emp-Name:");
			String eName=s.nextLine();
			System.out.println("Enter emp-Addr:");
			String eAdd=s.nextLine();
			System.out.println("Enter emp-MailId:");
			String eMail=s.nextLine();
			System.out.println("Enter emp-PhNo:");
			long ePhNo=Long.parseLong(s.nextLine());
			System.out.println("Enter emp-resumePath:");
			String res=s.nextLine();
			File f=new File(res);
			FileInputStream fis=new FileInputStream(f);
			if(f.exists()) {
				ps1.setString(1, eId);
				ps1.setString(2, eName);
				ps1.setString(3, eAdd);
				ps1.setString(4, eMail);
				ps1.setLong(5, ePhNo);
				ps1.setBlob(6,fis,f.length());
			}
			int k=ps1.executeUpdate();
			if(k>0) {
				System.out.println("Inserted successfully...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
