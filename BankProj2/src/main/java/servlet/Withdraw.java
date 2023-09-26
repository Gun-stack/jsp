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
 * Servlet implementation class Withdraw
 */
@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id =request.getParameter("id")	;
		Integer money = Integer.parseInt(request.getParameter("money"));
		
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute(id);
		RequestDispatcher dispatcher = null;
		
		
		if (acc!=null) {
			if (money>acc.getBalance()) {
				request.setAttribute("err","잔액이 부족합니다");
				dispatcher = request.getRequestDispatcher("error.jsp");
			}else if(money<=0){
				request.setAttribute("err","금액을 다시 입력하세요");
				dispatcher = request.getRequestDispatcher("error.jsp");
			}else {
				acc.withdraw(money);
				request.setAttribute("acc", acc);
				dispatcher = request.getRequestDispatcher("accountinfo.jsp");
				
				}
			
			
		}else {
			request.setAttribute("err","계좌번호가 틀립니다");
			dispatcher = request.getRequestDispatcher("error.jsp");
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
		
		RequestDispatcher dispatcher =req.getRequestDispatcher("withdraw.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
