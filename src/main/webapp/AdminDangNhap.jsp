<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Đăng Nhập</title>
<link rel="stylesheet" href="./css/styleAdmin.css">
</head>
<body>
<div class="container" id="container">
        <div class="form-container">
            <form action="AdminDangNhapController" method="post">
                <h1>Đăng nhập</h1>
                <input name="txtun" type="text" placeholder="Username" required>
                <input name="txtpass" type="password" placeholder="Password" required>
                <c:if test="${kt !=null }">
						<div style="color: red;"><c:out value="${kt}"></c:out></div>
				</c:if>
                <button type="submit">Đăng nhập</button>
            </form>
        </div>
        <div class="toggle-container">
                <div class="toggle-panel">
                    <h1>Chào bạn!</h1>
                    <p>Đăng nhập với thông tin cá nhân của bạn để sử dụng tất cả các tính năng của trang web</p>
                </div>
        </div>
    </div>
</body>
</html>