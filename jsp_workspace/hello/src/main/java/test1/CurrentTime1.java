package test1;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrentTime1
 */
@WebServlet("/CurrentTime1")
public class CurrentTime1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CurrentTime1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("text/html");
	      response.setCharacterEncoding("utf-8");
	      Calendar c = Calendar.getInstance();
	      int hour = c.get(Calendar.HOUR_OF_DAY);
	      int minute = c.get(Calendar.SECOND);
	      int second = c.get(Calendar.SECOND);

	      request.setAttribute("hour", hour);
	      request.setAttribute("minute", minute);
	      request.setAttribute("second", second);
	      RequestDispatcher dispatcher = request.getRequestDispatcher("CurrentTime.jsp");
	      dispatcher.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
