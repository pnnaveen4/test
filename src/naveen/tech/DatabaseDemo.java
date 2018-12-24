package naveen.tech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

public class DatabaseDemo {
	//For Variables
	private static Connection connection;
	private static DatabaseDemo dd;
	private  String  UserName;
	private  String  Password;
	private ResultSet rs;
	
	//Connection for Database
	static{
	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("Problem at class Loading in DatabaseDemo ");
			}
			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","naveen");
			} catch (SQLException e) {
		
				System.out.println("error occured at connection in DatabaseDemo class ");
			}
			System.out.println("Sucessfully connected to DataBase");
	
	}
	
	//Private Constructor
	private DatabaseDemo() {
		
	}
	 //getObject 
		public static  DatabaseDemo getObject(){
			if(dd==null) {
				dd=new DatabaseDemo();
			}
			return dd;
		}
		
	//UserName and Password 
	public boolean getUsername(String User,String Pass){
		this.UserName=User;
		this.Password=Pass;
		boolean usr = false;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("select username,password from users where username=? and password = ? ");
			ps.setString(1, UserName);
			ps.setString(2, Password);
			rs = ps.executeQuery();
			if(rs.next()) {
				  usr=true;
				}
				else {
					usr=false;
				}
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("error at getting Username and password");
		}
		return usr;
	}
	
}
