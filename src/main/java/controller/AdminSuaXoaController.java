package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SanPhamBean;
import bo.AdminBo;
import bo.ChiTietHDBo;
import bo.SanPhamBo;

/**
 * Servlet implementation class AdminSuaXoaController
 */
@WebServlet("/AdminSuaXoaController")
public class AdminSuaXoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSuaXoaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AdminBo ctbo = new AdminBo();
			//! XÓA hóa đơn trong chi tiết hóa đơn
			String xoahd = request.getParameter("macthd");
			if(xoahd != null) {
				ctbo.AdminXoaDonHang(Long.parseLong(xoahd));
			//Chạy về lại trang admin xác nhận
				response.sendRedirect("AdminXacNhanController");
			}
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
