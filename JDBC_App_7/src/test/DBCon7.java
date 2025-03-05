package test;
import java.util.*;
import java.sql.*;
public class DBCon7 {

	public static void main(String[] args) {
		
Scanner sc=new Scanner(System.in);
		
		try(sc;) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			Statement stm=con.createStatement();
			
			System.out.println("Enter the ProductCode to perform Update/delete operations:");
			
			int pCode=sc.nextInt();
			
			ResultSet rs=stm.executeQuery
					("select * from Product71 where code="+pCode+"");
			
			if(rs.next()) {
				
				System.out.println("******Choice******");
				System.out.println("\t1.Update"
						            +"\n\t2.Delete");
				
				System.out.println("Enter your choice:");
				int choice=sc.nextInt();
				
				switch(choice)
				{
				case 1: 
					   System.out.println("---Perform Update Operations---");
					   System.out.println("Old Product Price:"+rs.getFloat(3));
					   System.out.println("Enter the New Product Price:");
					   float nPrice=sc.nextFloat();
					   System.out.println("Existing Product qty:"+rs.getInt(4));
					   System.out.println("Enter the New Product qty:");
					   int nQty=sc.nextInt();
					   int k=stm.executeUpdate
							   ("Update Product71 set price="+nPrice+",qty=qty+"+nQty+" where code="+pCode+"");
					   
					   if(k>0) {
						   System.out.println("Product details updated Successfully..");
					   }
					   
					break;
				case 2:
					 int k2=stm.executeUpdate
					      ("delete from Product71 where code="+pCode+"");
					 
					 if(k2>0) {
						 System.out.println("Product Details deleted Successfully..");
					 }
					break;
				default: System.out.println("Invalid choice!");
				}
			}//end of switch
			
			else {
				System.out.println("Invalid ProductCode.....");
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
