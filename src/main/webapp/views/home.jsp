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
<meta name="description" content="app mua sách">
<meta name="keywords" content="app, mua, sách">
<meta name="author" content="CuongPham">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS & JS -->
<%@ include file="/views/includes/css_js.jsp"%>
<!-- --- -->

<title>BookShop</title>
</head>

<body>
	<!-- HEADER -->
	<%@ include file="/views/includes/header.jsp"%>
	<!-- ------ -->


	<!-- MAIN  -->
	<div id="banner">
		<div id="demo" class="carousel slide" data-ride="carousel">

			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
			</ul>

			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="/img/banner4.jpg" alt="Banner">
				</div>
				<div class="carousel-item">
					<img src="/img/banner5.jpg" alt="Banner">
				</div>
				<div class="carousel-item">
					<img src="/img/banner6.jpg" alt="Banner">
				</div>
				<div class="carousel-item">
					<img src="/img/banner1.jpg" alt="Banner">
				</div>
			</div>

			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>

		</div>
	</div>

	<!-- MAIN -->
	<div id="main">
		<div class="container">
			<div class="category">
				<h3 class="tieu-de" style="margin-top: 20px; text-align: center;">DANH
					MỤC</h3>
				<div class="row">
					<div class="col-md-3">
						<a href="#"><img src="/img/clothes.png" alt="product"></a>
						<div class="infor" style="text-align: center;">
							<a href="#">
								<h6>Clothes</h6>
							</a>
						</div>
					</div>

					<div class="col-md-3">
						<a href="#"><img src="/img/electronic.png" alt="product"></a>
						<div class="infor" style="text-align: center;">
							<a href="#">
								<h6>Electronics</h6>
							</a>
						</div>
					</div>

					<div class="col-md-3">
						<a href="#"><img src="/img/shoes.png" alt="product"></a>
						<div class="infor" style="text-align: center;">
							<a href="#">
								<h6>Shoes</h6>
							</a>
						</div>
					</div>

					<div class="col-md-3">
						<a href="#"><img src="/img/book.png" alt="product"></a>
						<div class="infor" style="text-align: center;">
							<a href="#">
								<h6>Book</h6>
							</a>
						</div>
					</div>

				</div>
			</div>

			<div class="book">
				<h3 class="tieu-de" style="margin-top: 20px; text-align: center;">BOOK</h3>
				<div class="row">
					<c:forEach var="bookItem" items="${bookItems }" varStatus="loop">
						<c:if test="${loop.index <4 }">
							<div class="col-md-3">
								<div style="text-align: center;">
									<a href="#"><img
										src="/files_item/${bookItem.imgBookItems.get(0).name }"
										alt="product"></a>
								</div>
								<div class="infor" style="text-align: center;">
									<a href="">
										<h6>${bookItem.book.title }</h6>
									</a>
									<c:choose>
										<c:when test="${bookItem.discount > 0}">
											<div class="gia-goc">
												<p class="gia-chinh">${bookItem.price }Đ</p>
												<p class="khuyen-mai">(Tiết kiệm: ${bookItem.discount}%)</p>
											</div>
										</c:when>
									</c:choose>
									<h6 class="gia-ban">${bookItem.price*(100-bookItem.discount)/100 }</h6>
									<a href="buy?id=${product.id }"><i
										class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
								</div>
							</div>
						</c:if>
					</c:forEach>




				</div>
			</div>

		</div>

	</div>
	<!-- --- -->

	<!-- FOOTER -->
	<%@ include file="/views/includes/footer.jsp"%>
	<!-- ------ -->


</body>

</html>