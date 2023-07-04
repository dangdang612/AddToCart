package LogIn.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogIn.Entity.Student;
import LogIn.Service.StudentService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String username =request.getParameter("username");
			String password =request.getParameter("password");
			String email = request.getParameter("email");
			
			StudentService studentService = new StudentService();
			
			boolean isValid = studentService.isValid(username, password);
			
			if(isValid) {
				Student student = new Student(username, password);
				studentService.insertData(student);
				
				RequestDispatcher rd = request.getRequestDispatcher("Register_Success.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("Already Registered","Please back to Register form");
				RequestDispatcher rd =request.getRequestDispatcher("Register.jsp");
				rd.forward(request, response);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doGet(request, response);
	}
}
