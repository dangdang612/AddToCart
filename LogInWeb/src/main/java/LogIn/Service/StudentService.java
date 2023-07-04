package LogIn.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import LogIn.DButil.DBUtil;
import LogIn.Entity.Student;

public class StudentService {
	public void insertData (Student student) throws SQLException{
		Connection conn = null;
		PreparedStatement ps= null;
	
		try {
			conn= DBUtil.makeConnection();
			
			String sql = "INSERT INTO `student_login`. `user`(`username`,`email`,`password`) VALUES (?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,student.getUsername());
			ps.setString(3,student.getPassword());
			ps.setString(2,student.getEmail());
			
			ps.execute();
			
		} finally {
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public boolean isValid(String username, String password) {
		
		if (username != null && !username.isEmpty() && password != null
				&& !password.isEmpty()) {
			return true;
		}

		return false;

	}

	public static Student getUserByUsernameAndPassword(String username, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;

		try {
			conn = DBUtil.makeConnection();

			String sql = "SELECT * FROM `user` WHERE `username`= ? AND `password`= ?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if (rs.next()) {
				student= new Student(username,password);
			}

		} finally {

			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
			}

		}
		return student;
	}
}