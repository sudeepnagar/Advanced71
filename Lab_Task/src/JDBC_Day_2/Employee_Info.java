package JDBC_Day_2;

import java.sql.*;
import java.util.Scanner;

public class Employee_Info {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try(sc;) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement ps=conn.prepareStatement("insert into employee_info values(?,?,?,?,?,?)");
			PreparedStatement ps1=conn.prepareStatement("select * from Employee_Info");
			PreparedStatement ps2=conn.prepareStatement("select * from employee_info where empName like 'S%' ");
			PreparedStatement ps3=conn.prepareStatement("select * from employee_info where empsalary between 10000 and 20000");
			PreparedStatement ps4=conn.prepareStatement("select * from employee_info where empid=?");
			PreparedStatement ps5=conn.prepareStatement("update employee_info set empSalary=? where empId=?");
			PreparedStatement ps6=conn.prepareStatement("delete from employee_info where empsalary=(select max(empsalary) from employee_info)");
			PreparedStatement ps7=conn.prepareStatement("delete from employee_info where empName like '%a' ");
			
			while(true) {
			System.out.println("1. Insert data into Employee Table\n"
					+ "2.Retrieve all Employee data\n"
					+"3.Retrieve employee whose name starts with 'S'\n"
					+ "4.Retrieve employees whose salary between 10000 to 20000\n"
					+ "5.Update employee salary with the help of eid.\n"
					+ "6.delete employee who is getting maximum salary.\n"
					+ "7.delete employee whose name ends with 'a'\n"
					+ "8.Exit.");
			System.out.println("Enter your choice:");
			int choice =sc.nextInt();
			
			switch(choice)
			{
			    case 1:
			    {
			    	
			    	//ps=conn.prepareStatement("insert into employee_info values(?,?,?,?,?,?)");
//			    	ps.setInt(1, 121);
//			    	ps.setString(2, "Rahat");
//			    	ps.setDouble(3, 5000);
//			    	ps.setString(4, "Hyderabad");
//			    	ps.setString(5, "rahat50@gmail.com");
//			    	ps.setLong(6, 654646466);
			    	System.out.println("Enter empId:");
			    	int eId=sc.nextInt();
			    	sc.nextLine();
			    	System.out.println("Enter empName:");
			    	String eName=sc.nextLine();
			    	System.out.println("Enter empSalary:");
			    	int eSalary=sc.nextInt();
			    	sc.nextLine();
			    	System.out.println("Enter empAddress:");
			    	String eAddress=sc.nextLine();
			    	System.out.println("Enter empEmailId:");
			    	String eEmail=sc.nextLine();
			    	System.out.println("Enter empPhone:");
			    	long ePhone=sc.nextLong();
			    	
                      ps.setInt(1, eId);
                      ps.setString(2, eName);
                      ps.setInt(3, eSalary);
                      ps.setString(4, eAddress);
                      ps.setString(5, eEmail);
                      ps.setLong(6, ePhone);
			    	int k=ps.executeUpdate();
			    	if(k>0) {
			    		System.out.println("Inserted successfully!");
			    	}
			    	
			    }break;
			    case 2:
			    {
			    	//ps=conn.prepareStatement("select * from Employee_Info");
			    	ResultSet rs=ps1.executeQuery();
			    	while(rs.next()) {
			    		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)
			    		+"\t"+rs.getString(3)+"\t"+rs.getString(4)
			    		+"\t"+rs.getString(5)+"\t"+rs.getBigDecimal(6));
			    	}
			    }
			    break;
			    case 3:
			    {
			    	//ps=conn.prepareStatement("select * from employee_info where empName like 'S%' ");
			    	ResultSet rs=ps2.executeQuery();
			    	while(rs.next()) {
			    		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)
			    		+"\t"+rs.getString(3)+"\t"+rs.getString(4)
			    		+"\t"+rs.getString(5)+"\t"+rs.getBigDecimal(6));
			    	}
			    }break;
			    case 4:
			    {
			    	//ps=conn.prepareStatement("select * from employee_info where empsalary between 10000 and 20000");
			    	ResultSet rs=ps3.executeQuery();
			    	while(rs.next()) {
			    		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)
			    		+"\t"+rs.getString(3)+"\t"+rs.getString(4)
			    		+"\t"+rs.getString(5)+"\t"+rs.getBigDecimal(6));
			    	}
			    }break;
			    case 5:
			    {
			    	
			    	System.out.println("Enter the emp-id to update salary:");
			    	int empid2=sc.nextInt();
			    	ps4.setInt(1, empid2);
			    	ResultSet rs=ps4.executeQuery();
			    	if(rs.next()) {
			    		System.out.println("Existing Salary:"+rs.getInt(3));
			    		System.out.println("Enter the new Salary:");
			    		int newSal=sc.nextInt();
			    		ps5.setInt(1, newSal);
			    		ps5.setInt(2, empid2);
			    		int k=ps5.executeUpdate();
			    		if(k>0) {
			    			System.out.println("Emp salary updated successfull!");
			    		}
			    	}
			    	else {
		    			System.out.println("Invalid empid...");
		    		}
			    	
			    }break;
			    case 6:
			    {
			    	int k=ps6.executeUpdate();
			    	if(k>0) {
			    		System.out.println("employee with max salary deleted successfully......");
			    		
			    	}
			    }break;
			    case 7:
			    {
			    	int k=ps7.executeUpdate();
			    	if(k>0) {
			    		System.out.println("employee name ends with 'a' deleted successfully......");
			    		
			    	}else {
			    		System.out.println("not available");
			    	}
			    }break;
			    case 8:
			    {
			    	System.out.println("Exited successfully!");
			    	System.exit(0);
			    }
			}
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
