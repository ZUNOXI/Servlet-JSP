package edu.ssafy;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloDo
 */
public class HelloDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HelloDo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Cookie cookie = new Cookie("visitedTime", new Date().getMinutes()+"분");
		response.addCookie(cookie);
		
 		request.setAttribute("greeting", "Hello World Welcome to hell");
		request.getRequestDispatcher("viewCookie.jsp").forward(request, response);
//		RequestDispatcher rd = request.getRequestDispatcher("hello.jsp");
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
