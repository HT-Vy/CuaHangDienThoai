
<%@page import="bo.GioHangBo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="bean.SanPhamBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.SanPhamBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Đăng nhập</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="./css/styledn.css">
<link rel="stylesheet" href="./css/style.css">
</head>
<body>

	<div style="width: 100%; z-index: 1000;">
		<nav class="row navbar navbar-expand-sm bg-warning navbar-light">
			<!-- Brand/logo -->
			<a class="col-md-4 navbar-brand" href="TrangChuController"> <img
				src="./image_sp/logo.png" style="width: 214px; margin-left: 50%"
				alt="">
			</a>
			<form class="row col-md-4 form-inline"
				action="TrangSanPhamController" method="post">
				<input class="col-md-10 form-control mr-sm-2" type="text"
					name="txttk" placeholder="Bạn cần tìm gì?...">
				<button class="col-md-1 btn" name='tk' type="submit">
					<img src="./image_sp/search.png" width="30px" alt="">
				</button>
			</form>
			<!-- Links -->
			<%
			GioHangBo sl = (GioHangBo) session.getAttribute("gh");
			%>
			<ul class="col-md-4 navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="GioHangController"> <b> Giỏ hàng(<%=(sl == null) ? 0 : sl.ds.size()%>)
					</b> <img src="./image_sp/cart.png" width="30px" alt=""> |
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="LichSuMuaHangController"><b> Lịch sử mua hàng | </b></a></li>
				<li class="nav-item"><c:choose>
						<c:when test="${dn==null}">
							<a class="nav-link" href="DangNhapController"><b>Đăng
									nhập</b></a>
						</c:when>
						<c:otherwise>
							<li><span class="nav-link"><b>${dn.getHoTen()}</b></span></li>
							<li><a href="DangXuat.jsp" class="nav-link"><b>Đăng
										xuất</b></a></li>
						</c:otherwise>
					</c:choose></li>
			</ul>
		</nav>

		<nav class="row navbar navbar-expand-sm bg-warning navbar-light">
			<div class="col-md-3"></div>
			<ul class="row col-md-6 navbar-nav">
				<c:forEach items="${dsLoai}" var="l">
				<li class="col-md nav-item"><a class="nav-link"
					href="TrangSanPhamController?ml=${l.getMaLoai().trim()}&sotrang=1"><img
						class="img-nav" src="${l.getAnhLoai() }" alt=""><b> ${l.getTenLoai() }</b></a></li>
			</c:forEach>
			</ul>
			<div class="col-md-3"></div>
		</nav>
	</div>

	<div id="main">
		<div class="container" id="container">
			<div class="form-container">
				<form action="DangNhapController" method="post">
					<h1>Đăng nhập</h1>
					<input name="txtun" type="text" placeholder="Username" required>
					<input name="txtpass" type="password" placeholder="Password"
						required>
					<c:if test="${kt !=null }">
						<div style="color: red;">
							<c:out value="${kt}"></c:out>
						</div>
					</c:if>
					<button type="submit">Đăng nhập</button>
				</form>
			</div>
			<div class="toggle-container">
				<div class="toggle-panel">
					<h1>Chào bạn!</h1>
					<p>Đăng ký với thông tin cá nhân của bạn để sử dụng tất cả các
						tính năng của trang web</p>
					<a href="DangKyController"><button class="hidden">Đăng
							ký</button></a>
				</div>
			</div>
		</div>
	</div>