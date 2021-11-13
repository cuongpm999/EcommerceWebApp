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
<link rel="stylesheet" type="text/css" href="/css/buy-now.css">
<link rel="stylesheet" type="text/css" href="/css/cart.css">
<!-- --- -->

<title>Check out</title>
</head>

<body>
	<!-- HEADER -->
	<%@ include file="/views/includes/header.jsp"%>
	<!-- ------ -->

	<!-- MAIN -->
	<div id="main">
		<div class="container" style="padding: 0;">
			<div class="type-address">
				<div class="row">
					<div class="col-6">
						<h1>Địa Chỉ Nhận Hàng</h1>
					</div>
					<div class="col-6">
						<button type="button" class="btn btn-dark" style="float: right"
							data-toggle="modal" data-target="#exampleModal">Sửa địa
							chỉ</button>
					</div>
				</div>
				<div class="form-check radio-address">
					<span class="name-customer">${order.customer.fullName.firstName }
						${order.customer.fullName.lastName }</span> <span
						class="address-customer">${order.customer.address.number }
						${order.customer.address.street }
						${order.customer.address.district } ${order.customer.address.city }</span>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row header-title text-center d-flex">
				<div class="col-4">Sản phẩm</div>
				<div class="col-2">Đơn giá</div>
				<div class="col-2">Số lượng</div>
				<div class="col-2">Thành tiền</div>
				<div class="col-2"></div>
			</div>
			<c:forEach var="lineElectronicsItem"
				items="${order.shoppingCart.lineElectronicsItems }">
				<div class="row item text-center">
					<div class="col-4 text-center">
						<div class="row">
							<div class="col-4">
								<a href="javascript:void(0);"><img
									src="/files_item/${lineElectronicsItem.electronicsItem.imgElectronicsItems.get(0).name }"
									class="img-fluid" alt="Responsive image" /></a>
							</div>
							<div class="col-8"
								style="align-self: center; word-break: break-all;">
								<a href="javascript:void(0);">${lineElectronicsItem.electronicsItem.electronics.name }</a>
							</div>
						</div>
					</div>

					<div class="col-2"
						style="align-self: center; word-break: break-all;">${lineElectronicsItem.electronicsItem.price*(100-lineElectronicsItem.electronicsItem.discount)/100 }đ</div>
					<div class="col-2"
						style="align-self: center; word-break: break-all;">
						${lineElectronicsItem.quanity }</div>
					<div class="col-2"
						style="align-self: center; word-break: break-all;"
						id="price${lineElectronicsItem.electronicsItem.slug}">${(lineElectronicsItem.electronicsItem.price*(100-lineElectronicsItem.electronicsItem.discount)/100) * lineElectronicsItem.quanity }đ</div>

				</div>
			</c:forEach>

			<c:forEach var="lineShoesItem"
				items="${order.shoppingCart.lineShoesItems }">
				<div class="row item text-center">
					<div class="col-4 text-center">
						<div class="row">
							<div class="col-4">
								<a href="javascript:void(0);"><img
									src="/files_item/${lineShoesItem.shoesItem.imgShoesItems.get(0).name }"
									class="img-fluid" alt="Responsive image" /></a>
							</div>
							<div class="col-8"
								style="align-self: center; word-break: break-all;">
								<a href="javascript:void(0);">${lineShoesItem.shoesItem.shoes.name }</a>
							</div>
						</div>
					</div>

					<div class="col-2"
						style="align-self: center; word-break: break-all;">${lineShoesItem.shoesItem.price*(100-lineShoesItem.shoesItem.discount)/100 }đ</div>
					<div class="col-2"
						style="align-self: center; word-break: break-all;">
						${lineShoesItem.quanity }</div>
					<div class="col-2"
						style="align-self: center; word-break: break-all;"
						id="price${lineShoesItem.shoesItem.slug}">${(lineShoesItem.shoesItem.price*(100-lineShoesItem.shoesItem.discount)/100) * lineShoesItem.quanity }đ</div>

				</div>
			</c:forEach>

			<c:forEach var="lineClothesItem"
				items="${order.shoppingCart.lineClothesItems }">
				<div class="row item text-center">
					<div class="col-4 text-center">
						<div class="row">
							<div class="col-4">
								<a href="javascript:void(0);"><img
									src="/files_item/${lineClothesItem.clothesItem.imgClothesItems.get(0).name }"
									class="img-fluid" alt="Responsive image" /></a>
							</div>
							<div class="col-8"
								style="align-self: center; word-break: break-all;">
								<a href="javascript:void(0);">${lineClothesItem.clothesItem.clothes.name }</a>
							</div>
						</div>
					</div>

					<div class="col-2"
						style="align-self: center; word-break: break-all;">${lineClothesItem.clothesItem.price*(100-lineClothesItem.clothesItem.discount)/100 }đ</div>
					<div class="col-2"
						style="align-self: center; word-break: break-all;">
						${lineClothesItem.quanity }</div>
					<div class="col-2"
						style="align-self: center; word-break: break-all;"
						id="price${lineClothesItem.clothesItem.slug}">${(lineClothesItem.clothesItem.price*(100-lineClothesItem.clothesItem.discount)/100) * lineClothesItem.quanity }đ</div>

				</div>
			</c:forEach>

			<c:forEach var="lineBookItem"
				items="${order.shoppingCart.lineBookItems }">
				<div class="row item text-center">
					<div class="col-4 text-center">
						<div class="row">
							<div class="col-4">
								<a href="javascript:void(0);"><img
									src="/files_item/${lineBookItem.bookItem.imgBookItems.get(0).name }"
									class="img-fluid" alt="Responsive image" /></a>
							</div>
							<div class="col-8"
								style="align-self: center; word-break: break-all;">
								<a href="javascript:void(0);">${lineBookItem.bookItem.book.title }</a>
							</div>
						</div>
					</div>

					<div class="col-2"
						style="align-self: center; word-break: break-all;">${lineBookItem.bookItem.price*(100-lineBookItem.bookItem.discount)/100 }đ</div>
					<div class="col-2"
						style="align-self: center; word-break: break-all;">
						${lineBookItem.quanity }</div>
					<div class="col-2"
						style="align-self: center; word-break: break-all;"
						id="price${lineBookItem.bookItem.slug}">${(lineBookItem.bookItem.price*(100-lineBookItem.bookItem.discount)/100) * lineBookItem.quanity }đ</div>

				</div>
			</c:forEach>
			<div class="card-body row"
				style="justify-content: flex-end; background: white; margin-top: 10px">
				<div class="tongtienthanhtoan">
					Tổng tiền đơn hàng : <strong><span id="total_value">${order.shoppingCart.totalAmount }</span>₫</strong>
				</div>
			</div>
		</div>

		<div class="container payment-method-type-delivery">
			<div class="row payment-method">
				<h4>Phương thức thanh toán</h4>
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active method-payment"><a
						href="#tab-01" aria-controls="tab-01" role="tab" data-toggle="tab">Thanh
							toán khi nhận hàng</a></li>
					<li class="method-payment" role="presentation"><a
						href="#tab-02" aria-controls="tab-02" role="tab" data-toggle="tab">Digital
							Wallet</a></li>
					<li class="method-payment" role="presentation"><a
						href="#tab-03" aria-controls="tab-03" role="tab" data-toggle="tab">Credit</a>
					</li>
				</ul>
			</div>
			<form action="/checkout/finish" method="post">
				<div class="row">
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="tab-01">
							Thanh toán khi nhận hàng.</div>
						<div role="tabpanel" class="tab-pane" id="tab-02">
							<div class="row">
								<select class="form-control" style="margin-left: 10px"
									name="paymentType">
									<option value="Chọn hình thức thanh toán">Chọn hình
										thức thanh toán</option>
									<option value="Thanh toán bằng Paypal">Thanh toán bằng
										Paypal</option>
								</select>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="tab-03">
							<div class="row">
								<div class="col-md-4 mb-3">
									<label for="cc-name">Name on card</label> <input type="text"
										class="form-control" id="cc-name" name="cc-name" />
									<div class="invalid-feedback">Name on card is required</div>
								</div>
								<div class="col-md-4 mb-3">
									<label for="cc-number">Credit card number</label> <input
										type="text" class="form-control" id="cc-number"
										name="cc-number" />
									<div class="invalid-feedback">Credit card number is
										required</div>
								</div>
								<div class="col-md-4 mb-3">
									<label for="cc-expiration">Expiration</label> <input
										type="text" class="form-control" id="cc-expiration"
										name="cc-expiration" />
									<div class="invalid-feedback">Expiration date required</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<h4>Phương thức vận chuyển</h4>
					<select class="form-control"
						style="margin-left: 10px; width: auto;"
						onchange="Shop.selectShipment(value)" name="shipmentId">
						<c:forEach var="shipment" items="${shipments }">
							<option value="${shipment.id }">${shipment.name }</option>
						</c:forEach>
					</select>
				</div>
				<div class="row summary">
					<div class="col-8" style="align-self: center"></div>
					<div class="col-4" style="align-self: center">
						<h4 class="summary-left">
							Tổng tiền hàng <span class="summary-right" style="float: right">₫${order.shoppingCart.totalAmount }</span>
						</h4>
						<h4 class="summary-left">
							Phí vận chuyển<span class="summary-right" style="float: right"
								id="shipment-price">₫${shipments.get(0).price}</span>
						</h4>
						<h4 class="summary-left">
							Tổng thanh toán:<span class="summary-right red-color"
								style="float: right" id="payment-price">₫${order.shoppingCart.totalAmount + shipments.get(0).price }</span>
						</h4>
						<button type="submit" class="btn btn-danger button-submit">
							Đặt hàng</button>
					</div>
				</div>
			</form>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<div style="text-align: center; width: 100%;">
							<h5 class="modal-title" id="exampleModalLabel"
								style="font-size: 25px;">Sửa địa chỉ</h5>
						</div>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Số nhà</label> <input type="text" value="${order.customer.address.number }" class="form-control"
								id="number" />
						</div>
						<div class="form-group">
							<label>Tên đường</label> <input type="text" value="${order.customer.address.street }" class="form-control"
								id="street" />
						</div>
						<div class="form-group">
							<label>Quận/Huyện</label> <input type="text" value="${order.customer.address.district }" class="form-control"
								id="district" />
						</div>
						<div class="form-group">
							<label>Thành phố</label> <input type="text" value="${order.customer.address.city }" class="form-control"
								id="city" />
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" onclick="Shop.editAddress()">Lưu
							lại</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" type="submit">Đóng</button>
					</div>
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