package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class AllAccountInfo
 */
@WebServlet("/allaccountinfo")
public class AllAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllAccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 세션의 키목록가져온다
		HttpSession session = request.getSession();
		Enumeration<String> e = session.getAttributeNames();
//		2.account 목록을 담을 어레이리스트
		List<Account> accs = new ArrayList<>();
		// 데이터 가져옴 
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			if (name.equals("member")||name.equals("id")) continue;
			
			Account acc = (Account)session.getAttribute(name);
			
			accs.add(acc);
		}
				
		RequestDispatcher dispatcher = null;
		if (session.getAttribute("id")==null) {
			request.setAttribute("err", "로그인하세요.");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		};
		
		
		if (accs.size() > 0) {
			request.setAttribute("accs", accs);
			dispatcher = request.getRequestDispatcher("allaccountinfo.jsp");
		}else {
			request.setAttribute("err", "개설된 계좌 없음");
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		dispatcher.forward(request, response);
	
	}

}
