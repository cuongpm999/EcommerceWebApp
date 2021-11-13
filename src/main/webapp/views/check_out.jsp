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
<link rel="stylesheet" type="text/css" href="/css/cart-custom.css">
<!-- --- -->

<title>Ecommerce Project</title>
</head>

<body>
	<!-- HEADER -->
	<%@ include file="/views/includes/header.jsp"%>
	<!-- ------ -->

	<!-- MAIN -->
	<div id="main">
		<div class="container">
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
					<span class="name-customer">Lê Đức Phan Anh</span> <span
						class="address-customer">B3 Mỹ Đình I, Cầu Diễn, Nam Từ
						Liêm, Hà Nội</span>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row header-title text-center d-flex">
				<div class="col-6">Sản Phẩm</div>
				<div class="col-2">Đơn Giá</div>
				<div class="col-2">Số Lượng</div>
				<div class="col-2">Số Tiền</div>
			</div>
			<div class="row item text-center">
				<div class="col-6 text-center">
					<div class="row">
						<div class="col-4">
							<img
								src="https://image.thanhnien.vn/w660/Uploaded/2021/xdrkxrvekx/2021_09_15/7_xhef.png"
								class="img-fluid" alt="Responsive image" />
						</div>
						<div class="col-8" style="align-self: center">Đi code dạo
							mấy đời mới mua được nhé !</div>
					</div>
				</div>

				<div class="col-2" style="align-self: center">90.000đ</div>
				<div class="col-2" style="align-self: center">3</div>
				<div class="col-2" style="align-self: center">270.000đ</div>
			</div>
			<div class="row item text-center">
				<div class="col-6 text-center">
					<div class="row">
						<div class="col-4">
							<img
								src="https://cdn.tgdd.vn/Products/Images/42/114115/iphone-x-64gb-hh-600x600.jpg"
								class="img-fluid" alt="Responsive image" />
						</div>
						<div class="col-8" style="align-self: center">Iphone 12
							promax cực đẹp trai!</div>
					</div>
				</div>

				<div class="col-2" style="align-self: center">90.000đ</div>
				<div class="col-2" style="align-self: center">3</div>
				<div class="col-2" style="align-self: center">270.000đ</div>
			</div>
			<div class="row item text-center">
				<div class="col-6 text-center">
					<div class="row">
						<div class="col-4">
							<img
								src="https://media.istockphoto.com/photos/new-iphone-x-smart-phone-in-close-upmodern-apple-iphone-10-mobile-picture-id870045538?k=20&m=870045538&s=170667a&w=0&h=801afXMy1eClclhpG7GQLMvjKiOAZzIx8F74NLm4mIQ="
								class="img-fluid" alt="Responsive image" />
						</div>
						<div class="col-8" style="align-self: center">Iphone X100
							cực đắt !</div>
					</div>
				</div>

				<div class="col-2" style="align-self: center">90.000đ</div>
				<div class="col-2" style="align-self: center">3</div>
				<div class="col-2" style="align-self: center">270.000đ</div>
			</div>
		</div>

		<div class="container payment-method-type-delivery">
			<div class="row payment-method">
				<h4>*Phương thức thanh toán</h4>
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active method-payment"><a
						href="#tab-01" aria-controls="tab-01" role="tab" data-toggle="tab">Thanh
							toán khi nhận hàng</a></li>
					<li class="method-payment" role="presentation"><a
						href="#tab-02" aria-controls="tab-02" role="tab" data-toggle="tab">Electronic
							Wallet</a></li>
					<li class="method-payment" role="presentation"><a
						href="#tab-03" aria-controls="tab-03" role="tab" data-toggle="tab">Credit</a>
					</li>
				</ul>
			</div>
			<div class="row">
				<form action="/ga" method="get">
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="tab-01">
							Thanh toán khi nhận hàng Phí thu hộ: ₫0 VNĐ. Ưu đãi về phí vận
							chuyển (nếu có) áp dụng cả với phí thu hộ.</div>
						<div role="tabpanel" class="tab-pane" id="tab-02">
							<div class="row">
								<select class="form-control" style="margin-left: 10px">
									<option value="1" selected>Thanh toán bằng Paypal</option>
								</select>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="tab-03">
							<div class="row">
								<div class="col-md-4 mb-3">
									<label for="cc-name">Name on card</label> <input type="text"
										class="form-control" id="cc-name" required />
									<div class="invalid-feedback">Name on card is required</div>
								</div>
								<div class="col-md-4 mb-3">
									<label for="cc-number">Credit card number</label> <input
										type="text" class="form-control" id="cc-number" required />
									<div class="invalid-feedback">Credit card number is
										required</div>
								</div>
								<div class="col-md-4 mb-3">
									<label for="cc-expiration">Expiration</label> <input
										type="text" class="form-control" id="cc-expiration" required />
									<div class="invalid-feedback">Expiration date required</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="row">
				<h4>*Phương thức vận chuyển</h4>
				<select class="form-select" aria-label="Default select example"
					style="margin-left: 10px">
					<option value="1" selected>Viettel Post</option>
					<option value="2">Ninja Rùa</option>
					<option value="3">Vận chuyển cực chậm</option>
				</select>
			</div>
			<div class="row summary">
				<div class="col-8" style="align-self: center"></div>
				<div class="col-4" style="align-self: center">
					<h4 class="summary-left">
						Tổng tiền hàng <span class="summary-right" style="float: right">₫369.200</span>
					</h4>
					<h4 class="summary-left">
						Phí vận chuyển<span class="summary-right" style="float: right">₫28.700</span>
					</h4>
					<h4 class="summary-left">
						Tổng thanh toán:<span class="summary-right red-color"
							style="float: right">₫397.900</span>
					</h4>
					<button type="button" class="btn btn-danger button-submit">
						Đặt hàng</button>
				</div>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Sửa địa chỉ</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form method="POST">
							<div class="form-group">
								<label>Số nhà</label> <input type="text" class="form-control" />
							</div>
							<div class="form-group">
								<label>Tên đường</label> <input type="text" class="form-control" />
							</div>
							<div class="form-group">
								<label>Quận/Huyện</label> <input type="text"
									class="form-control" />
							</div>
							<div class="form-group">
								<label>Thành phố</label> <input type="text" class="form-control" />
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" type="submit">Đóng</button>
						<button type="button" class="btn btn-primary">Lưu lại</button>
					</div>
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