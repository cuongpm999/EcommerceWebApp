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

<title>Ecommerce Project</title>

<!-- CSS & JS -->
<!-- CSS -->
<%@ include file="/views/includes/css_js.jsp"%>

<link rel="stylesheet" type="text/css" href="/css/form.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/views/includes/header.jsp"%>
	<!-- ------ -->

	<!-- MAIN -->
	<div id="main" class="container lienhe">
		<h4 class="tieude-tp">ĐĂNG KÍ</h4>
		<div class="row card">
			<div class="col-md-12" style="padding: 10px;">
				<div class="card-body">
					<div class="panel-body">
						<form:form modelAttribute="customerMember" action="/register"
							id="registerForm" method="post">
							<div class="form-group">
								<label class="required">First name:</label>
								<form:input path="fullName.firstName" class="form-control"
									placeholder="First name" />
							</div>

							<div class="form-group">
								<label class="required">Middle name:</label>
								<form:input path="fullName.middleName" class="form-control"
									placeholder="Middle name" />
							</div>

							<div class="form-group">
								<label class="required">Last name:</label>
								<form:input path="fullName.lastName" class="form-control"
									placeholder="Last name" />
							</div>

							<div class="form-group">
								<label class="required">Mobile:</label>
								<form:input path="mobile" class="form-control"
									placeholder="Mobile" />
							</div>

							<div class="form-group">
								<c:choose>
									<c:when test="${status1=='faileEmailBiTrung'}">
										<div class="alert alert-danger">
											<strong>Failed!</strong> Email đã được sử dụng!
										</div>
									</c:when>
								</c:choose>
								<label class="required">Email:</label>
								<form:input path="email" class="form-control"
									placeholder="Email" />
							</div>

							<div class="form-group">
								<label class="required">Gender:</label>&ensp;
								<form:radiobutton path="sex" value="nam" label="Nam"
									checked="checked" />
								&emsp;
								<form:radiobutton path="sex" value="nữ" label="Nữ" />
							</div>

							<div class="form-group">
								<label class="required">Date of birth:</label> <input
									type="date" name="dob" class="form-control"
									placeholder="Date of birth" />
							</div>

							<div class="form-group">
								<label class="required">Apartment number:</label>
								<form:input path="address.number" class="form-control"
									placeholder="Apartment number" />
							</div>

							<div class="form-group">
								<label class="required">Street:</label>
								<form:input path="address.street" class="form-control"
									placeholder="Street" />
							</div>

							<div class="form-group">
								<label class="required">District:</label>
								<form:input path="address.district" class="form-control"
									placeholder="District" />
							</div>

							<div class="form-group">
								<label class="required">City:</label>
								<form:input path="address.city" class="form-control"
									placeholder="City" />
							</div>

							<div class="form-group">
								<c:choose>
									<c:when test="${status2=='faileTenBiTrung'}">
										<div class="alert alert-danger">
											<strong>Failed!</strong> Tên tài khoản đã được sử dụng!
										</div>
									</c:when>
								</c:choose>
								<label class="required">Username:</label>
								<form:input path="account.username" class="form-control"
									placeholder="Username" />
							</div>

							<div class="form-group">
								<label class="required">Password:</label>
								<form:input path="account.password" class="form-control"
									placeholder="Password" type="password" />
							</div>

							<div class="card-body">
								<button type="submit" class="btn btn-success">
									<i class="fas fa-download"></i> Đăng kí
								</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ------ -->

	<!-- FOOTER -->
	<%@ include file="/views/includes/footer.jsp"%>
	<!-- ------ -->
</body>

<script type="text/javascript">
	$().ready(function() {
		$('#registerForm').validate({
			rules : {
				'fullName.firstName' : "required",
				'fullName.middleName' : "required",
				'fullName.lastName' : "required",
				mobile : {
					required : true,
					digits : true,
					minlength : 10,
					maxlength : 10,
				},
				email : {
					required : true,
					email : true
				},
				dob : "required",
				'address.number' : {
					required : true,
					digits : true,
				},
				'address.street' : "required",
				'address.district' : "required",
				'address.city' : "required",
				'account.username' : "required",
				'account.password' : {
					required : true,
					minlength : 6,
				}
			},
			messages : {
				'fullName.firstName' : "Please enter your first name",
				'fullName.middleName' : "Please enter your middle name",
				'fullName.lastName' : "Please enter your last name",
				mobile : {
					required : "Please enter phone numbers",
					minlength : "Số điện thoại phải bao gồm 10 số",
					maxlength : "Số điện thoại chỉ bao gồm 10 số",
					digits : "Số điện thoại chỉ bao gồm số"
				},
				email : {
					required : "Vui lòng nhập Email",
					email : "Vui lòng nhập đúng Email"
				},
				dob : "Vui lòng nhập ngày sinh",
				'address.number' : {
					required : "Vui lòng nhập số nhà",
					digits : "Số nhà phải là số"
				},
				'address.street' : "Vui lòng nhập tên đường",
				'address.district' : "Vui lòng nhập tên quận, huyện",
				'address.city' : "Vui lòng nhập tên thành phố",
				'account.username' : "Vui lòng đăng kí tên tài khoản",
				'account.password' : {
					required : "Vui lòng đăng kí mật khẩu",
					minlength : "Mật khẩu cần tối thiểu 6 kí tự"
				}
			},
		})
	})
</script>

<style>
.error {
	font-weight: 400 !important;
	color: red;
	font-size: 15px !important;
}
</style>

</html>