package edu.dispatch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.Manager;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Manager man;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		man = Manager.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1 한글처리
		request.setCharacterEncoding("utf-8");
		// 2 파라미터 처리
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		// 3 업무처리
		// 로그인 가능여부 처리
		boolean islogin = false;
		if (man.findId(id, passwd)) {
			islogin = true;
		} else {
			islogin = false;
		}
		// 4 출력처리
		if (islogin) {
			String msg = "로그인이 성공되었습니다";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			
			
			rd.forward(request, response);
			// System.out.println("");
		} else {
			response.sendRedirect("login.html");
		}

	}

}
