package test;
import java.util.*;
import java.sql.*;
public class DBCon8 {

	public static void main(String[] args) {
		 
		Scanner s=new Scanner(System.in);
	
		try(s;){
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con= DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement ps1=con.prepareStatement
					("insert into Employee71 values(?,?,?,?,?,?,?)");
			PreparedStatement ps2=con.prepareStatement
					("select * from Employee71 ");
			PreparedStatement ps3=con.prepareStatement
					("select * from Employee71 where eid=?");
			PreparedStatement ps4=con.prepareStatement
					("update Employee71 set bsal=?,hra=?,da=?,totsal=? where eid=?");
			PreparedStatement ps5=con.prepareStatement
					("delete from Employee71 where eid=?");
			
			
			while(true)
			{
				System.out.println("*****Employee Operations Choice*****");
				System.out.println("\t1.AddEmployee"
				+ "\n\t2.ViewAllEmployees"
				+ "\n\t3.ViewEmployeeById"
				+ "\n\t4.UpdateEmployee"
				+ "\n\t5.DeleteEmployee"
				+ "\n\t6.Exit");
				System.out.println("Enter your Choice:");
				int choice=Integer.parseInt(s.nextLine());
				switch(choice)
				{
				case 1: 
					System.out.println("=====read new Employee details====");
					System.out.println("Enter the Emp-Id:");
					String eId=s.nextLine();
					System.out.println("Enter the Emp-Name:");
					String eName=s.nextLine();
					System.out.println("Enter the Emp-Desg:");
					String eDesg=s.nextLine();
					System.out.println("Enter the Emp-Bsal:");
					int bSal=Integer.parseInt(s.nextLine());
					float hra=0.91F*bSal;
					float da=0.63F*bSal;
					float totSal=bSal+hra+da;
					
					//Load the data to PrepareStatement Object
					ps1.setString(1, eId);
					ps1.setString(2, eName);
					ps1.setString(3, eDesg);
					ps1.setInt(4, bSal);
					ps1.setFloat(5, hra);
					ps1.setFloat(6, da);
					ps1.setFloat(7, totSal);
					
					int k=ps1.executeUpdate();//Execution process
					if(k>0)
					{
						System.out.println("Employee Added Successfully...");
					}
					break;
				case 2:
					ResultSet rs1=ps2.executeQuery();//Execution
					System.out.println("-------Employee Details------");
					while(rs1.next()) {
						System.out.println(rs1.getString(1)+"\t"
						+rs1.getString(2)+"\t"
						+rs1.getString(3)+"\t"
						+rs1.getInt(4)+"\t"
						+rs1.getFloat(5)+"\t"
						+rs1.getFloat(6)+"\t"
						+rs1.getFloat(7));
					}
					break;
				case 3:
					System.out.println("Enter the Emp-Id to display the details:");
					String empId=s.nextLine();
					
					//Load the data to PreparedStatement Object
					ps3.setString(1,empId);
					ResultSet rs2=ps3.executeQuery();
					if(rs2.next()) {
						System.out.println(rs2.getString(1)+"\t"
								+rs2.getString(2)+"\t"
								+rs2.getString(3)+"\t"
								+rs2.getInt(4)+"\t"
								+rs2.getFloat(5)+"\t"
								+rs2.getFloat(6)+"\t"
								+rs2.getFloat(7));
					}else {
						System.out.println("Invalid EmpId....");
					}
					break;
				case 4:
					System.out.println("Enter the Emp-Id to perform Update Operation:");
					String empId2=s.nextLine();
					ps3.setString(1, empId2);
					ResultSet rs3=ps3.executeQuery();
					if(rs3.next()) {
						System.out.println("Existing bSal:"+rs3.getInt(4));
						System.out.println("Enter the new bSal:");
						int nBSal=Integer.parseInt(s.nextLine());
						float hra2=0.91F*nBSal;
						float da2=0.63F*nBSal;
						float totSal2=nBSal+hra2+da2;
						
						//Loading data to PreparedStatement Object
						ps4.setInt(1, nBSal);
						ps4.setFloat(2, hra2);
						ps4.setFloat(3, da2);
						ps4.setFloat(4, totSal2);
						ps4.setString(5, empId2);
						int k2 = ps4.executeUpdate();
						
						if(k2>0) {
							System.out.println("Employee Updated Successfully...");
							}
							}else {
							System.out.println("Invalid EmpId....");
							}
					break;
				case 5:
					System.out.println("Enter the Emp-Id to perform Delete Operation:");
					String empId3 = s.nextLine();
					ps3.setString(1, empId3);
					ResultSet rs4 = ps3.executeQuery();
					if(rs4.next()) {
					ps5.setString(1, empId3);
					int k4 = ps5.executeUpdate();
					if(k4>0) {
					System.out.println("Employee deleted Successfully....");
					}
					}else {
					System.out.println("Invalid empId...");
					}
					break;
				case 6:
					System.out.println("Operation Stopped...");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice....");
				}
			}
			
			       
			
		} catch (Exception e) {
			
		}

	}

}
