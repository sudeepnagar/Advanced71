package JDBC_Day_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Employee {
        int id;
        String name;
        int age;
        double salary;
        
	public Employee(int id, String name, int age, double salary) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.salary = salary;
		}

	public static void main(String[] args) {
		ArrayList<Employee> list=new ArrayList<Employee>();
		
		try {
			
            Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			PreparedStatement ps= con.prepareStatement("select * from employee where age>25");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
//				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)
//	    		+"\t"+rs.getInt(3)+"\t"+rs.getDouble(4));
				Employee e=new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
				list.add(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Employee e : list) {
			System.out.println(e.id+"\t"+e.name+"\t"+e.age+"\t"+e.salary);
		}
	}

}
