package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import bo.AdminBo;

/**
 * Servlet implementation class AdminDangNhapController
 */
@WebServlet("/AdminDangNhapController")
public class AdminDangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AdminBo adbo = new AdminBo();
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			HttpSession session =request.getSession();
			if(session.getAttribute("captcha_ad")==null)
				session.setAttribute("captcha_ad", "admin");
			if(session.getAttribute("dem")==null)
				session.setAttribute("dem", (int)0);
			if(un!=null && pass!=null){
				AdminBean dnad = adbo.KiemTraDangNhapAdmin(un, pass);
				if(dnad!=null){
					//tạo session
					session.removeAttribute("captcha_ad");
					session.setAttribute("dnad", dnad);
					//Chuyển hướng sang sachController để lấy dsloai và dssach
					response.sendRedirect("AdminXacNhanController");
					return;
				}else {
					int d = (int)session.getAttribute("dem");
					request.setAttribute("kt", "Đăng nhập sai!");
					d ++;
					session.setAttribute("dem", d);
					if((int)session.getAttribute("dem")>=3) 
						response.sendRedirect("testCaptcha");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("AdminDangNhap.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
