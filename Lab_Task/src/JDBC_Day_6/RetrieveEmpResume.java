package JDBC_Day_6;

import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
public class RetrieveEmpResume {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		try(s;) {
			

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			PreparedStatement ps1=con.prepareStatement
					("select empResume from emp_info where empPhNo=?");
			
			System.out.println("Enter Emp-PhNo to retrive resume:");
			long ePhNo=Long.parseLong(s.nextLine());
			ps1.setLong(1, ePhNo);
			ResultSet rs=ps1.executeQuery();
			if(rs.next()) {
				Blob b=rs.getBlob(1);
				byte by[]=b.getBytes(1, (int)b.length());
				System.out.println("Enter The fPath&Name(Destination) to store image0:");
				String path=s.nextLine();
				FileOutputStream fos=new FileOutputStream(path);
				fos.write(by);
				System.out.println("image retrieved and available in destination...");
				fos.close();
			}else {
				System.out.println("invalid no....");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
