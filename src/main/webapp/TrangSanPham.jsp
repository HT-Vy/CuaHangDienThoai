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
<title>aespa - sản phẩm</title>
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
							class="img-nav" src="${l.getAnhLoai() }" alt=""><b>
								${l.getTenLoai() }</b></a></li>
				</c:forEach>
			</ul>
			<div class="col-md-3"></div>
		</nav>
	</div>



	<div id="container-content">

		<div style="min-height: 670px">
			<div id="center">
				<c:if test="${dsNSX !=null }">

					<c:forEach items="${dsNSX}" var="nsx">
						<c:if test="${nsx.getMaNSX()!=null }">
							<button class="btn"
								style="border: solid 1px #ccc; width: 90px; height: 40px; margin: 10px; background-color: #fff">
								<a
									href="TrangSanPhamController?mansx=${nsx.getMaNSX()}&sotrang=1">${nsx.getTenNSX()}</a>
							</button>
						</c:if>
					</c:forEach>
				</c:if>

			</div>
			<h4>
				<a href="#" class="title-layout"><c:out value="${tieude}"></c:out></a>
			</h4>
			<div class="grid-container">
				<c:forEach items="${dsSP}" var="sp">
					<div class="grid-div">
						<img class="img-product" alt="" src="${sp.getAnh()}"> <br>
						<div class="content-product">
							<div class="name-product">
								<c:out value="${sp.getTenSP()}"></c:out>
							</div>
							<div class="cost-product">
								<c:out value="${sp.getGiaGoc()}"></c:out>
								đ
							</div>
							<div class="price-product">
								<c:out value="${sp.getGia()}"></c:out>
							</div>
							<c:choose>
								<c:when test="${sp.getSoLuong()>0}">
									<button class="buy">
										<a
											href="GioHangController?ms=${sp.getMaSP()}&ts=${sp.getTenSP()}&gia=${sp.getGia()}&anh=${sp.getAnh()}&giagoc=${sp.getGiaGoc()}&SoLuong=${sp.getSoLuong()}">Mua
											Ngay|<img src="./image_sp/cart.png" width="25px" alt="">
										</a>
									</button>
								</c:when>
								<c:otherwise>
									<button class="buy">Tạm hết</button>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</c:forEach>
			</div>

			<div align="center">
				<c:set var="ma"
					value="${(maloai!=null)?maloai:(keytim!=null)?keytim:(nsx!=null)?nsx:null}" />
				<c:set var="sotrang"
					value="${((sosach%15)!=0)?(sosach/15 + 1):(sosach/15)}" />
				<c:forEach var="i" begin="1" end="${sotrang}" step="1">
					<button
						style="width: 25px; height: 25px; margin: 10px; border: solid 1px #ccc">
						<a href="TrangSanPhamController?${ma}&sotrang=${i}">${i}</a>
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
