package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.AdminBo;
import bo.ChiTietHDBo;

/**
 * Servlet implementation class AdminXacNhanController
 */
@WebServlet("/AdminXacNhanController")
public class AdminXacNhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminXacNhanController() {
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
				AdminBo adbo = new AdminBo();
				String macthd = request.getParameter("macthd");
				if(macthd !=null) {
					adbo.XacNhan(Long.parseLong(macthd));
				}
				request.setAttribute("ds", adbo.getXacNhan());
				RequestDispatcher rd = request.getRequestDispatcher("AdminXacNhan.jsp");
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
