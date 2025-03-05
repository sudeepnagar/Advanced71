package JDBC_Day_1;
import java.util.*;
import java.sql.*;

public class Student_Register {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement ps=null;
		System.out.println("Student register & Login Process");
		System.out.println("1.Register\n2.Login");
		System.out.println("Enter Your Choice!");
		int choice =sc.nextInt();
		switch(choice)
		{
		  case 1:
		   {
			   sc.nextLine();
			  ps=con.prepareStatement("insert into Student_Info values(?,?,?,?,?,?,?)");
			  System.out.println("Enter Your RollNo:");
			  String rollno=sc.nextLine();
			  System.out.println("Enter your Name:");
			  String name=sc.nextLine();
			  System.out.println("Enter your Percentage:");
			  float perc=sc.nextFloat();
			  sc.nextLine();
			  System.out.println("Enter your First Name:");
			  String fname=sc.nextLine();
			  System.out.println("Enter your Last Name:");
			  String lname=sc.nextLine();
			  System.out.println("Enter your Mail id:");
			  String mail=sc.nextLine();
			  System.out.println("Enter your phone no.:");
			  long ph=sc.nextLong();
			  
			  ps.setString(1, rollno);
			  ps.setString(2, name);
			  ps.setFloat(3, perc);
			  ps.setString(4, fname);
			  ps.setString(5, lname);
			  ps.setString(6, mail);
			  ps.setLong(7, ph);
			  int k=ps.executeUpdate();
			  if(k>0) {
				  System.out.println("Student Registered Successfully...");
			  }
			  
			  
		   }break;
		  case 2:
		  {
			  sc.nextLine();
			  ps=con.prepareStatement("select * from student_info where rollno=? and name=?");
			  System.out.println("Please Enter you roll no.:");
			  String roll=sc.nextLine();
			 System.out.println("Please Enter your Name:");
			 String name=sc.nextLine();
			 ps.setString(1, roll);
			 ps.setString(2, name);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next()) {
				 System.out.println("Login successfully...");
			 }else {
				 System.out.println("Invalid roll or name!");
			 }
			 
			  
		  }break;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
