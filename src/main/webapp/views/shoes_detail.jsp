<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- sử dụng taglibs của spring để bind-data từ end-point trả về. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- tích hợp jstl vào jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS & JS -->
<!-- CSS -->
<%@ include file="/views/includes/css_js.jsp"%>
<link rel="stylesheet" href="/css/slick.css">
<link rel="stylesheet" href="/css/slick-theme.css">
<script src="/js/slick.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/item-detail.css">
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
						<c:forEach items="${shoesItemDetail.imgShoesItems }"
							var="imgShoesItem">
							<div>
								<img src="/files_item/${imgShoesItem.name }" alt="">
							</div>
						</c:forEach>
					</div>
					<div class="slider-nav">
						<c:forEach items="${shoesItemDetail.imgShoesItems }"
							var="imgShoesItem">
							<div>
								<img src="/files_item/${imgShoesItem.name }" alt="">
							</div>
						</c:forEach>

					</div>
				</div>
				<div class="col-md-7">
					<div>
						<h4>${shoesItemDetail.shoes.name }</h4>
					</div>
					<table class="table table-hover" style="font-weight: 600;">
						<tbody>
							<tr>
								<td>Color:</td>
								<td>${shoesItemDetail.shoes.color }</td>
							</tr>
							<tr>
								<td>Size:</td>
								<td>${shoesItemDetail.shoes.size }</td>
							</tr>
							<tr>
								<td>Style:</td>
								<td>${shoesItemDetail.shoes.style }</td>
							</tr>
							<tr>
								<td>Material:</td>
								<td>${shoesItemDetail.shoes.material}</td>
							</tr>
							<c:choose>
								<c:when test="${not empty sneaker}">
									<tr>
										<td>Clinch:</td>
										<td>${sneaker.clinch == false ? "Không" : "Có" }</td>
									</tr>
									<tr>
										<td>Sole:</td>
										<td>${sneaker.sole }</td>
									</tr>
								</c:when>
								<c:when test="${not empty boots}">
									<tr>
										<td>Shoelace:</td>
										<td>${boots.isShoelace == false ? "Không" : "Có" }</td>
									</tr>
								</c:when>
								<c:when test="${not empty highheels}">
									<tr>
										<td>Height:</td>
										<td>${highheels.height }</td>
									</tr>
								</c:when>
							</c:choose>

						</tbody>
					</table>

					<div style="display: flex;">
						<c:choose>
							<c:when test="${shoesItemDetail.discount > 0}">
								<h4 class="gia-chinh"">
									<fmt:formatNumber type="number" maxFractionDigits="3"
										value="${shoesItemDetail.price }" />
									₫
								</h4>
							</c:when>
						</c:choose>
						<h3 class="price">
							<fmt:formatNumber type="number" maxFractionDigits="3"
								value="${shoesItemDetail.price*(100-shoesItemDetail.discount)/100 }" />
							₫
						</h3>
					</div>
					<div class="table-mid" style="margin-top: 20px">
						<div class="button" style="display: flex">
							<a
								href="javascript:Shop.addToCart('${shoesItemDetail.slug}','shoes');"
								class="btn1"
								style="background-color: #ffeee8; line-height: 46px; margin-right: 40px; color: #ee4d2d;">
								<i class="fas fa-cart-plus"></i> Thêm vào giỏ hàng
							</a> <a
								href="javascript:Shop.addToCartNow('${shoesItemDetail.slug}','shoes');"
								class="btn2"
								style="line-height: 46px; color: white; font-size: 16px; font-weight: 600;">MUA
								NGAY</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- SPTT -->

		<div class="shoes">
			<h4 class="mb-4">Các sản phẩm tương tự</h4>
			<div class="row">
				<c:forEach var="shoesItem" items="${shoesItems }" varStatus="loop">
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
										<p class="gia-chinh">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${shoesItem.price }" />
											₫
										</p>
										<p class="khuyen-mai">(Tiết kiệm: ${shoesItem.discount}%)</p>
									</div>
								</c:when>
							</c:choose>
							<h6 class="gia-ban">
								<fmt:formatNumber type="number" maxFractionDigits="3"
									value="${shoesItem.price*(100-shoesItem.discount)/100 }" />
								₫
							</h6>
							<a href="javascript:Shop.addToCart('${shoesItem.slug}','shoes');"><i
								class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		
		<div class="shoes">
			<h4 class="mb-4">Hỏi đáp về sản phẩm</h4>
			<div class="comment-fb">
				<div class="fb-comments" data-href="https://developers.facebook.com/docs/plugins/${shoesItemDetail.barCode}" data-width="100%" data-numposts="5"></div>
			</div>
		</div>
	</div>

	<!-- FOOTER -->
	<%@ include file="/views/includes/footer.jsp"%>
	<!-- ------ -->
</body>

</html>