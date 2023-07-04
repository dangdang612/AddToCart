package LogIn.DButil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_login","root","123456");
			return conn;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
}
