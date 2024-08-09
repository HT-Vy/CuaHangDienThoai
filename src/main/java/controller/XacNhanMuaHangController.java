package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.GioHangBean;
import bean.KhachHangBean;
import bo.ChiTietHDBo;
import bo.GioHangBo;
import bo.HoaDonBo;
import bo.SanPhamBo;

/**
 * Servlet implementation class XacNhanMuaHangController
 */
@WebServlet("/XacNhanMuaHangController")
public class XacNhanMuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanMuaHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SanPhamBo spbo = new SanPhamBo();
			HttpSession session = request.getSession();
			//Kiểm tra đăng nhập
			if(session.getAttribute("dn")==null) {
				response.sendRedirect("DangNhapController");
			}else {
				HoaDonBo hdbo = new HoaDonBo();
				KhachHangBean kh = (KhachHangBean)session.getAttribute("dn");
				hdbo.Them(kh.getMaKH());
				long maxhd = hdbo.maxHD();
				//Thêm vào chi tiết
				GioHangBo gh = (GioHangBo)session.getAttribute("gh");
				ChiTietHDBo ctbo = new ChiTietHDBo();
				for(GioHangBean h : gh.ds) {
					ctbo.Them(h.getMaSP(), h.getSoLuongMua(), maxhd);
					spbo.CapNhatSoLuong(h.getMaSP(), h.getSoLuongMua());
				}
				session.removeAttribute("gh");
				response.sendRedirect("TrangChuController");
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
