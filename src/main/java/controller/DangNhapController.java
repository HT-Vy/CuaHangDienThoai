package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangBean;
import bo.KhachHangBo;
import bo.LoaiBo;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			KhachHangBo khbo = new KhachHangBo();
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			LoaiBo lbo = new LoaiBo();
			request.setAttribute("dsLoai", lbo.getLoai());
			HttpSession session =request.getSession();
			if(session.getAttribute("dem")==null)
				session.setAttribute("dem", (int)0);
			if(un!=null && pass!=null){
				KhachHangBean kh = khbo.kiemTraDangNhap(un, pass);
				if(kh!=null){
					//tạo session
					session.setAttribute("dn", kh);
					//Chuyển hướng sang sachController để lấy dsloai và dssach
					response.sendRedirect("TrangChuController");
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
			RequestDispatcher rd = request.getRequestDispatcher("DangNhap.jsp");
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
