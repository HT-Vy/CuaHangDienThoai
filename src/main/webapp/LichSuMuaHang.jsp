<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="bean.SanPhamBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.SanPhamBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Lịch sử mua hàng</title>
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
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div style="position: fixed; width: 100%; z-index: 1000;">
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
			<ul class="col-md-4 navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="GioHangController"> <b> Giỏ hàng (<b style=""><c:choose>
									<c:when test="${dsGioHang==null}">0</c:when>
									<c:otherwise>
										<c:out value="${dsGioHang.size()}"></c:out>
									</c:otherwise>
								</c:choose></b>)
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
	<div id="cart-container">
		<h4>
			<b style="margin-left: 380px">Lịch Sử Mua Hàng Của Bạn</b>
		</h4>
		<br>
		<div class="grid-container-1">
			<table class="table table-hover">
				<thead>
					<tr>
						<th></th>
						<th>Thông tin sản phẩm</th>
						<th>Ngày mua</th>
						<th>Trạng thái</th>
					</tr>
				</thead>
				<c:forEach items="${dsLichSu}" var="sp">
					<tr>
						<td><img class="img-product" alt="" src="${sp.getAnh()}"></td>
						<td><br> <br>
							<div class="name-product">
								<c:out value="${sp.getTenSP()}"></c:out>
							</div>
							<div class="cost-product">
								<c:out value="${sp.getGiaGoc()}"></c:out>
								đ
							</div>
							<div class="price-product" style="font-weight: 500;font-size: 18px">
								<c:out value="${sp.getGia()}"></c:out>
								đ 
							</div>
							<div>X <c:out value="${sp.getSoLuongMua()}"></c:out></div>
							<div class="price-product" style="font-size: 18px"> Tổng:
								<c:out value="${sp.getThanhTien()}"></c:out>
								đ
							</div>
							
							</td>
							<td><br><br><br>
								<c:out value="${sp.getNgayMua()}"></c:out>
							</td>
							<td><br><br><br>
							<c:choose>
								<c:when test="${sp.getDaMua()==true}">
									<c:out value="Hoàn thành"></c:out>
								</c:when>
								<c:otherwise>
									<a href="LichSuMuaHangController?mdh=${sp.getMaChiTietHD()}">Hủy đơn</a>
								</c:otherwise>
							</c:choose>
							</td>
					</tr>
					
				</c:forEach>
				</table>
				<div align="center">

				<c:set var="sotrang"
					value="${((SoSach%5)!=0)?(SoSach/5 + 1):(SoSach/5)}" />
				<c:forEach var="i" begin="1" end="${sotrang}" step="1">
					<button
						style="width: 25px; height: 25px; margin: 10px; border: solid 1px #ccc">
						<a href="LichSuMuaHangController?sotrang=${i}">${i}</a>
					</button>
				</c:forEach>

			</div>
		</div>
	</div>
	<div class="footer" style="background-color: #ffeeba">
		<div class="socials-list" style="text-align: center; padding-top: 20px; padding-bottom: 20px">
			<h6 style="margin-bottom: 10px;">Công ty TNHH aespa</h6> 
			<div style="margin-bottom: 10px;">Địa chỉ: 77 Nguyễn Huệ, Thành phố Huế, Tỉnh Thừa Thiên Huế, Việt Nam</div>
			<div>Điện thoại: (+84) 0234.3823290 – Fax: (+84) 0234.3824901</div>
		</div>
	</div>
</body>
</html>