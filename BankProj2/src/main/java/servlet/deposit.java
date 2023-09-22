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
 * Servlet implementation class deposit
 */
@WebServlet("/deposit")
public class deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id =request.getParameter("id")	;
		String money = request.getParameter("money");
		
		HttpSession session = request.getSession();
		
		Account acc = (Account)session.getAttribute(id);
		acc.deposit(Integer.parseInt(money));
		session.getAttribute(money);
		
		RequestDispatcher dispatcher = null ;
		
		if (acc!=null) {
			dispatcher =request.getRequestDispatcher("accountinfo.jsp");
			request.setAttribute("acc", acc);
		}else {
			dispatcher =request.getRequestDispatcher("error.jsp");
			request.setAttribute("err","계좌번호가 틀립니다");
		}
		
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("id")==null) {
			req.setAttribute("err", "로그인하세요");
			req.getRequestDispatcher("error.jsp").forward(req, resp);
			return;
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("deposit.jsp");
		dispatcher.forward(req, resp);
	
	
	}
	

}
