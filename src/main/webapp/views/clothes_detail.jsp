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
<title>Document</title>
<!-- CSS & JS -->
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
<!-- --- -->
<link rel="stylesheet" href="slick-1.8.1/slick/slick.css">
<link rel="stylesheet" href="slick-1.8.1/slick/slick-theme.css">

<script src="slick-1.8.1/slick/slick.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<script src="js/main.js"></script>
</head>

<body>
	<div id="main" class="container ">
		<div class="row body">
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
							<h4 style="text-decoration: line-through; line-height: 35px;">${clothesItemDetail.price }₫</h4>
						</c:when>
					</c:choose>
					<h3 class="price">${clothesItemDetail.price*(100-clothesItemDetail.discount)/100 }₫</h3>
				</div>
				<div class="table-mid" style="margin-top: 20px">
					<div class="button" style="display: flex">
						<a href="#" class="btn1"
							style="background-color: #ffeee8; line-height: 46px; margin-right: 40px;">
							<i class="fas fa-cart-plus"></i> Thêm vào giỏ hàng
						</a> <a href="#" class="btn2"
							style="line-height: 46px; color: white; font-size: 16px; font-weight: 600;">MUA
							NGAY</a>
					</div>
				</div>
			</div>
		</div>

		<!-- SPTT -->

		<div class="clothes">
			<h3 class="tieu-de" style="margin-top: 20px; text-align: center;">Các
				sản phẩm tương tự</h3>
			<div class="row">
				<c:forEach var="clothesItem" items="${clothesItems }" begin="0"
					end="3">
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
	</div>

</body>

</html>