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
		<h4 class="tieude-tp">ELECTRONICS</h4>
		<div class="loc-sp">
			<span class="title-x">LỌC SẢN PHẨM</span>
			<div class="danh-muc">
				<span class="title">DANH MỤC</span>
				<ul class="list-unstyled">
					<li><a href="/electronics"><i
							class="fas fa-angle-double-right"></i> All</a></li>
					<li><a href="/electronics/find-by-category/tivi"><i
							class="fas fa-angle-double-right"></i> Tivi</a></li>
					<li><a href="/electronics/find-by-category/mobile-phone"><i
							class="fas fa-angle-double-right"></i> MobilePhone</a></li>
					<li><a href="/electronics/find-by-category/laptop"><i
							class="fas fa-angle-double-right"></i> Laptop</a></li>
				</ul>
			</div>

			<div class="danh-muc">
				<span class="title">HÃNG SẢN XUẤT</span>
				<ul class="list-unstyled">
					<c:forEach var="manufacturer" items="${manufacturers }">
						<li><a
							href="/electronics/find-by-manufacturer/${manufacturer.id }"><i
								class="fas fa-angle-double-right"></i> ${manufacturer.name }</a></li>
					</c:forEach>

				</ul>
			</div>

			<div class="khoang-gia">
				<span class="title">KHOẢNG GIÁ</span>
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${empty price }">
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', 'duoi10trieu')"><i
									class="far fa-square"></i> Dưới 10 triệu</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', '10den20trieu')"><i
									class="far fa-square"></i> 10 triệu - 20 triệu</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', '20den30trieu')"><i
									class="far fa-square"></i> 20 triệu - 30 triệu</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', '30den40trieu')"><i
									class="far fa-square"></i> 30 triệu - 40 triệu</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', '40den50trieu')"><i
									class="far fa-square"></i> 40 triệu - 50 triệu </a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('price', 'tren50trieu')"><i
									class="far fa-square"></i> Trên 50 triệu</a></li>
						</c:when>
						<c:when test="${price=='duoi10trieu' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('price')"><i
									class="far fa-check-square"></i> Dưới 10 triệu</a></li>
						</c:when>

						<c:when test="${price=='10den20trieu' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('price')"><i
									class="far fa-check-square"></i> 10 triệu - 20 triệu</a></li>
						</c:when>

						<c:when test="${price=='20den30trieu' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('price')"><i
									class="far fa-check-square"></i> 20 triệu - 30 triệu</a></li>
						</c:when>

						<c:when test="${price=='30den40trieu' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('price')"><i
									class="far fa-check-square"></i> 30 triệu - 40 triệu</a></li>
						</c:when>

						<c:when test="${price=='40den50trieu' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('price')"><i
									class="far fa-check-square"></i> 40 triệu - 50 triệu</a></li>
						</c:when>

						<c:when test="${price=='tren50trieu' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('price')"><i
									class="far fa-check-square"></i> Trên 50 triệu</a></li>
						</c:when>

					</c:choose>
				</ul>
			</div>

			<div class="man-hinh">
				<span class="title">KÍCH THƯỚC MÀN HÌNH</span>
				<ul class="list-unstyled">
					<c:choose>
						<c:when test="${empty screendSize }">
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('screendSize', '6.1')"><i
									class="far fa-square"></i> 6.1 inch</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('screendSize', '6.7')"><i
									class="far fa-square"></i> 6.7 inch</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('screendSize', '13')"><i
									class="far fa-square"></i> 13 inch</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('screendSize', '14')"><i
									class="far fa-square"></i> 14 inch</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('screendSize', '15.4')"><i
									class="far fa-square"></i> 15.4 inch</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('screendSize', '15.6')"><i
									class="far fa-square"></i> 15.6 inch</a></li>
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('screendSize', '65')"><i
									class="far fa-square"></i> 65 inch</a></li>
						</c:when>

						<c:when test="${screendSize=='6.1' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('screendSize')"><i
									class="far fa-check-square"></i> 6.1 inch</a></li>
						</c:when>

						<c:when test="${screendSize=='6.7' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('screendSize')"><i
									class="far fa-check-square"></i> 6.7 inch</a></li>
						</c:when>

						<c:when test="${screendSize=='13' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('screendSize')"><i
									class="far fa-check-square"></i> 13 inch</a></li>
						</c:when>

						<c:when test="${screendSize=='14' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('screendSize')"><i
									class="far fa-check-square"></i> 14 inch</a></li>
						</c:when>

						<c:when test="${screendSize=='15.4' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('screendSize')"><i
									class="far fa-check-square"></i> 15.4 inch</a></li>
						</c:when>

						<c:when test="${screendSize=='15.6' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('screendSize')"><i
									class="far fa-check-square"></i> 15.6 inch</a></li>
						</c:when>

						<c:when test="${screendSize=='65' }">
							<li><a href="javascript:void(0);"
								onclick="Shop.deleteUrlParameter('screendSize')"><i
									class="far fa-check-square"></i> 65 inch</a></li>
						</c:when>

					</c:choose>
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

				<div class="list-electronics">
					<div class="row">
						<c:forEach var="electronicsItem" items="${electronicsItems }">
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
											value="${electronicsItem.price }" />
										₫
									</h6>
									<a
										href="javascript:Shop.addToCart('${electronicsItem.slug}','electronics');"><i
										class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

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

	<!-- FOOTER -->
	<%@ include file="/views/includes/footer.jsp"%>
	<!-- ------ -->


</body>

</html>
