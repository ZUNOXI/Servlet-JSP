package edu.dispatch;

import java.io.IOException;

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
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//1 한글처리 2. 파라미터 처리 3. 업무처리 4. 출력처리
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		boolean islogin = false;
		
		if(passwd.equals("ssafy")) {
			islogin = true;
		}else {
			islogin = false;
		}
		
		if(islogin) {
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			String msg = "로그인이 성공되었습니다.";
			request.setAttribute("id", id);
			request.setAttribute("passwd", passwd);
			request.setAttribute("resultstr", msg);
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("login.html");
		}
	}

}
