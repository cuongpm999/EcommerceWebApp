<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- sử dụng taglibs của spring để bind-data từ end-point trả về. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- tích hợp jstl vào jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- HEADER -->
<div id="header">
	<div class="header-top">
		<div class="container">
			<div class="row">
				<div class="col-md-6 header-top-left">
					<i class="fas fa-users"></i> Nhóm 1 - Analysis & Design - tdque
				</div>
				<div class="col-md-6 header-top-right">
					<c:choose>
						<c:when test="${not empty customerMemberLogin }">
							<span style="color: #020528E6"><i class="fas fa-user"></i> ${customerMemberLogin.account.username }</span>
							<div class="header-separator"></div>
							<a href="/order"><i class="fas fa-clipboard"> </i> Đơn hàng của tôi</a>
							<div class="header-separator"></div>
							<a href="/logout">Đăng xuất</a>
						</c:when>
						<c:when test="${empty customerMemberLogin}">
							<a href="/login"><i class="fas fa-sign-in-alt"> </i>&nbsp;&nbsp;Đăng
								nhập </a>
							<div class="header-separator"></div>
							<a href="/register">Đăng kí</i></a>
						</c:when>
					</c:choose>

				</div>
			</div>
		</div>
	</div>

	<div class="header-bottom">
		<div class="container">
			<div class="row d-flex align-items-center">
				<div class="col-md-3">
					<a href="/"><img src="/img/logo1.png" style="width: 55px;"
						alt="logo"></a>
				</div>
				<div class="col-md-6">
					<div class="nav-search">
						<form action="search-name" method="get"
							style="width: 100%; display: flex; align-items: center;">
							<input class="" type="text" placeholder="Search..." name="key">
							<button class="btn" type="submit">
								<i class="fas fa-search"
									style="color: rgba(55, 0, 255, 0.884); font-size: 20px;"></i>
							</button>
						</form>
					</div>
				</div>
				<div class="col-md-3 text-center">
					<div class="nav-cart">
						<a class="nav-link" href="/cart"> <img class="cart"
							src="/img/cart.png" alt="cart" style="width: 45px;"> <span
							class="count-item">${not empty soLuongMua ? soLuongMua : 0 }</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ------ -->