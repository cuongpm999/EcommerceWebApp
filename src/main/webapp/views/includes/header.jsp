<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- sử dụng taglibs của spring để bind-data từ end-point trả về. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- tích hợp jstl vào jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- HEADER -->
<div id="header">
	<nav class="navbar navbar-expand-sm container">
		<div class="header-top">
			<ul>
				<li><a href="#">Thông tin order</a></li>
				<li><a href="#">Đăng kí</a></li>
				<li><a href="#">Đăng nhập</a></li>
			</ul>
		</div>
		<div class="header-bottom">
			<a class="navbar-brand" href="/BookShop/"><img class="logo"
				src="/img/logo1.png" alt="logo"></a>
			<div class="nav-search">
				<form class="form-inline" action="search-name"
					style="width: 100%; position: relative;" method="get">
					<input class="form-control mr-sm-2" type="text"
						placeholder="Search" name="key">
					<button class="btn" type="submit">
						<i class="fas fa-search"></i>
					</button>
				</form>
			</div>

			<div class="nav-cart">
				<a class="nav-link" style="position: relative;" href="cart"> <img
					class="cart" src="/img/cart.png" alt="cart"> <span
					class="count-item">0</span>
				</a>
			</div>
		</div>
	</nav>
</div>
<!-- ------ -->