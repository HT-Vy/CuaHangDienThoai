package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangBean;
import bean.LichSuMuaHangBean;
import bo.ChiTietHDBo;
import bo.LichSuMuaHangBo;
import bo.LoaiBo;

/**
 * Servlet implementation class LichSuMuaHangController
 */
@WebServlet("/LichSuMuaHangController")
public class LichSuMuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuMuaHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			LoaiBo lbo = new LoaiBo();
			request.setAttribute("dsLoai", lbo.getLoai());
			HttpSession session =request.getSession();
			ArrayList<LichSuMuaHangBean> dsls = new ArrayList<LichSuMuaHangBean>();
			String sotrang = request.getParameter("sotrang");
			int n=0;
			if(session.getAttribute("dn")==null) {
				response.sendRedirect("DangNhapController");
			}else {
				LichSuMuaHangBo lsbo = new LichSuMuaHangBo();
				KhachHangBean kh = (KhachHangBean)session.getAttribute("dn"); //Lấy mã khách hàng
				dsls = lsbo.PhanTrangLSMuaHang(1, kh.getMaKH());
				n = lsbo.getLichSu(kh.getMaKH()).size();
				if(sotrang!=null) {
					dsls = lsbo.PhanTrangLSMuaHang(Integer.parseInt(sotrang), kh.getMaKH());
				}
			}
			//Hủy đơn
			
			String mdh = request.getParameter("mdh");
			if(mdh!=null) {
				ChiTietHDBo ctbo = new ChiTietHDBo();
				ctbo.XoaDonHang(Long.parseLong(mdh));
				response.sendRedirect("LichSuMuaHangController");
			}
			request.setAttribute("dsLichSu", dsls);
			request.setAttribute("SoSach", n);
			RequestDispatcher rd = request.getRequestDispatcher("LichSuMuaHang.jsp");
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
