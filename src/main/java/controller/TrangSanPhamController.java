package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoaiBean;
import bean.NSXBean;
import bean.SanPhamBean;
import bo.LoaiBo;
import bo.NSXBo;
import bo.SanPhamBo;

/**
 * Servlet implementation class TrangSanPhamController
 */
@WebServlet("/TrangSanPhamController")
public class TrangSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrangSanPhamController() {
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
			SanPhamBo spbo = new SanPhamBo();
			String td = request.getParameter("td");
			String ml = request.getParameter("ml");
			String key = request.getParameter("txttk");
			String mansx = request.getParameter("mansx");
			LoaiBo lbo = new LoaiBo();
			request.setAttribute("dsLoai", lbo.getLoai());
			NSXBo sxbo = new NSXBo();
			String tieude = "";
			//Chạy trang đầu tiên
			String sotrang = request.getParameter("sotrang");
			ArrayList<SanPhamBean> dsSP = null;
			int n = 0;
			if(td!=null) {
				dsSP = spbo.PhanTrang(1);
				tieude = "Sản Phẩm Nổi Bật";
				n = spbo.getSanPham().size();
			}
			if(sotrang !=null) {
				dsSP = spbo.PhanTrang(Integer.parseInt(sotrang));
				n = spbo.getSanPham().size();
				tieude = "Sản Phẩm Nổi Bật";
			}
			
			if(mansx!=null && sotrang!=null) {
				dsSP = spbo.PhanTrangTheoNSX(Integer.parseInt(sotrang), mansx);
				n = spbo.getSanPhamTheoNSX(mansx).size();
				request.setAttribute("nsx", "mansx="+mansx);
				NSXBean nsx = sxbo.timNSX(mansx);
				tieude = nsx.getTenNSX();
			}
			
			if(ml!=null && sotrang!=null) {
				request.setAttribute("dsNSX", spbo.getNSXTheoLoai(ml));
				LoaiBean loai = lbo.timLoai(ml);
				dsSP = spbo.PhanTrangTheoLoai(Integer.parseInt(sotrang), ml);
				n = spbo.getSanPhamTheoLoai(ml).size();
				request.setAttribute("maloai", "ml="+ml);
				tieude = loai.getTenLoai();
			}
			
			
			if(key!=null) {
				dsSP = spbo.PhanTrangTheoKey(1,key);
				request.setAttribute("keytim", "key="+key);
				tieude = "Kết quả tìm kiếm " + key;
				n = spbo.getSanPhamTimKiem(key).size();
				if(n==0)
					tieude = tieude + ": Không tìm thấy!";
			}
			if(key!=null && sotrang!=null) {
				dsSP = spbo.PhanTrangTheoKey(Integer.parseInt(sotrang),key);
				request.setAttribute("keytim", "key="+key);
				n = spbo.getSanPhamTimKiem(key).size();
			}
			
			request.setAttribute("tieude", tieude);
			request.setAttribute("dsSP", dsSP);
			request.setAttribute("sosach", n);
			RequestDispatcher rd = request.getRequestDispatcher("TrangSanPham.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
