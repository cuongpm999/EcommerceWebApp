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
<link rel="stylesheet" type="text/css" href="/css/home.css">
<link rel="stylesheet" type="text/css" href="/css/category.css">

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

<title>Laptop Project</title>
</head>

<body>

	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v8.0"
		nonce="ChmFo6ST"></script>

	<!-- HEADER -->
	<div id='header'>
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

	<!-- MAIN -->
	<div id="main" class="container all-item">
		<h4 class="tieude-tp">CLOTHES</h4>
		<div class="loc-sp">
			<span class="title-x">LỌC SẢN PHẨM</span>
			<div class="danh-muc">
				<span class="title">DANH MỤC</span>
				<ul class="list-unstyled">
					<li><a
						href="/shop-all-item/${laptopManufacturer_.seo }/?page=1"><i
							class="fas fa-angle-double-right"></i> Jeans</a></li>
					<li><a
						href="/shop-all-item/${laptopManufacturer_.seo }/?page=1"><i
							class="fas fa-angle-double-right"></i> Swimwear</a></li>
					<li><a
						href="/shop-all-item/${laptopManufacturer_.seo }/?page=1"><i
							class="fas fa-angle-double-right"></i> Dresses</a></li>
				</ul>
			</div>
			<div class="khoang-gia">
				<span class="title">KHOẢNG GIÁ</span>
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${empty price }">
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', 'duoi100')"><i
									class="far fa-square"></i> Dưới 100.000₫</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', 'tu100den300')"><i
									class="far fa-square"></i> 100.000₫ - 300.000₫</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', 'tu300den500')"><i
									class="far fa-square"></i> 300.000₫ - 500.000₫</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', 'tu500den1trieu')"><i
									class="far fa-square"></i> 500.000₫ - 1.000.000₫ </a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', 'tren1trieu')"><i
									class="far fa-square"></i> Trên 1.000.000₫</a></li>
						</c:when>
						<c:when test="${price=='duoi100' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('price')"><i
									class="far fa-check-square"></i> Dưới 100.000₫</a></li>
						</c:when>

						<c:when test="${price=='tu100den300' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('price')"><i
									class="far fa-check-square"></i> 100.000₫ - 300.000₫</a></li>
						</c:when>

						<c:when test="${price=='tu300den500' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('price')"><i
									class="far fa-check-square"></i> 300.000₫ - 500.000₫</a></li>
						</c:when>

						<c:when test="${price=='tu500den1trieu' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('price')"><i
									class="far fa-check-square"></i> 500.000₫ - 1.000.000₫</a></li>
						</c:when>

						<c:when test="${price=='tren1trieu' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('price')"><i
									class="far fa-check-square"></i> Trên 1.000.000₫</a></li>
						</c:when>

					</c:choose>
				</ul>
			</div>
			<div class="color">
				<span class="title">MÀU SẮC</span>
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${empty color }">
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('color', 'den')"><i
									class="fas fa-circle" style="color: rgb(0, 0, 0);"></i> Đen</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('color', 'trang')"><i
									class="fas fa-circle" style="color: white;"></i> Trắng</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('color', 'xanhnavy')"><i
									class="fas fa-circle" style="color: #063970;"></i> Xanh navy </a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('color', 'do')"><i
									class="fas fa-circle" style="color: red;"></i> Đỏ </a></li>
						</c:when>
						<c:when test="${color == 'den' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('color')"><i
									class="fas fa-circle" style="color: rgb(0, 0, 0);"></i> Đen</a></li>
						</c:when>
						<c:when test="${color == 'trang' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('color')"><i
									class="fas fa-circle" style="color: white;"></i> Trắng</a></li>
						</c:when>
						<c:when test="${color == 'xanhnavy' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('color')"><i
									class="fas fa-circle" style="color: #063970;"></i> Xanh navy </a></li>
						</c:when>
						<c:when test="${color == 'do' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('color')"><i
									class="fas fa-circle" style="color: red;"></i> Đỏ </a></li>
						</c:when>
					</c:choose>
				</ul>
			</div>

			<div class="style">
				<span class="title">STYLE</span>
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${empty style }">
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('style', 'amcung')"><i
									class="far fa-square"></i> Ấm cúng</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('style', 'matme')"><i
									class="far fa-square"></i> Mát mể</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('style', 'lichsu')"><i
									class="far fa-square"></i> Lịch sự</a></li>
						</c:when>
						<c:when test="${style == 'amcung' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('style')"><i
									class="far fa-square"></i> Ấm cúng</a></li>
						</c:when>
						<c:when test="${style == 'matme' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('style')"><i
									class="far fa-square"></i> Mát mể</a></li>
						</c:when>
						<c:when test="${style == 'lichsu' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('style')"><i
									class="far fa-square"></i> Lịch sự</a></li>
						</c:when>
					</c:choose>
				</ul>
			</div>

			<div class="chat-lieu">
				<span class="title">CHẤT LIỆU</span>
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${empty material }">
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('material', 'vaicotton')"><i
									class="far fa-square"></i> Vải cotton</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('material', 'vailen')"><i
									class="far fa-square"></i> Vải len</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('material', 'vaini')"><i
									class="far fa-square"></i> Vải nỉ</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('material', 'vailua')"><i
									class="far fa-square"></i> Vải lụa</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('material', 'vaikhaki')"><i
									class="far fa-square"></i> Vải khaki</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('material', 'vaijeans')"><i
									class="far fa-square"></i> Vải jeans</a></li>
						</c:when>
						<c:when test="${material == 'vaicotton' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('material')"><i
									class="far fa-square"></i> Vải cotton</a></li>
						</c:when>
						<c:when test="${material == 'vailen' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('material')"><i
									class="far fa-square"></i> Vải len</a></li>
						</c:when>
						<c:when test="${material == 'vaijeans' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('material')"><i
									class="far fa-square"></i> Vải nỉ</a></li>
						</c:when>
						<c:when test="${material == 'vailua' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('material')"><i
									class="far fa-square"></i> Vải lụa</a></li>
						</c:when>
						<c:when test="${material == 'vaikhaki' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('material')"><i
									class="far fa-square"></i> Vải khaki</a></li>
						</c:when>
						<c:when test="${material == 'vaijeans' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('material')"><i
									class="far fa-square"></i> Vải jeans</a></li>
						</c:when>
					</c:choose>
				</ul>
			</div>

		</div>

		<div class="product-sp">
			<div class="product-list">
				<div class="list-sort" style="margin-bottom: 5px">
					<select id="sort-select"
						onchange="Shop.addUrlParameter('sort', this.value)">
						<option value="">Sắp xếp sản phẩm</option>
						<option value="low-to-high">Giá tăng dần</option>
						<option value="high-to-low">Giá giảm dần</option>
					</select>

				</div>
				<!-- item -->
				<div class="list-clothes">
					<div class="row">
						<c:forEach var="clothesItem" items="${clothesItems }">
							<div class="col-md-3">
								<a href="/clothes/${clothesItem.slug }"><img
									src="/files_item/${clothesItem.imgClothesItems.get(0).name }"
									alt="product"></a>
								<div class="infor" style="text-align: center;">
									<a href="/clothes/${clothesItem.slug }">
										<h6 class="card-title">${clothesItem.clothes.name }</h6>
									</a>
									<c:choose>
										<c:when test="${clothesItem.discount > 0}">
											<div class="gia-goc">
												<p class="gia-chinh">${clothesItem.price }₫</p>
												<p class="khuyen-mai">(Tiết kiệm:
													${clothesItem.discount}%)</p>
											</div>
										</c:when>
									</c:choose>
									<h6 class="gia-ban">${clothesItem.price*(100-clothesItem.discount)/100 }₫</h6>
									<a href="#"><i class="fas fa-shopping-cart"></i>&nbsp;Mua
										ngay</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

				<!-- <div class="my-5"></div> -->
				<div class="list-sort" style="margin-top: 3rem;">

					<div class="paging mx-auto">
						<a href="javascript:Shop.goPrev()">Previous</a> <a
							href="javascript:void(0);"
							onclick="Shop.addUrlParameter('page', 1)">1</a> <a
							href="javascript:void(0);"
							onclick="Shop.addUrlParameter('page', 2)">2</a> <a
							href="javascript:void(0);"
							onclick="Shop.addUrlParameter('page', 3)">3</a> <a class="pa4"
							href="javascript:void(0);"
							onclick="Shop.addUrlParameter('page', 4)">4</a> <a class="pa5"
							href="javascript:void(0);"
							onclick="Shop.addUrlParameter('page', 5)">5</a> <a
							href="javascript:Shop.goNext()">Next</a>
					</div>
				</div>


			</div>
		</div>

	</div>
	<div class="clear-with-height"></div>
	<!-- --- -->

	<!--  FOOTER -->
	<div id="footer">
		<div id="footer">
			<div class="container">
				<div class="row">
					<div class="col-md-5">
						<h5>CHÍNH HÃNG, UY TÍN, CHẤT LƯỢNG</h5>
						<ul>
							<li>
								<h4>ONLINE STORE</h4>
							</li>
							<li><a href="javascript:void(0);"><i
									class="fas fa-map-marker-alt"></i>&ensp;Address: 19A Xa La, Hà
									Nội</a></li>
							<li><a href="javascript:void(0);"><i
									class="fas fa-envelope"></i>&ensp;Email:
									phamcuongth2000@gmail.com</a></li>
							<li><a href="javascript:void(0);"><i
									class="fas fa-phone"></i>&ensp;Mobile: 0961656067</a></li>
						</ul>
					</div>
					<div class="col-md-3">
						<h5>SẢN PHẨM</h5>
					</div>

					<div class="col-md-4">
						<h5>KẾT NỐI VỚI CHÚNG TÔI</h5>

					</div>

					<hr>
					<div class="footer-copyright text-center py-3" style="width: 100%;">
						©
						<script>
							var now = new Date();
							document.write(now.getFullYear());
						</script>
						Copyright: <a href="https://www.facebook.com/cuongphamptit999/">
							CuongPham.com</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ------- -->

</body>

</html>