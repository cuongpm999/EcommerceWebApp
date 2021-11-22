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
						<c:forEach items="${clothesItemDetail.imgClothesItems }"
							var="imgClothesItem">
							<div>
								<img src="/files_item/${imgClothesItem.name }" alt="">
							</div>
						</c:forEach>
					</div>
					<div class="slider-nav">
						<c:forEach items="${clothesItemDetail.imgClothesItems }"
							var="imgClothesItem">
							<div>
								<img src="/files_item/${imgClothesItem.name }" alt="">
							</div>
						</c:forEach>

					</div>
				</div>
				<div class="col-md-7">
					<div>
						<h4>${clothesItemDetail.clothes.name }</h4>
					</div>
					<table class="table table-hover" style="font-weight: 600;">
						<tbody>
							<tr>
								<td>Color:</td>
								<td>${clothesItemDetail.clothes.color }</td>
							</tr>
							<tr>
								<td>Style:</td>
								<td>${clothesItemDetail.clothes.style }</td>
							</tr>
							<tr>
								<td>Material:</td>
								<td>${clothesItemDetail.clothes.material}</td>
							</tr>
							<c:choose>
								<c:when test="${not empty jeans}">
									<tr>
										<td>Pipe:</td>
										<td>${jeans.pipe }</td>
									</tr>
									<tr>
										<td>Size:</td>
										<td>${jeans.size }</td>
									</tr>
								</c:when>
								<c:when test="${not empty dresses}">
									<tr>
										<td>Size:</td>
										<td>${dresses.size }</td>
									</tr>
									<tr>
										<td>Length:</td>
										<td>${dresses.length }</td>
									</tr>
									<tr>
										<td>Pattern:</td>
										<td>${dresses.pattern }</td>
									</tr>
								</c:when>
								<c:when test="${not empty swimwear}">
									<tr>
										<td>Bust size:</td>
										<td>${swimwear.bustSize }</td>
									</tr>
									<tr>
										<td>Waist size:</td>
										<td>${swimwear.waistSize }</td>
									</tr>
									<tr>
										<td>Hips size:</td>
										<td>${swimwear.hipsSize }</td>
									</tr>
								</c:when>
							</c:choose>

						</tbody>
					</table>

					<div style="display: flex;">
						<c:choose>
							<c:when test="${clothesItemDetail.discount > 0}">
								<h4 class="gia-chinh"">
									<fmt:formatNumber type="number" maxFractionDigits="3"
										value="${clothesItemDetail.price }" />
									₫
								</h4>
							</c:when>
						</c:choose>
						<h3 class="price">
							<fmt:formatNumber type="number" maxFractionDigits="3"
								value="${clothesItemDetail.price*(100-clothesItemDetail.discount)/100 }" />
							₫₫
						</h3>
					</div>
					<div class="table-mid" style="margin-top: 20px">
						<div class="button" style="display: flex">
							<a
								href="javascript:Shop.addToCart('${clothesItemDetail.slug}','clothes');"
								class="btn1"
								style="background-color: #ffeee8; line-height: 46px; margin-right: 40px; color: #ee4d2d;">
								<i class="fas fa-cart-plus"></i> Thêm vào giỏ hàng
							</a> <a
								href="javascript:Shop.addToCartNow('${clothesItemDetail.slug}','clothes');"
								class="btn2"
								style="line-height: 46px; color: white; font-size: 16px; font-weight: 600;">MUA
								NGAY</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- SPTT -->

		<div class="clothes">
			<h4 class="mb-4">Các sản phẩm tương tự</h4>
			<div class="row">
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
								<h6 class="card-title">${clothesItem.clothes.name }</h6>
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
		
		<div class="clothes">
			<h4 class="mb-4">Hỏi đáp về sản phẩm</h4>
			<div class="comment-fb">
				<div class="fb-comments" data-href="https://developers.facebook.com/docs/plugins/${clothesItemDetail.barCode}" data-width="100%" data-numposts="5"></div>
			</div>
		</div>
	</div>

	<!-- FOOTER -->
	<%@ include file="/views/includes/footer.jsp"%>
	<!-- ------ -->
</body>

</html>