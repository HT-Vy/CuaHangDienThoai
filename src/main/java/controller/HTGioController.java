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

import bean.GioHangBean;
import bo.GioHangBo;
import bo.LoaiBo;

/**
 * Servlet implementation class HTGioController
 */
@WebServlet("/HTGioController")
public class HTGioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTGioController() {
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
			LoaiBo lbo = new LoaiBo();
			request.setAttribute("dsLoai", lbo.getLoai());
			
			String xoa =request.getParameter("xoa");
			if(xoa!=null) {
				session.removeAttribute("gh");
				response.sendRedirect("TrangChuController");
			}
			else {
				ArrayList<GioHangBean> dsGioHang = null;
				if(session.getAttribute("gh")!=null) {
					GioHangBo gh = (GioHangBo) session.getAttribute("gh");
					dsGioHang = gh.ds;
				}

				request.setAttribute("dsGioHang", dsGioHang);
				RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
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
