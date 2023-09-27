package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import service.AccountService;
import service.AccountServiceImpl;

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
		Integer money = Integer.parseInt(request.getParameter("money")) ;
		
		try {
			AccountService service= new AccountServiceImpl();
			service.deposit(id, money);
			response.sendRedirect("accountinfo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}


}
