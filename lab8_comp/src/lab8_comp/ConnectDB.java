package lab8_comp;



import java.sql.*;
public class ConnectDB {

	public static void main(String[] args)  {
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/musicalbums", "root", "stefan123");
			
		
			if(myConn!=null)
				
			{
				System.out.println("connected succ");
			}
		} catch(Exception e){
			System.out.println("not connected to the server");
			
		}
	}
	
	
}