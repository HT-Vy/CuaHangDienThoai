package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.AdminBo;
import bo.KhachHangBo;

/**
 * Servlet implementation class AdminDangKyController
 */
@WebServlet("/AdminDangKyController")
public class AdminDangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDangKyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//chỉnh cấu hình dữ liệu gửi đi-về utf-8
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			AdminBo adbo = new AdminBo();
			String quyen = request.getParameter("c1");
			boolean q = false;
			if(quyen!=null)
				q = true;
			String tendn = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			if(tendn!=null && pass!=null) {
				if(adbo.kiemTraDangKy(tendn) == null) {
					adbo.Them(tendn, pass,q );
					request.setAttribute("tb1", "Đăng ký thành công!");
					//Nếu đăng ký thành công thì chuyển sang trang đăng nhập
				}else {
					request.setAttribute("tb2", "Tài khoản đã tồn tại!");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("AdminDangKy.jsp");
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
