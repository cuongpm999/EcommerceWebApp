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
		<h4 class="tieude-tp">SHOES</h4>
		<div class="loc-sp">
			<span class="title-x">LỌC SẢN PHẨM</span>
			<div class="danh-muc">
				<span class="title">DANH MỤC</span>
				<ul class="list-unstyled">
					<li><a
						href="/shop-all-item/${laptopManufacturer_.seo }/?page=1"><i
							class="fas fa-angle-double-right"></i> Sneaker</a></li>
					<li><a
						href="/shop-all-item/${laptopManufacturer_.seo }/?page=1"><i
							class="fas fa-angle-double-right"></i> HighHeels</a></li>
					<li><a
						href="/shop-all-item/${laptopManufacturer_.seo }/?page=1"><i
							class="fas fa-angle-double-right"></i> Boots</a></li>
				</ul>
			</div>
			<div class="khoang-gia">
				<span class="title">KHOẢNG GIÁ</span>
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${empty price }">
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', 'duoi1tram')"><i
									class="far fa-square"></i> Dưới 100.000₫</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', '')"><i
									class="far fa-square"></i> 100.000₫ - 300.000₫</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', '')"><i
									class="far fa-square"></i> 300.000₫ - 500.000₫</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', '')"><i
									class="far fa-square"></i> 500.000₫ - 1.000.000₫ </a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', 'tren1trieu')"><i
									class="far fa-square"></i> Trên 1.000.000₫</a></li>
						</c:when>

					</c:choose>
				</ul>
			</div>

			<div class="color">
				<span class="title">MÀU SẮC</span>
				<ul class="list-unstyled">
					<li><a href="javascript:void(0);"
						onclick="Shop.addUrlParameter('color', 'den')"><i
							class="fas fa-circle" style="color: rgb(0, 0, 0);"></i> Đen</a></li>
					<li><a href="javascript:void(0);"
						onclick="Shop.addUrlParameter('color', 'trang')"><i
							class="fas fa-circle" style="color: white;"></i> Trắng</a></li>
				</ul>
			</div>

			<div class="style">
				<span class="title">STYLE</span>
				<ul class="list-unstyled">
					<li><a href="javascript:void(0);"
						onclick="Shop.addUrlParameter('style', 'thoaimai')"><i
							class="far fa-square"></i> Thoải mái</a></li>
					<li><a href="javascript:void(0);"
						onclick="Shop.addUrlParameter('style', 'thethao')"><i
							class="far fa-square"></i> Thể thao</a></li>
					<li><a href="javascript:void(0);"
						onclick="Shop.addUrlParameter('style', 'duongpho')"><i
							class="far fa-square"></i> Đường phố</a></li>
				</ul>
			</div>

			<div class="chat-lieu">
				<span class="title">CHẤT LIỆU</span>
				<ul class="list-unstyled">
					<li><a href="javascript:void(0);"
						onclick="Shop.addUrlParameter('material', 'da')"><i
							class="far fa-square"></i> Da</a></li>
					<li><a href="javascript:void(0);"
						onclick="Shop.addUrlParameter('material', 'giada')"><i
							class="far fa-square"></i> Giả da</a></li>
				</ul>
			</div>

		</div>

		<div class="product-sp">
			<div class="product-list">
				<div class="list-sort">
					<select id="sort-select"
						onchange="Shop.addUrlParameter('sort', this.value)">
						<option value="">Sắp xếp sản phẩm</option>
						<option value="low-to-high">Giá tăng dần</option>
						<option value="high-to-low">Giá giảm dần</option>
					</select>

				</div>
				<!-- item -->
				<div class="list-shoes">
					<div class="row">
						<c:forEach var="shoesItem" items="${shoesItems }">
							<div class="col-md-3">
								<a href="#"><img
									src="/files_item/${shoesItem.imgShoesItems.get(0).name }"
									alt="product"></a>
								<div class="infor" style="text-align: center;">
									<a href="/item-details/a">
										<h6 class="card-title">${shoesItem.shoes.name }</h6>
									</a>
									<c:choose>
										<c:when test="${shoesItem.discount > 0}">
											<div class="gia-goc">
												<p class="gia-chinh">${shoesItem.price }₫</p>
												<p class="khuyen-mai">(Tiết kiệm: ${shoesItem.discount}%)</p>
											</div>
										</c:when>
										<%-- <c:when test="${shoesItem.discount == 0}">
											<div class="gia-goc">
												<p class="gia-chinh"></p><br><br>
												<p class="khuyen-mai"></p>
											</div>
										</c:when> --%>
									</c:choose>
									<h6 class="gia-ban">${shoesItem.price*(100-shoesItem.discount)/100 }₫</h6>
									<a href="#"><i class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
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