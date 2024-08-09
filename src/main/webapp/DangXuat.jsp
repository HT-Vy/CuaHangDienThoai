<%
	if(session.getAttribute("dn")!=null){
		session.removeAttribute("dn");
		response.sendRedirect("TrangChuController");
	}
	if(session.getAttribute("dnad")!=null){
		session.removeAttribute("dnad");
		response.sendRedirect("AdminDangNhapController");
	}
	
%>
