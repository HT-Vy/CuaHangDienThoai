package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.GioHangBo;
import bo.LoaiBo;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			
			
			//String s =(String) session.getAttribute("dn");
			String ms = request.getParameter("ms");
			String ts = request.getParameter("ts");
			String gia = request.getParameter("gia");
			String anh = request.getParameter("anh");
			String giagoc = request.getParameter("giagoc");
			String SoLuong = request.getParameter("SoLuong");
			
			//Tạo session
			HttpSession session =request.getSession();
			GioHangBo gh=null;
			if(ms!=null && ts!=null && gia!=null && anh!=null && giagoc!=null) {
		 		//kiểm tra đã có session giỏ hàng
		 		if(session.getAttribute("gh")==null){
		 			 gh = new GioHangBo();
		 			session.setAttribute("gh", gh);//Tạo session giỏ hàng
		 		}
				 //Gian session: gh vao bien: gh
				gh=(GioHangBo)session.getAttribute("gh");
		 		//Thêm hàng vào biến: g
		 		gh.Them(ms, ts,(long) 1, gia, anh, giagoc, Long.parseLong(SoLuong));
		 		//Lưu biến vào session
		 		session.setAttribute("gh", gh);
			}
			response.sendRedirect("HTGioController");
//			RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
//			rd.forward(request, response);
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
