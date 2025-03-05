package test;

import java.sql.*;
import java.util.*;
public class DBCon14 {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		try(s;) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			PreparedStatement ps1=con.prepareStatement
					("select * from Bank71 where accno=?");
			PreparedStatement ps2=con.prepareStatement
					("update Bank71 set balance=balance+? where accNo=?");
			
			System.out.println("Commit Status : "+con.getAutoCommit());
			con.setAutoCommit(false);
			System.out.println("Commit Status : "+con.getAutoCommit());
			Savepoint sp=con.setSavepoint();
			System.out.println("Enter the HomeAccNo:");
			Long hAccNo=s.nextLong();
			ps1.setLong(1, hAccNo);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next()) {
				float bal=rs1.getFloat(3);
				System.out.println("Enter benificieryAccNo:");
				Long bAccNo=s.nextLong();
				ps1.setLong(1, bAccNo);
				ResultSet rs2=ps1.executeQuery();
				if(rs2.next()) {
					System.out.println("Enter the amount to be transferred:");
					float amt=s.nextFloat();
					if(amt<=bal) {
						//Statement-1 :Subtract amount 5000/- from accNO:6123456
						ps2.setFloat(1, -amt);
						ps2.setLong(2, hAccNo);
						int p=ps2.executeUpdate();//Updated in Buffer
					  //Statement-2 : Add amount 5000/- to accNo:313131
					    ps2.setFloat(1, +amt);
						ps2.setLong(2, bAccNo);
						int q=ps2.executeUpdate();//Updated in Buffer
						if(p==1&&q==1) {
							con.commit();
							System.out.println("Transaction Successfully....");
							
						}else {
							con.rollback(sp);
							System.out.println("Transaction Failed....");
						}
						
					}else {
						System.out.println("Insufficient fund....");
					}
				}else {
					System.out.println("Invalid bAccNO....");
				}
			}else {
				System.out.println("Invalid HomeAccno....");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
