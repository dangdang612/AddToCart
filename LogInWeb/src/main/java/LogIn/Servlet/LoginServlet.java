package LogIn.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LogIn.Entity.Student;
import LogIn.Service.StudentService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			//StudentService studentService = new StudentService();
			//Student student = new Student(username, password);
			Student student= StudentService.getUserByUsernameAndPassword(username, password);
					
			if (student == null) {
				RequestDispatcher rd = request.getRequestDispatcher("Login_Fail.jsp");
				request.setAttribute("wrong password", "Please try again");
				rd.forward(request, response);	
				//response.sendRedirect("Login_Fail.jsp");

			} else {
				HttpSession session = request.getSession(false);
				session.setAttribute("username", username);
				RequestDispatcher rd = request.getRequestDispatcher("Login_Success.jsp");
				rd.forward(request, response);
				System.out.println(username + " " + password + "success");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}

