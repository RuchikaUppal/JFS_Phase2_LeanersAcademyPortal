package mypackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(userName.equals("admin") && password.equals("admin")) {
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
			
			
		}else {
			out.println("<p style='background-color:red; font-size: 30px; margin-right: 300px; text-align: center;'>Login name or password is incorrect....<p>");
			
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			
			rd.include(request, response);
			
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
