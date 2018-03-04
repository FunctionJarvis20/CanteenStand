
package canteenstand.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
                    public static String query;
	public static Connection con;
	public static Statement st;
	
	public static void loginCheck(String username,String password)
	{
		query="select * from canteenapplication.adminstandlogin where admin_username='"+username+"' &&admin_ password='"+password+"';";
	}
	public static boolean createNewAdmin(String fullname,String username,String password,String emailaddress) throws SQLException
	{
                                  query="insert into canteenapplication.adminstandlogin values (?,?,?,?);";
                                  PreparedStatement pt=con.prepareStatement(query);
                                  pt.setString(1, fullname);
                                  pt.setString(2, username);
                                  pt.setString(3, password);
                                   pt.setString(4, emailaddress);
                                 int i=pt.executeUpdate();
                                 if(i==1)
                                 {
                                         return true;
                                 }
                                 else
                                 {
                                         return false;
                                 }
                                 
	}
        public static boolean addInventory(String foodid,String foodname,int foodquantity) throws SQLException
        {
                query="insert into canteenapplication.inventorydetails values (?,?,?);";
                  PreparedStatement pt=con.prepareStatement(query);
                                  pt.setString(1, foodid);
                                  pt.setString(2, foodname);
                                  pt.setInt(3, foodquantity);
                                    int i=pt.executeUpdate();
                                    if(i==1)
                                     {
                                         return true;
                                 }
                                 else
                                 {
                                         return false;
                                 }
                                 
        }
	public Database() {
		try {
			String URL="jdbc:mysql://localhost:3306/canteenapplication?autoReconnect=true&useSSL=false";
			String pass="ActiveJarvis20";
			String user="FunctionJarvis20";
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,user,pass);
			 st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}
