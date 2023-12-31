package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class accountinfo
 */
@WebServlet("/accountinfo")
public class accountinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accountinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("id")==null) {
			request.setAttribute("err", "로그인하세요.");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		};
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountinfoform.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id =request.getParameter("id");
		
		HttpSession session = request.getSession();
		
		Account acc = (Account)session.getAttribute(id);
		
		
		RequestDispatcher dispatcher = null;

		if (acc!=null) {
			request.setAttribute("acc", acc);
			dispatcher = request.getRequestDispatcher("accountinfo.jsp");
			
		}else {
			request.setAttribute("err","계좌번호가 틀립니다");
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		dispatcher.forward(request, response);
	
	
	}

}
