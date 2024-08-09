package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.KhachHangBo;
import bo.LoaiBo;

/**
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController() {
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
		LoaiBo lbo = new LoaiBo();
		request.setAttribute("dsLoai", lbo.getLoai());
		KhachHangBo khbo = new KhachHangBo();
		String hoten = request.getParameter("txtht"); 
		String diachi = request.getParameter("txtdc");
		String sodt = request.getParameter("txtsodt");
		String tendn = request.getParameter("txtun");
		String pass = request.getParameter("txtpass");
		if(hoten!=null && diachi!=null && sodt!=null && tendn!=null && pass!=null) {
			if(khbo.kiemTraDangKy(tendn) == null) {
				khbo.Them(hoten, diachi, sodt, tendn, pass);
				request.setAttribute("kq1", "Đăng ký thành công!");
				//Nếu đăng ký thành công thì chuyển sang trang đăng nhập
				response.sendRedirect("DangNhapController");
				return;
			}else
				request.setAttribute("kq2", "Tài khoản đã tồn tại!");
		}
		RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp");
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
