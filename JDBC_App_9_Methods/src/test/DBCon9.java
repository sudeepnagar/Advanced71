package test;

import java.sql.*;
import java.util.*;
public class DBCon9 {

	public static void main(String[] args) {
		
		try {
			
            Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con= DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			PreparedStatement ps=con.prepareStatement
					("select * from BookDetails71",ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=ps.executeQuery();
			System.out.println("******absolut(2)*******");
			rs.absolute(2);

			System.out.println(rs.getString(1)+"\t"
			+rs.getString(2)+"\t"
			+rs.getString(3)+"\t"
			+rs.getFloat(4)+"\t"
			+rs.getInt(5));
			System.out.println("******relative(-1)*******");
			rs.relative(-1);
			System.out.println(rs.getString(1)+"\t"
			+rs.getString(2)+"\t"
			+rs.getString(3)+"\t"
			+rs.getFloat(4)+"\t"
			+rs.getInt(5));
			System.out.println("******Last()******");
			rs.last();
			System.out.println(rs.getString(1)+"\t"
			+rs.getString(2)+"\t"
			+rs.getString(3)+"\t"
			+rs.getFloat(4)+"\t"
			+rs.getInt(5));
			System.out.println("******afterLast()*******");

			rs.afterLast();
			while(rs.previous()) {
			System.out.println(rs.getString(1)+"\t"
			+rs.getString(2)+"\t"
			+rs.getString(3)+"\t"
			+rs.getFloat(4)+"\t"
			+rs.getInt(5));
			}//end of loop
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
