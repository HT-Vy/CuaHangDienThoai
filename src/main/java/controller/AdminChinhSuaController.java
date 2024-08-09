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

import bean.SanPhamBean;
import bo.SanPhamBo;

/**
 * Servlet implementation class AdminChinhSuaController
 */
@WebServlet("/AdminChinhSuaController")
public class AdminChinhSuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChinhSuaController() {
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
			HttpSession session =request.getSession();
			if(session.getAttribute("dnad")==null) {
				response.sendRedirect("AdminDangNhapController");
			}else {
				
				//Admin xóa sản phẩm: mỗi lần 1 sp
				SanPhamBo spbo = new SanPhamBo();
				String key = request.getParameter("txttk");
				//gửi key tìm kiếm qua jsp để khi cập nhật hoặc xóa thì gọi lại getSanPhamTimKiem(key)
				request.setAttribute("key", key);
				//ktr đang cập nhật bằng tìm kiếm hay ds số lượng 0
				String nhom =request.getParameter("nhom");
				ArrayList<SanPhamBean> dsSP = null;
				String td = "";
				if(key!=null) {
					//Chạy lần đầu
					dsSP = spbo.getSanPhamTimKiem(key);
					request.setAttribute("loai", "tim");
					td = "Danh sách sản phẩm";
					if(dsSP.size()==0) 
						td = "Không tìm thấy sản phẩm!";
				}

				String dshethang = request.getParameter("dshethang");
				if(dshethang!=null) {
					//Chạy lần đầu
					request.setAttribute("loai", "ds0");
					dsSP = spbo.getSanPhamSLKhong();
				}
				
				
				String xoasp = request.getParameter("msp");
				if(xoasp!=null) {
					spbo.XoaSanPham(xoasp);
					//Sau khi xóa thì hiển thị lại ds trước đó
					if(nhom!=null) {
						if(nhom.equals("tim"))
							dsSP = spbo.getSanPhamTimKiem(key);
						else
							dsSP = spbo.getSanPhamSLKhong();
					}
					
				}
				String masanpham = request.getParameter("abut1");
				String soluong = request.getParameter(masanpham+"_sl");
				String gia = request.getParameter(masanpham+"_gia");
				if(masanpham!=null && soluong!=null&& gia!=null) {
					String g = gia.replace(",", "");
					spbo.CapNhatSanPham(masanpham, Long.parseLong(soluong),Long.parseLong(g) );
					if(nhom!=null) {
						if(nhom.equals("tim"))
							dsSP = spbo.getSanPhamTimKiem(key);
						else
							dsSP = spbo.getSanPhamSLKhong();
					}
				}
				
				
				request.setAttribute("dshethang", dshethang);
				
				request.setAttribute("tieude", td);
				request.setAttribute("dscs", dsSP);
				RequestDispatcher rd = request.getRequestDispatcher("AdminChinhSua.jsp");
				rd.forward(request, response);
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
