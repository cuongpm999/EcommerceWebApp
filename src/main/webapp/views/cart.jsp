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
<link rel="stylesheet" type="text/css" href="/css/cart.css">
<!-- --- -->

<title>Ecommerce Project</title>
</head>

<body>
	<!-- HEADER -->
	<%@ include file="/views/includes/header.jsp"%>
	<!-- ------ -->

	<!-- MAIN  -->
	<div id="main" class="container">
		<h4 class="tieude-tp">GIỎ HÀNG CỦA BẠN</h4>
		<div class="row header-title text-center d-flex">
			<div class="col-4">Sản phẩm</div>
			<div class="col-2">Đơn giá</div>
			<div class="col-2">Số lượng</div>
			<div class="col-2">Thành tiền</div>
			<div class="col-2"></div>
		</div>
		<c:forEach var="lineElectronicsItem"
			items="${cart.lineElectronicsItems }">
			<div class="row item text-center">
				<div class="col-4 text-center">
					<div class="row">
						<div class="col-4">
							<a
								href="/electronics/${lineElectronicsItem.electronicsItem.slug }"><img
								src="/files_item/${lineElectronicsItem.electronicsItem.imgElectronicsItems.get(0).name }"
								class="img-fluid" alt="Responsive image" /></a>
						</div>
						<div class="col-8"
							style="align-self: center; word-break: break-all;">
							<a
								href="/electronics/${lineElectronicsItem.electronicsItem.slug }">${lineElectronicsItem.electronicsItem.electronics.name }</a>
						</div>
					</div>
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;">
					<fmt:formatNumber type="number" maxFractionDigits="3"
						value="${lineElectronicsItem.electronicsItem.price*(100-lineElectronicsItem.electronicsItem.discount)/100 }" />
					₫
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;">
					<input class="form-control" value="${lineElectronicsItem.quanity }"
						type="number" min=1 style="width: 70px; margin: auto;"
						id="quantity${lineElectronicsItem.electronicsItem.slug}"
						onchange="Shop.editCart('${lineElectronicsItem.electronicsItem.slug}','electronics')">
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;"
					id="price${lineElectronicsItem.electronicsItem.slug}">
					<fmt:formatNumber type="number" maxFractionDigits="3"
						value="${(lineElectronicsItem.electronicsItem.price*(100-lineElectronicsItem.electronicsItem.discount)/100) * lineElectronicsItem.quanity }" />
					₫
				</div>
				<div class="col-2" style="align-self: center;">
					<a href="javascript:void(0);"
						onclick="Shop.deleteCart('${lineElectronicsItem.electronicsItem.slug}','electronics')"
						style="color: black;"><i class="far fa-trash-alt"></i></a>
				</div>
			</div>
		</c:forEach>

		<c:forEach var="lineShoesItem" items="${cart.lineShoesItems }">
			<div class="row item text-center">
				<div class="col-4 text-center">
					<div class="row">
						<div class="col-4">
							<a href="/shoes/${lineShoesItem.shoesItem.slug }"><img
								src="/files_item/${lineShoesItem.shoesItem.imgShoesItems.get(0).name }"
								class="img-fluid" alt="Responsive image" /></a>
						</div>
						<div class="col-8"
							style="align-self: center; word-break: break-all;">
							<a href="/shoes/${lineShoesItem.shoesItem.slug }">${lineShoesItem.shoesItem.shoes.name }</a>
						</div>
					</div>
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;">
					<fmt:formatNumber type="number" maxFractionDigits="3"
						value="${lineShoesItem.shoesItem.price*(100-lineShoesItem.shoesItem.discount)/100 }" />
					₫
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;">
					<input class="form-control" value="${lineShoesItem.quanity }"
						type="number" min=1 style="width: 70px; margin: auto;"
						id="quantity${lineShoesItem.shoesItem.slug}"
						onchange="Shop.editCart('${lineShoesItem.shoesItem.slug}','shoes')">
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;"
					id="price${lineShoesItem.shoesItem.slug}">
					<fmt:formatNumber type="number" maxFractionDigits="3"
						value="${(lineShoesItem.shoesItem.price*(100-lineShoesItem.shoesItem.discount)/100) * lineShoesItem.quanity }" />
					₫
				</div>
				<div class="col-2" style="align-self: center;">
					<a href="javascript:void(0);"
						onclick="Shop.deleteCart('${lineShoesItem.shoesItem.slug}','shoes')"
						style="color: black;"><i class="far fa-trash-alt"></i></a>
				</div>
			</div>
		</c:forEach>

		<c:forEach var="lineClothesItem" items="${cart.lineClothesItems }">
			<div class="row item text-center">
				<div class="col-4 text-center">
					<div class="row">
						<div class="col-4">
							<a href="/clothes/${lineClothesItem.clothesItem.slug }"><img
								src="/files_item/${lineClothesItem.clothesItem.imgClothesItems.get(0).name }"
								class="img-fluid" alt="Responsive image" /></a>
						</div>
						<div class="col-8"
							style="align-self: center; word-break: break-all;">
							<a href="/clothes/${lineClothesItem.clothesItem.slug }">${lineClothesItem.clothesItem.clothes.name }</a>
						</div>
					</div>
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;">
					<fmt:formatNumber type="number" maxFractionDigits="3"
						value="${lineClothesItem.clothesItem.price*(100-lineClothesItem.clothesItem.discount)/100 }" />
					₫
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;">
					<input class="form-control" value="${lineClothesItem.quanity }"
						type="number" min=1 style="width: 70px; margin: auto;"
						id="quantity${lineClothesItem.clothesItem.slug}"
						onchange="Shop.editCart('${lineClothesItem.clothesItem.slug}','clothes')">
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;"
					id="price${lineClothesItem.clothesItem.slug}">
					<fmt:formatNumber type="number" maxFractionDigits="3"
						value="${(lineClothesItem.clothesItem.price*(100-lineClothesItem.clothesItem.discount)/100) * lineClothesItem.quanity }" />
					₫
				</div>
				<div class="col-2" style="align-self: center;">
					<a href="javascript:void(0);"
						onclick="Shop.deleteCart('${lineClothesItem.clothesItem.slug}','clothes')"
						style="color: black;"><i class="far fa-trash-alt"></i></a>
				</div>
			</div>
		</c:forEach>

		<c:forEach var="lineBookItem" items="${cart.lineBookItems }">
			<div class="row item text-center">
				<div class="col-4 text-center">
					<div class="row">
						<div class="col-4">
							<a href="/book/${lineBookItem.bookItem.slug }"><img
								src="/files_item/${lineBookItem.bookItem.imgBookItems.get(0).name }"
								class="img-fluid" alt="Responsive image" /></a>
						</div>
						<div class="col-8"
							style="align-self: center; word-break: break-all;">
							<a href="/book/${lineBookItem.bookItem.slug }">${lineBookItem.bookItem.book.title }</a>
						</div>
					</div>
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;">
					<fmt:formatNumber type="number" maxFractionDigits="3"
						value="${lineBookItem.bookItem.price*(100-lineBookItem.bookItem.discount)/100 }" />
					₫
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;">
					<input class="form-control" value="${lineBookItem.quanity }"
						type="number" min=1 style="width: 70px; margin: auto;"
						id="quantity${lineBookItem.bookItem.slug}"
						onchange="Shop.editCart('${lineBookItem.bookItem.slug}','book')">
				</div>
				<div class="col-2"
					style="align-self: center; word-break: break-all;"
					id="price${lineBookItem.bookItem.slug}">
					<fmt:formatNumber type="number" maxFractionDigits="3"
						value="${(lineBookItem.bookItem.price*(100-lineBookItem.bookItem.discount)/100) * lineBookItem.quanity }" />
					₫
				</div>
				<div class="col-2" style="align-self: center;">
					<a href="javascript:void(0);"
						onclick="Shop.deleteCart('${lineBookItem.bookItem.slug}','book')"
						style="color: black;"><i class="far fa-trash-alt"></i></a>
				</div>
			</div>
		</c:forEach>
		
		<div class="card-body row"
			style="justify-content: flex-end; background: white; margin-top: 10px">
			<div class="tongtienthanhtoan">
				Tổng tiền đơn hàng : <strong><span id="total_value"><fmt:formatNumber
							type="number" maxFractionDigits="3" value="${cart.totalAmount }" />
						</span>₫</strong>
			</div>
		</div>
		<div class="row" style="justify-content: flex-end; margin-top: 20px">
			<a href="#" class="btn btn-success button-buy-submit-cart">Tiến
				hành đặt hàng</a>
		</div>

	</div>
	<!-- ----- -->
	<!-- FOOTER -->
	<%@ include file="/views/includes/footer.jsp"%>
	<!-- ------ -->


</body>

</html>
