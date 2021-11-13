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
<link rel="stylesheet" type="text/css" href="/css/category.css">
<!-- --- -->

<title>Ecommerce Project</title>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/views/includes/header.jsp"%>
	<!-- ------ -->

	<!-- MAIN -->
	<div id="main" class="container all-item">
		<h4 class="tieude-tp">SEARCH ITEM</h4>
		<div class="loc-sp">
			<span class="title-x">LỌC SẢN PHẨM</span>
			<div class="danh-muc">
				<span class="title">DANH MỤC</span>
				<ul class="list-unstyled">
					<li><a href="/book"><i class="fas fa-angle-double-right"></i>
							Book</a></li>
					<li><a href="/electronics"><i
							class="fas fa-angle-double-right"></i> Electronics</a></li>
					<li><a href="/shoes"><i class="fas fa-angle-double-right"></i>
							Shoes</a></li>
					<li><a href="/clothes"><i
							class="fas fa-angle-double-right"></i> Clothes</a></li>
				</ul>
			</div>
		</div>

		<div class="product-sp">
			<div class="product-list">
				<div class="list-book">
					<!-- BOOK -->
					<div class="row">
						<c:forEach var="bookItem" items="${bookItems }" varStatus="loop">
							<div class="col-md-3">
								<div style="text-align: center;">
									<a href="/book/${bookItem.slug }"><img
										src="/files_item/${bookItem.imgBookItems.get(0).name }"
										alt="product"></a>
								</div>
								<div class="infor" style="text-align: center;">
									<a href="/book/${bookItem.slug }">
										<h6>${bookItem.book.title }</h6>
									</a>
									<c:choose>
										<c:when test="${bookItem.discount > 0}">
											<div class="gia-goc">
												<p class="gia-chinh">
													<fmt:formatNumber type="number" maxFractionDigits="3"
														value="${bookItem.price }" />
													₫
												</p>
												<p class="khuyen-mai">(Tiết kiệm: ${bookItem.discount}%)</p>
											</div>
										</c:when>
									</c:choose>
									<h6 class="gia-ban">
										<fmt:formatNumber type="number" maxFractionDigits="3"
											value="${bookItem.price*(100-bookItem.discount)/100 }" />
										₫
									</h6>
									<a href="javascript:Shop.addToCart('${bookItem.slug}','book');"><i
										class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
								</div>
							</div>
						</c:forEach>

						<c:forEach var="electronicsItem" items="${electronicsItems }"
							varStatus="loop">
							<div class="col-md-3">
								<div style="text-align: center;">
									<a href="/electronics/${electronicsItem.slug }"><img
										src="/files_item/${electronicsItem.imgElectronicsItems.get(0).name }"
										alt="product"></a>
								</div>
								<div class="infor" style="text-align: center;">
									<a href="/electronics/${electronicsItem.slug }">
										<h6>${electronicsItem.electronics.name }</h6>
									</a>
									<c:choose>
										<c:when test="${electronicsItem.discount > 0}">
											<div class="gia-goc">
												<p class="gia-chinh">
													<fmt:formatNumber type="number" maxFractionDigits="3"
														value="${electronicsItem.price }" />
													₫
												</p>
												<p class="khuyen-mai">(Tiết kiệm:
													${electronicsItem.discount}%)</p>
											</div>
										</c:when>
									</c:choose>
									<h6 class="gia-ban">
										<fmt:formatNumber type="number" maxFractionDigits="3"
											value="${electronicsItem.price*(100-electronicsItem.discount)/100 }" />
										₫
									</h6>
									<a
										href="javascript:Shop.addToCart('${electronicsItem.slug}','electronics');"><i
										class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
								</div>
							</div>
						</c:forEach>

						<c:forEach var="shoesItem" items="${shoesItems }" varStatus="loop">
							<div class="col-md-3">
								<div style="text-align: center;">
									<a href="/shoes/${shoesItem.slug }"><img
										src="/files_item/${shoesItem.imgShoesItems.get(0).name }"
										alt="product"></a>
								</div>
								<div class="infor" style="text-align: center;">
									<a href="/shoes/${shoesItem.slug }">
										<h6>${shoesItem.shoes.name }</h6>
									</a>
									<c:choose>
										<c:when test="${shoesItem.discount > 0}">
											<div class="gia-goc">
												<p class="gia-chinh">
													<fmt:formatNumber type="number" maxFractionDigits="3"
														value="${shoesItem.price }" />
													₫
												</p>
												<p class="khuyen-mai">(Tiết kiệm:
													${shoesItem.discount}%)</p>
											</div>
										</c:when>
									</c:choose>
									<h6 class="gia-ban">
										<fmt:formatNumber type="number" maxFractionDigits="3"
											value="${shoesItem.price*(100-shoesItem.discount)/100 }" />
										₫
									</h6>
									<a
										href="javascript:Shop.addToCart('${shoesItem.slug}','shoes');"><i
										class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
								</div>
							</div>
						</c:forEach>
						<c:forEach var="clothesItem" items="${clothesItems }"
							varStatus="loop">
							<div class="col-md-3">
								<div style="text-align: center;">
									<a href="/clothes/${clothesItem.slug }"><img
										src="/files_item/${clothesItem.imgClothesItems.get(0).name }"
										alt="product"></a>
								</div>
								<div class="infor" style="text-align: center;">
									<a href="/clothes/${clothesItem.slug }">
										<h6>${clothesItem.clothes.name }</h6>
									</a>
									<c:choose>
										<c:when test="${clothesItem.discount > 0}">
											<div class="gia-goc">
												<p class="gia-chinh">
													<fmt:formatNumber type="number" maxFractionDigits="3"
														value="${clothesItem.price }" />
													₫
												</p>
												<p class="khuyen-mai">(Tiết kiệm:
													${clothesItem.discount}%)</p>
											</div>
										</c:when>
									</c:choose>
									<h6 class="gia-ban">
										<fmt:formatNumber type="number" maxFractionDigits="3"
											value="${clothesItem.price*(100-clothesItem.discount)/100 }" />
										₫
									</h6>
									<a
										href="javascript:Shop.addToCart('${clothesItem.slug}','clothes');"><i
										class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear-with-height"></div>
	<!-- --- -->

	<!-- FOOTER -->
	<%@ include file="/views/includes/footer.jsp"%>
	<!-- ------ -->
</body>

</html>