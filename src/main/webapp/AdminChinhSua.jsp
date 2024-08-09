
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
<title>Admin chỉnh sửa</title>
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
			<a class="col-md-4 navbar-brand" href="AdminXacNhanController"> <img
				src="./image_sp/logo.png" style="width: 214px; margin-left: 50%"
				alt="">
			</a>
			<form class="row col-md-4 form-inline"
				action="AdminChinhSuaController" method="get">
				<input class="col-md-10 form-control mr-sm-2" type="text"
					name="txttk" placeholder="Bạn cần tìm gì?..." value="${key }">
				<button class="col-md-1 btn" name='tk' type="submit">
					<img src="./image_sp/search.png" width="30px" alt="">
				</button>
			</form>
			<!-- Links -->

			<ul class="col-md-4 navbar-nav">
				<li class="nav-item"><c:choose>
						<c:when test="${dnad!=null}">
							<li><span class="nav-link"><b>Xin chào:
										${dnad.getUserAdmin()}!</b></span></li>
							<li><a href="DangXuat.jsp" class="nav-link"><b>Đăng
										xuất</b></a></li>

						</c:when>
						<c:otherwise>
							<li><a href="AdminDangNhapController" class="nav-link"><b>Đăng
										Nhập</b></a></li>
						</c:otherwise>

					</c:choose></li>

			</ul>
		</nav>

		<nav class="row navbar navbar-expand-sm bg-warning navbar-light">
			<div class="col-md-2"></div>
			<ul class="row col-md-8 navbar-nav">
				<li class="col-md nav-item"><a class="nav-link"
					href="AdminXacNhanController" style="padding-left: 0px"><img
						class="img-nav" src="image_sp/phone.png" alt=""><b> Xác
							nhận</b></a></li>
				<li class="col-md nav-item"><c:choose>
						<c:when test="${dnad.getQuyen()==true}">
							<a class="nav-link" href="AdminDangKyController"> <img
								class="img-nav" src="./image_sp/laptop.png" alt=""><b>
									Thêm Admin</b></a>
						</c:when>
						<c:otherwise>
							<div class="nav-link">
								<img class="img-nav" src="./image_sp/laptop.png" alt=""><b>
									Thêm Admin</b>
							</div>
						</c:otherwise>
					</c:choose></li>
				
				<li class="col-md nav-item"><a class="nav-link"
					href="AdminChinhSuaController"><img class="img-nav"
						src="./image_sp/headphone.png" alt=""><b> Chỉnh Sửa Sản
							Phẩm</b></a></li>
			</ul>
			<div class="col-md-2"></div>
		</nav>
	</div>
	<div id="center">


		<div class="grid-container-1" style="width: 80%; min-width: 800px">
			<form method="post" action="tam123" enctype= "multipart/form-data">

			  file banner: <input type="file" name="txtfile"><br>
			  <input type="submit" value="Thay đổi"> 
			  </form> 
		
			<div>
				<button class="btn-ds">
					<a style="padding: 10px 15px" href="AdminChinhSuaController?dshethang=ok">DS sản phẩm hết hàng</a>
				</button>
			</div>

			<form style="display: inline-block;" action="AdminChinhSuaController?nhom=${loai}&txttk=${key}" method="post">
				<table class="table table-hover"
					style="margin-top: 40px; background-color: #fff">
					<thead>
						<tr class="table-warning">
							<th>Mã sản phẩm</th>
							<th>Tên sách</th>
							<th>Số lượng</th>
							<th>Giá</th>
							<th></th>
							<th>Xóa</th>
						</tr>
					</thead>
					<c:forEach items="${dscs}" var="xn">
						<tr>
							<td>${xn.getMaSP()}</td>
							<td>${xn.getTenSP()}</td>
							<td style="text-align: center;"><input type='number'
								name="${xn.getMaSP()}_sl" min="0" value="${xn.getSoLuong()}"
								style="width: 40px; height: 20px;">
							<td><input type='text' name="${xn.getMaSP()}_gia" min="0"
								value="${xn.getGia()}" style="width: 100px; height: 20px;">đ
							</td>
							<td><button type="submit" name="abut1"
									value="${xn.getMaSP()}" style="border: none; font-size: 16px">Cập
									nhật</button></td>
							</td>

							<td><a style="font-size: 15px"
								href='AdminChinhSuaController?nhom=${loai}&msp=${xn.getMaSP()}&txttk=${key}'>Xóa</a></td>
						</tr>
					</c:forEach>
				</table>
		</div>
		</form>
	</div>
</body>
</html>