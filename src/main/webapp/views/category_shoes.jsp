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

<%@ include file="/views/includes/css_js.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/category.css">

<title>Laptop Project</title>
</head>

<body>

	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v8.0"
		nonce="ChmFo6ST"></script>

	<!-- HEADER -->
	<%@ include file="/views/includes/header.jsp"%>
	<!-- ------ -->

	<!-- MAIN -->
	<div id="main" class="container all-item">
		<h4 class="tieude-tp">SHOES</h4>
		<div class="loc-sp">
			<span class="title-x">LỌC SẢN PHẨM</span>
			<div class="danh-muc">
				<span class="title">DANH MỤC</span>
				<ul class="list-unstyled">
					<li><a href="/shoes"><i class="fas fa-angle-double-right"></i>
							All</a></li>
					<li><a href="/shoes/find-by-category/sneaker"><i
							class="fas fa-angle-double-right"></i> Sneaker</a></li>
					<li><a href="/shoes/find-by-category/highheels"><i
							class="fas fa-angle-double-right"></i> HighHeels</a></li>
					<li><a href="/shoes/find-by-category/boots"><i
							class="fas fa-angle-double-right"></i> Boots</a></li>
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
								onclick="Shop.addUrlParameter('color', 'Đen')"><i
									class="fas fa-circle" style="color: rgb(0, 0, 0);"></i> Đen</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('color', 'Trắng')"><i
									class="fas fa-circle" style="color: white;"></i> Trắng</a></li>
						</c:when>
						<c:when test="${color == 'Đen' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('color')"><i
									class="fas fa-circle" style="color: rgb(0, 0, 0);"></i> Đen</a></li>
						</c:when>
						<c:when test="${color == 'Trắng' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('color')"><i
									class="fas fa-circle" style="color: white;"></i> Trắng</a></li>
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
								onclick="Shop.addUrlParameter('style', 'Thoải mái')"><i
									class="far fa-square"></i> Thoải mái</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('style', 'Thể thao')"><i
									class="far fa-square"></i> Thể thao</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('style', 'Đường phố')"><i
									class="far fa-square"></i> Đường phố</a></li>
						</c:when>
						<c:when test="${style == 'Thoải mái' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('style')"><i
									class="far fa-check-square"></i> Thoải mái</a></li>
						</c:when>
						<c:when test="${style == 'Thể thao' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('style')"><i
									class="far fa-check-square"></i> Thể thao</a></li>
						</c:when>
						<c:when test="${style == 'Đường phố' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('style')"><i
									class="far fa-check-square"></i> Đường phố</a></li>
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
								onclick="Shop.addUrlParameter('material', 'Da')"><i
									class="far fa-square"></i> Da</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('material', 'Giả da')"><i
									class="far fa-square"></i> Giả da</a></li>
						</c:when>
						<c:when test="${material == 'Da' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('material')"><i
									class="far fa-check-square"></i> Da</a></li>
						</c:when>
						<c:when test="${material == 'Giả da' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('material')"><i
									class="far fa-check-square"></i> Giả da</a></li>
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
				<div class="list-shoes">
					<div class="row">
						<c:forEach var="shoesItem" items="${shoesItems }">
							<div class="col-md-3">
								<div style="text-align: center;">
									<a href="/shoes/${shoesItem.slug }"><img
										src="/files_item/${shoesItem.imgShoesItems.get(0).name }"
										alt="product"></a>
								</div>
								<div class="infor" style="text-align: center;">
									<a href="/shoes/${shoesItem.slug }">
										<h6 class="card-title">${shoesItem.shoes.name }</h6>
									</a>
									<c:choose>
										<c:when test="${shoesItem.discount > 0}">
											<div class="gia-goc">
												<p class="gia-chinh">${shoesItem.price }₫</p>
												<p class="khuyen-mai">(Tiết kiệm:
													${shoesItem.discount}%)</p>
											</div>
										</c:when>
									</c:choose>
									<h6 class="gia-ban">${shoesItem.price*(100-shoesItem.discount)/100 }₫</h6>
									<a href="javascript:Shop.addToCart('${shoesItem.slug}','shoes');"><i class="fas fa-shopping-cart"></i>&nbsp;Mua
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
	<%@ include file="/views/includes/footer.jsp"%>
	<!-- ------- -->

</body>

</html>