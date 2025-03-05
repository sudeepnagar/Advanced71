package JDBC_Day_5;

import java.util.*;
import java.sql.*;
public class OnlineTransaction {
   // long  senderAccount=123456;
     long receiverAccount=654321;
    static float  transferAmount=500.0f;
    static Connection con=null;
    
    public static double getAccountBalance(long senderAccount)
    {
    	try {
			PreparedStatement ps=con.prepareStatement("select BALANCE from accounts where Account_Number=?");
			ps.setLong(1, senderAccount);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
    }
    
    public static void updateAccountBalance(long senderAccount,double sederBalance) {
    	try {
    		
    		PreparedStatement ps=con.prepareStatement("update Accounts set balance=? where account_number=?");
    		ps.setDouble(1, sederBalance);
    		ps.setLong(2, senderAccount);
    		int k=ps.executeUpdate();
    		if(k>0) {
    			System.out.println("Amount transferred successfully...");
    		}
    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		try(s;) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			con.setAutoCommit(false);
			System.out.println("Enter sender account number:");
			long senderAccountNumber=s.nextLong();
			double senderBalance=getAccountBalance(senderAccountNumber);
			
			System.out.println("Enter receiver account number:");
			long recieverAccountNumber=s.nextLong();
			double recieverBalance=getAccountBalance(recieverAccountNumber);
			
			if(senderBalance<transferAmount) {
				System.err.println("Insufficient funds in the sender's account...");
				System.exit(0);
			}else {
			   double deduct=senderBalance-transferAmount;
				updateAccountBalance(senderAccountNumber, deduct);
				
				double recieve=recieverBalance+transferAmount;
				updateAccountBalance(recieverAccountNumber, recieve);
				con.commit();
				System.out.println("Transfer successfull...");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
