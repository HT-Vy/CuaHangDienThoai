
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
<title>Admin Đăng Ký</title>
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
<div style="background-color: #cbd7fb; height: 850px">
	<div style="width: 100%; z-index: 1000;">
		<nav class="row navbar navbar-expand-sm bg-warning navbar-light">
			<!-- Brand/logo -->
			<a class="col-md-4 navbar-brand" href="AdminXacNhanController"> <img
				src="./image_sp/logo.png" style="width: 214px; margin-left: 50%"
				alt="">
			</a>
			<form class="row col-md-4 form-inline"
				action="AdminChinhSuaController" method="post">
				<input class="col-md-10 form-control mr-sm-2" type="text"
					name="txttk" placeholder="Bạn cần tìm gì?...">
				<button class="col-md-1 btn" name='tk' type="submit">
					<img src="./image_sp/search.png" width="30px" alt="">
				</button>
			</form>
			<!-- Links -->
			<ul class="col-md-4 navbar-nav">
				<li class="nav-item"><c:if test="${dnad!=null}">
						<li><span class="nav-link"><b>Xin chào: ${dnad.getUserAdmin()}!</b></span></li>
						<li><a href="DangXuat.jsp" class="nav-link"><b>Đăng
									xuất</b></a></li>

					</c:if></li>
			</ul>
		</nav>

		<nav class="row navbar navbar-expand-sm bg-warning navbar-light">
			<div class="col-md-2"></div>
			<ul class="row col-md-8 navbar-nav">
				<li class="col-md nav-item"><a class="nav-link"
					href="AdminXacNhanController" style="padding-left: 0px"><img
						class="img-nav" src="image_sp/phone.png" alt=""><b> Xác nhận</b></a></li>
				<li class="col-md nav-item">
				<c:choose>
					<c:when test="${dnad.getQuyen()==true}"><a class="nav-link" href="AdminDangKyController">
						<img class="img-nav" src="./image_sp/laptop.png" alt=""><b> Thêm Admin</b></a></c:when>
					<c:otherwise>
						<img class="img-nav" src="./image_sp/laptop.png" alt=""><b> Thêm Admin</b>
					</c:otherwise>
				</c:choose>
				</li>
				<li class="col-md nav-item">
					<a class="nav-link" href="#"><img class="img-nav"
						src="./image_sp/tablet.png" alt=""><b> Thêm Sản Phẩm</b></a></li>
				<li class="col-md nav-item"><a class="nav-link"
					href="AdminChinhSuaController"><img class="img-nav"
						src="./image_sp/headphone.png" alt=""><b> Chỉnh Sửa Sản Phẩm</b></a></li>
			</ul>
			<div class="col-md-2"></div>
		</nav>
	</div>

<div class="container" id="container" style="margin-top: 40px; height: 600px">
        <div style="margin-top: 30px"> 
            <form method="get" action="AdminThemSanPhamController" enctype= "multipart/form-data">
                <h2>Thêm sản phẩm</h2>
                <input class="sign-up" name="txtmasp" type="text" placeholder="Mã sản phẩm" required> 
				<input class="sign-up" name="txttensp" type="text" placeholder="Tên sản phẩm" required> 
				<input class="sign-up" name="txtgia" type="text" placeholder="Giá" required> 
				<input class="sign-up" name="txtsoluong" type="text" placeholder="Số lượng" required> 
                <input class="sign-up" name="txtgiagoc" type="text" placeholder="Giá Gốc" required> 
                File ảnh: <input type="file" name="txtfile">
                <c:if test="${tb1 !=null }">
						<div style="color: green;"><c:out value="${tb1}"></c:out></div>
					</c:if>
                <c:if test="${tb2 !=null }">
						<div style="color: red;"><c:out value="${tb2}"></c:out></div>
					</c:if>
                <button type="submit">Thêm sản phẩm</button>
            </form>
        </div>
        
    </div>
</body>
</html>