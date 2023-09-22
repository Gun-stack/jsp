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
 * Servlet implementation class MakeAccount
 */
@WebServlet("/makeaccount")
public class MakeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MakeAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("id")==null) {
			req.setAttribute("err", "로그인하세요");
			req.getRequestDispatcher("error.jsp").forward(req, resp);
			return;
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("makeaccount.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Integer money = Integer.parseInt(request.getParameter("money"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");//1 request 입력 값 가져옴
		if (grade==null) {grade="";
			
		}
		
		Account acc = new Account(id, name, money, type, grade);//2.어카운트 객체생성
		
		
		HttpSession session = request.getSession();//3. 세션을 얻어옴
		
		session.setAttribute(id, acc);//4. 객체를 세션에 넣음
		
		request.setAttribute("acc", acc); //5.생성된 객체를 리퀘스트에
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountinfo.jsp");
		dispatcher.forward(request, response);
	}
}