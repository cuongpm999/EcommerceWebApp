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
<link rel="stylesheet" href="/css/slick.css">
<link rel="stylesheet" href="/css/slick-theme.css">
<script src="/js/slick.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/item-detail.css">
<!-- --- -->

<title>Ecommerce Project</title>
</head>

<body>
	<!-- HEADER -->
	<%@ include file="/views/includes/header.jsp"%>
	<!-- ------ -->

	<!-- MAIN -->
	<div id="main" class="container">
		<div class="information">
			<div class="row">
				<div class="slider col-md-5">
					<div class="slider-for">
						<c:forEach var="imgItem"
							items="${electronicsItem.imgElectronicsItems }">
							<div>
								<img src="/files_item/${imgItem.name }" alt="item">
							</div>
						</c:forEach>
					</div>
					<div class="slider-nav">
						<c:forEach var="imgItem"
							items="${electronicsItem.imgElectronicsItems }">
							<div>
								<span><img src="/files_item/${imgItem.name }" alt="item"></span>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-7">
					<div>
						<h4>${electronicsItem.electronics.name }</h4>
					</div>
					<div class="scrollbar" id="style-1">
						${electronicsItem.electronics.specifications }</div>

					<div style="display: flex;">
						<c:choose>
							<c:when test="${electronicsItem.discount > 0 }">
								<h4 class="gia-chinh">
									<fmt:formatNumber type="number" maxFractionDigits="3"
										value="${electronicsItem.price }" />
									₫
								</h4>
							</c:when>
						</c:choose>
						<h3 class="price">
							<fmt:formatNumber type="number" maxFractionDigits="3"
								value="${electronicsItem.price*(100-electronicsItem.discount)/100 }" />
							₫
						</h3>
					</div>
					<div class="table-mid" style="margin-top: 20px">
						<div class="button" style="display: flex">
							<a
								href="javascript:Shop.addToCart('${electronicsItem.slug}','electronics');"
								class="btn1"
								style="background-color: #ffeee8; line-height: 46px; margin-right: 40px; color: #ee4d2d;">
								<i class="fas fa-cart-plus"></i> Thêm vào giỏ hàng
							</a> <a
								href="javascript:Shop.addToCartNow('${electronicsItem.slug}','electronics');"
								class="btn2"
								style="line-height: 46px; color: white; font-size: 16px; font-weight: 600;">MUA
								NGAY</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="electronics">
			<h4 class="mb-4">Các sản phẩm tương tự</h4>
			<div class="row">
				<c:forEach var="electronicsItem_" items="${item_same }">
					<div class="col-md-3">
						<div style="text-align: center;">
							<a href="/electronics/${electronicsItem_.slug }"><img
								src="/files_item/${electronicsItem_.imgElectronicsItems.get(0).name }"
								alt="product"></a>
						</div>
						<div class="infor" style="text-align: center;">
							<a href="/electronics/${electronicsItem_.slug }">
								<h6>${electronicsItem_.electronics.name }</h6>
							</a>
							<c:choose>
								<c:when test="${electronicsItem_.discount > 0}">
									<div class="gia-goc">
										<p class="gia-chinh">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${electronicsItem_.price }" />
											₫
										</p>
										<p class="khuyen-mai">(Tiết kiệm:
											${electronicsItem_.discount}%)</p>
									</div>
								</c:when>
							</c:choose>
							<h6 class="gia-ban">
								<fmt:formatNumber type="number" maxFractionDigits="3"
									value="${electronicsItem_.price*(100-electronicsItem_.discount)/100 }" />
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
	</div>

	<!-- --- -->

	<!-- FOOTER -->
	<%@ include file="/views/includes/footer.jsp"%>
	<!-- ------ -->


</body>

</html>