package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;
import service.AccountService;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	HttpSession session = req.getSession();
//    	if (session.getAttribute("id")==null) {
//    		req.setAttribute("err", "로그인하세요");
//    		req.getRequestDispatcher("error.jsp").forward(req, resp);
//    		return;
//    	}
    	RequestDispatcher dispatcher = req.getRequestDispatcher("deposit.jsp");
    	dispatcher.forward(req, resp);
    	
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id =request.getParameter("id")	;
		String money = request.getParameter("money");
		
		Account acc = new Account();
		
		AccountService service= new AccountService();
		
		try {
			acc = service.deposit(id,money);
			request.setAttribute("acc",acc);
			request.getRequestDispatcher("accountinfo.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}
		
		
	}


}
