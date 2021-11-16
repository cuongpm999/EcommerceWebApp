<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="sidebar">
			<div class="sidebar-inner">
				<div class="sidebar-logo">
					<a class="sidebar-link" href="/"> <img class="icon"
						src="/img/logo.png">
						<h5 class="logo-text">Admin Manage</h5>
					</a>
				</div>

				<nav class="navbar scrollbar" id="style-1">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/admin/manage"><i
								class="fas fa-home"></i>Dashboard</a></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbardrop"
							data-toggle="dropdown"><i class="fas fa-list"></i>Nhập hàng</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/admin/manage/book">Book</a> <a
									class="dropdown-item" href="/admin/manage/laptop">Laptop</a> <a
									class="dropdown-item" href="/admin/manage/mobilephone">Mobile
									phone</a> <a class="dropdown-item" href="/admin/manage/tivi">Tivi</a>
								<a class="dropdown-item" href="/admin/manage/jeans">Jeans</a> <a
									class="dropdown-item" href="/admin/manage/dresses">Dresses</a>
								<a class="dropdown-item" href="/admin/manage/swimwear">Swimwear</a>
								<a class="dropdown-item" href="/admin/manage/sneaker">Sneaker</a>
								<a class="dropdown-item" href="/admin/manage/highheels">Highheels</a>
								<a class="dropdown-item" href="/admin/manage/boots">Boots</a>
							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbardrop"
							data-toggle="dropdown"><i class="fas fa-list"></i>Đưa hàng
								lên website</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/admin/manage/book-item">Book
									Item</a> <a class="dropdown-item"
									href="/admin/manage/electronics-item">Electronics Item</a> <a
									class="dropdown-item" href="/admin/manage/clothes-item">Clothes
									Item</a> <a class="dropdown-item" href="/admin/manage/shoes-item">Shoes
									Item</a>
							</div></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fas fa-envelope"></i>Email</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fas fa-map"></i>Maps</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="far fa-comment-dots"></i>Chat</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="far fa-calendar-alt"></i>Calendar</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="fas fa-chart-bar"></i>Charts</a></li>
						<li class="nav-item"><a class="nav-link" href="#"><i
								class="far fa-copy"></i>Pages</a></li>

					</ul>

				</nav>
			</div>
		</div>
		<div class="page-container">
			<div class="header-container">
				<nav class="navbar">
					<ul class="navbar-nav">
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown"> 
								<%-- <c:choose>
									<c:when test="${empty userDis.userAttachment.name}">
										<img class="icon" alt="user" src="/img/anh-dai-dien-1.jpg">
									</c:when>
									<c:when test="${not empty userDis.userAttachment.name}">
										<img class="icon" alt="user"
											src="/files_users/${userDis.userAttachment.name }">
									</c:when>
								</c:choose> --%> 
								<span class="text-icon"><%-- ${userDis.username } --%></span>
							</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/user-details">
									<i class="far fa-user"></i>Profile
								</a> 
								<a class="dropdown-item" href="/logout"><i class="fas fa-power-off"></i>Logout</a>
							</div>
						</li>
					</ul>
				</nav>
			</div>
