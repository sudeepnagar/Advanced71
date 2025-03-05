package test;

import java.util.*;
import java.sql.*;
import java.io.*;
public class DBCon10In {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","System","tiger");
			
			PreparedStatement ps=con.prepareStatement
					("insert into StreamTab71 values(?,?,?)");
			System.out.println("Enter the User-Id to Store image:");
			String id=s.nextLine();
			System.out.println("Enter the User-Name:");
			String name=s.nextLine();
			System.out.println("Enter the path(source) User-Image:");
			String path=s.nextLine();
			File f=new File(path);
			if(f.exists()) {
				FileInputStream fis=new FileInputStream(path);
				ps.setString(1,id);
				ps.setString(2, name);
				ps.setBinaryStream(3, fis,f.length());
				int k=ps.executeUpdate();
				if(k>0) {
					System.out.println("Image Stored Successfully...");
				}else {
					System.out.println("Invalid fPath or fName...");
					
				}
				con.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
