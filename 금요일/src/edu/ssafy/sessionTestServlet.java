package edu.ssafy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sessionTestServlet
 */
public class sessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sessionTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		
		if(session.isNew()) {
			
			out.println("NEW <br/>");
			out.println("Session ID:"+session.getId());
			out.println("생성시간:"+new Date(session.getCreationTime()));
			out.println("최근접근시간:"+
			new Date(session.getLastAccessedTime()));
			
			out.println("Max Inactive Interval:"+
			session.getMaxInactiveInterval());
			
			session.setMaxInactiveInterval(1200);
		}
		else {
			out.println("OLD Session <br/>");
			out.println("Session ID:"+session.getId());
			out.println("생성시간:"+new Date(session.getCreationTime()));
			out.println("최근접근시간:"+

			new Date(session.getLastAccessedTime()));
			
			out.println("Max Inactive Interval:"+
			session.getMaxInactiveInterval());
		}
	}

}
