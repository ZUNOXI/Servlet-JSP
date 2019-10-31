package edu.dispatch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.Manager;

/**
 * Servlet implementation class JoinServlet
 */
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Manager dao = Manager.getInstance();
	
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("pid");
		String passwd = request.getParameter("ppasswd");
		String name = request.getParameter("pname");
		
		if(dao.addManber(id, name, passwd)){
			request.setAttribute("msg", "id : "+id+" 는 등록성공되었습니다");
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else {
			response.sendRedirect("join.jsp");
		}
		
	}

}
