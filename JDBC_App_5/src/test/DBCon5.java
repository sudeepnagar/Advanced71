package test;
import java.sql.*;
import java.util.*;
public class DBCon5 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		try(sc;) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			Statement stm=con.createStatement();
			
			System.out.println("Enter the BookCode to perform Update/delete operations:");
			
			int bCode=sc.nextInt();
			
			ResultSet rs=stm.executeQuery
					("select * from BookDetails71 where code="+bCode+"");
			
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
					   System.out.println("Old Book Price:"+rs.getFloat(4));
					   System.out.println("Enter the New Book Price:");
					   float nPrice=sc.nextFloat();
					   System.out.println("Existing Book qty:"+rs.getInt(5));
					   System.out.println("Enter the New Book qty:");
					   int nQty=sc.nextInt();
					   int k=stm.executeUpdate
							   ("Update BookDetails71 set price="+nPrice+",qty=qty+"+nQty+" where code="+bCode+"");
					   
					   if(k>0) {
						   System.out.println("Booke details updated Successfully..");
					   }
					   
					break;
				case 2:
					 int k2=stm.executeUpdate
					      ("delete from BookDetails71 where code="+bCode+"");
					 
					 if(k2>0) {
						 System.out.println("Book Details deleted Successfully..");
					 }
					break;
				default: System.out.println("Invalid choice!");
				}
			}//end of switch
			
			else {
				System.out.println("Invalid BookCode.....");
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
