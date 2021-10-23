<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- sử dụng taglibs của spring để bind-data từ end-point trả về. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- tích hợp jstl vào jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="description"
	content="ban laptop uy tin, chat luong, dich vu tot">
<meta name="keywords"
	content="laptop, asus, dell, hp, lenovo, acer, apple, msi, lg">
<meta name="author" content="CuongPham">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS & JAVA_SCRIPT -->
<!-- CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/fontawesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/shop_home.css">
<link rel="stylesheet" type="text/css" href="/css/manage.css">

<!-- JavaScript -->
<script src="/js/chart.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="/js/waypoint.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/js/shop_home.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<script src="/js/fontawesome.min.js"></script>
<!-- ----------------- -->

<title>Add Boots</title>
</head>

<body>

	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v8.0"
		nonce="ChmFo6ST"></script>

	<!-- MAIN -->
	<div id="main">
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
							data-toggle="dropdown"><i class="fas fa-list"></i>Tables</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/admin/list-user">Account</a> <a
									class="dropdown-item" href="/admin/list-banner">Banner</a> <a
									class="dropdown-item" href="/admin/list-contact">Contact</a> <a
									class="dropdown-item" href="/admin/list-laptop">Laptop</a> <a
									class="dropdown-item" href="/admin/list-bill">Bill</a>
							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbardrop"
							data-toggle="dropdown"><i class="fas fa-pencil-alt"></i></i>Forms</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/admin/add-laptop">Laptop</a> <a
									class="dropdown-item" href="/admin/add-banner">Banner</a>
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
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbardrop"
							data-toggle="dropdown"> <%-- <c:choose>
									<c:when test="${empty userDis.userAttachment.name}">
										<img class="icon" alt="user" src="/img/anh-dai-dien-1.jpg">
									</c:when>
									<c:when test="${not empty userDis.userAttachment.name}">
										<img class="icon" alt="user"
											src="/files_users/${userDis.userAttachment.name }">
									</c:when>
								</c:choose> --%> <span class="text-icon">
									<%-- ${userDis.username } --%>
							</span>
						</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="/user-details"><i
									class="far fa-user"></i>Profile</a> <a class="dropdown-item"
									href="/logout"><i class="fas fa-power-off"></i>Logout</a>
							</div></li>
					</ul>
				</nav>
			</div>

			<div class="main-content">
				<div class="row">
					<div class="col-md-12">
						<div class="form-add">
							<%-- <c:choose>
								<c:when test="${status=='success'}">
									<div class="alert alert-success">
										<strong>Success!</strong> Bạn đã thêm thành công!
									</div>
								</c:when>
								<c:when test="${status=='faile'}">
									<div class="alert alert-danger">
										<strong>Faile!</strong> Bạn đã thêm thất bại!

									</div>
								</c:when>
							</c:choose> --%>

							<div class="card-body">
								<div class="panel-body">
									<form:form modelAttribute="boots" action="/admin/shoes/add-boots"
										enctype="multipart/form-data">
										<%-- <div class="form-group">
											<label class="required" for="txtInput">Hãng sản xuất:</label>
											<form:select class="form-control"
												path="laptopManufacturer.id">
												<form:options items="${laptopManufacturer}" itemValue="id"
													itemLabel="name" />
											</form:select>
										</div> --%>
										<div class="form-group">
											<label class="required">Name:</label>
											<form:input path="name" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Material:</label>
											<form:input path="material" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Style:</label>
											<form:input path="style" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Color:</label>
											<form:input path="color" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Size:</label>
											<form:input path="size" class="form-control" />
										</div>
										<div class="form-group">
											<label class="required">Is shoelace:</label>
											<form:radiobutton path="isShoelace" class="" value="1" label="Yes"/>
											<form:radiobutton path="isShoelace" class="" value="0" label="No"/>
										</div>
										<button type="submit" class="btn btn-success">
											<i class="fas fa-download"></i> Save
										</button>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer">
				©
				<c:set var="now" value="<%=new java.util.Date()%>" />
				<fmt:formatDate pattern="yyyy" value="${now}" />
				Copyright: <a href="https://www.facebook.com/cuongphamptit999/">
					CuongPham.com</a>
			</div>
		</div>
	</div>
	<!-- --- -->

</body>


</html>