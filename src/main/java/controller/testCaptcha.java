package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nl.captcha.Captcha;
/**
 * Servlet implementation class testCaptcha
 */
@WebServlet("/testCaptcha")
public class testCaptcha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testCaptcha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
		request.setCharacterEncoding("UTF-8");
		String answer = request.getParameter("answer");
		if(answer==null)
			response.sendRedirect("Captcha.jsp");
		else
			if (captcha.isCorrect(answer)) {
				session.setAttribute("dem", (int)0);
				if(session.getAttribute("captcha_ad")!=null)
					response.sendRedirect("AdminDangNhapController");
				else
					response.sendRedirect("DangNhapController");
	
			} else {
				response.sendRedirect("testCaptcha");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
