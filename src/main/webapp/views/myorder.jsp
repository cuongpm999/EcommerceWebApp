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

<title>Ecommerce Project</title>
</head>

<style>
#main .table {
	border-collapse: collapse;
	border: 1px solid #ebebeb;
	text-align: center;
	vertical-align: middle;
}

.table thead tr {
	background: #f8f8f8;
}

.table thead th {
	border-collapse: collapse;
	border: 1px solid #ebebeb;
	text-align: center;
	vertical-align: middle;
	border-bottom: 2px solid #ddd;
	font-size: 15px;
}

.table tbody td {
	border-collapse: collapse;
	border: 1px solid #ebebeb;
	text-align: center;
	vertical-align: middle;
}

.table tbody td a:hover {
	text-decoration: none;
}

.table tfoot .btn {
	padding: 6px 18px;
}

.total-cart {
	text-transform: uppercase;
	text-align: right;
	font-weight: 500;
	font-size: 18px;
	margin-top: 25px;
}

.total-money {
	color: red;
}

.total-cart .btn {
	margin-top: 15px;
	padding: 8px 20px;
}

.panel-primary {
	border-color: #337ab7;
}

.panel {
	margin-bottom: 20px;
	background-color: #fff;
	border: 1px solid #e9ecf2;
	border-radius: 4px;
	-webkit-box-shadow: 0 1px 1px rgb(0 0 0/ 0.2);
	box-shadow: 0 1px 1px rgb(0 0 0/ 0.2);
}

.panel-primary>.panel-heading {
	background-color: #1c215ee6;
	color: #fff;
	border: none;
}

.panel-heading {
	font-size: 18px;
	font-weight: 300;
	letter-spacing: 0.025em;
	height: 60px;
	line-height: 38px;
	padding: 10px 15px;
	border-top-left-radius: 3px;
	border-top-right-radius: 3px;
}

.panel-body {
	padding: 15px;
}

body {
	background: #ededed;
}
</style>

<body>
	<!-- HEADER -->
	<%@ include file="/views/includes/header.jsp"%>
	<!-- ------ -->


	<!-- MAIN  -->
	<div id="main">
		<div class="container">
			<c:forEach var="order" items="${myorders }">
				<div class="panel panel-primary" style="margin-top: 30px;">
					<div class="panel-heading">
						Ngày mua:
						<fmt:formatDate pattern="HH:mm:ss dd/MM/yyyy"
							value="${order.dateCreate}" />
						- Giá:
						<fmt:formatNumber type="number" maxFractionDigits="3"
							value="${order.payment.totalMoney}" />
						₫
					</div>
					<div class="panel-body">
						<div style="margin-bottom: 10px;">
							<c:choose>
								<c:when test="${order.status == 'Đã giao' }">
									<span class="text-success">Đã giao hàng</span>
								</c:when>
								<c:when test="${order.status == 'Chưa giao' }">
									<a class="btn btn-danger" href="/my-order/change-status/${order.id }">Hủy đơn hàng</a>
								</c:when>
								<c:when test="${order.status == 'Đã hủy' }">
									<span class="text-danger">Đã hủy đơn hàng</span>
								</c:when>
							</c:choose>
						</div>
						<table class="table">
							<thead>
								<tr>
									<th>Ảnh sản phẩm</th>
									<th>Tên sản phẩm</th>
									<th style="width: 150px;">Giá</th>
									<th style="width: 100px;">Số lượng</th>
									<th style="width: 150px;">Thành tiền</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="lineBookItem"
									items="${order.shoppingCart.lineBookItems }">
									<tr>
										<td><img style="height: 120px;"
											src="/files_item/${lineBookItem.bookItem.imgBookItems.get(0).name }" /></td>
										<td><a href="javascript:void(0);"
											style="font-size: 15px; color: black;">${lineBookItem.bookItem.book.title }</a></td>
										<td><fmt:formatNumber type="number" maxFractionDigits="3"
												value="${lineBookItem.bookItem.price*(100-lineBookItem.bookItem.discount)/100 }" />
											₫</td>
										<td style="text-align: center">${lineBookItem.quanity }</td>
										<td
											style="font-weight: 500; color: red; font-size: 15px; text-align: center">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${(lineBookItem.bookItem.price*(100-lineBookItem.bookItem.discount)/100) * lineBookItem.quanity }" />
											₫
										</td>
									</tr>
								</c:forEach>

								<c:forEach var="lineClothesItem"
									items="${order.shoppingCart.lineClothesItems }">
									<tr>
										<td><img style="height: 120px;"
											src="/files_item/${lineClothesItem.clothesItem.imgClothesItems.get(0).name }" /></td>
										<td><a href="javascript:void(0);"
											style="font-size: 15px; color: black;">${lineClothesItem.clothesItem.clothes.name }</a></td>
										<td><fmt:formatNumber type="number" maxFractionDigits="3"
												value="${lineClothesItem.clothesItem.price*(100-lineClothesItem.clothesItem.discount)/100 }" />
											₫</td>
										<td style="text-align: center">${lineClothesItem.quanity }</td>
										<td
											style="font-weight: 500; color: red; font-size: 15px; text-align: center">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${(lineClothesItem.clothesItem.price*(100-lineClothesItem.clothesItem.discount)/100) * lineClothesItem.quanity }" />
											₫
										</td>
									</tr>
								</c:forEach>

								<c:forEach var="lineElectronicsItem"
									items="${order.shoppingCart.lineElectronicsItems }">
									<tr>
										<td><img style="height: 120px;"
											src="/files_item/${lineElectronicsItem.electronicsItem.imgElectronicsItems.get(0).name }" /></td>
										<td><a href="javascript:void(0);"
											style="font-size: 15px; color: black;">${lineElectronicsItem.electronicsItem.electronics.name }</a></td>
										<td><fmt:formatNumber type="number" maxFractionDigits="3"
												value="${lineElectronicsItem.electronicsItem.price*(100-lineElectronicsItem.electronicsItem.discount)/100 }" />
											₫</td>
										<td style="text-align: center">${lineElectronicsItem.quanity }</td>
										<td
											style="font-weight: 500; color: red; font-size: 15px; text-align: center">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${(lineElectronicsItem.electronicsItem.price*(100-lineElectronicsItem.electronicsItem.discount)/100) * lineElectronicsItem.quanity }" />
											₫
										</td>
									</tr>
								</c:forEach>

								<c:forEach var="lineShoesItem"
									items="${order.shoppingCart.lineShoesItems }">
									<tr>
										<td><img style="height: 120px;"
											src="/files_item/${lineShoesItem.shoesItem.imgShoesItems.get(0).name }" /></td>
										<td><a href="javascript:void(0);" style="font-size: 15px; color: black;">${lineShoesItem.shoesItem.shoes.name }</a></td>
										<td><fmt:formatNumber type="number" maxFractionDigits="3"
												value="${lineShoesItem.shoesItem.price*(100-lineShoesItem.shoesItem.discount)/100 }" /> ₫</td>
										<td style="text-align: center">${lineShoesItem.quanity }</td>
										<td
											style="font-weight: 500; color: red; font-size: 15px; text-align: center">
											<fmt:formatNumber type="number" maxFractionDigits="3"
												value="${(lineShoesItem.shoesItem.price*(100-lineShoesItem.shoesItem.discount)/100) * lineShoesItem.quanity }" /> ₫
										</td>
									</tr>
								</c:forEach>
						</table>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- --- -->

	<!-- FOOTER -->
	<%@ include file="/views/includes/footer.jsp"%>
	<!-- ------ -->


</body>

</html>