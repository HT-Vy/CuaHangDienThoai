package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.GioHangBo;

/**
 * Servlet implementation class SuaXoaGHController
 */
@WebServlet("/SuaXoaGHController")
public class SuaXoaGHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaXoaGHController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		GioHangBo gh = (GioHangBo)session.getAttribute("gh");
		//! XÓA CHECKBOX
		//Lấy các giá trị checkbox(mã sách) cùng tên(c1) vào 1 mảng
		String[] gt = request.getParameterValues("c1");
		if(gt!=null)
			for(String c:gt) // Xóa ds checkbox
				gh.Xoa(c);
		
		//! CẬP NHẬT SL SÁCH
		//Lấy về giá trị của but1 chính là mã sách
		String ms = request.getParameter("but1");
		// Lấy về số lượng cần sửa
		String sl = request.getParameter(ms);
		if(ms!=null && sl!=null)
			gh.SuaSLM(ms, Long.parseLong(sl));
		
		//! XÓA 1 SÁCH
		String xoa1 = request.getParameter("ms");
		if(xoa1 != null)
			gh.Xoa(xoa1);

		// Cập nhật lại session
		session.setAttribute("gh", gh);
		
		
		//Xóa tất cả
		//Kiểm tra nếu ds giỏ hàng null thì chuyển trang sang Menu
		int n = gh.ds.size();
		if(n==0) {
			session.removeAttribute("gh");
			response.sendRedirect("TrangChuController");
		}else
			response.sendRedirect("GioHangController");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
