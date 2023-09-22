package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
    	dispatcher.forward(req, resp);
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		//2.
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		
		RequestDispatcher dispatcher = null;
		
		
		
		if(member!=null) {
			if (member.getId().equals(id)) {
				if (member.getPassword().equals(password)) {
					session.setAttribute("id", id);
					dispatcher = request.getRequestDispatcher("makeaccount.jsp");
					}
				else {//비번
					request.setAttribute("err", "비밀번호가 틀립니다.");
					dispatcher = request.getRequestDispatcher("error.jsp");
					}
				}
				else {
					request.setAttribute("err", "아이디가 틀립니다");
					dispatcher = request.getRequestDispatcher("error.jsp");		
}
				}
			else {
			request.setAttribute("err", "회원가입이 되어있지 않음");
			dispatcher = request.getRequestDispatcher("error.jsp");
			}
		
		
		dispatcher.forward(request, response);
	}

	
	

}
