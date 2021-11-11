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
<%@ include file="/views/includes/css_js.jsp"%>

<link rel="stylesheet" type="text/css" href="/css/form.css">
</head>
<body>
	<!-- HEADER -->
	<%@ include file="/views/includes/header.jsp"%>
	<!-- ------ -->

	<!-- MAIN -->
	<div id="main" class="container lienhe">
		<h4 class="tieude-tp">ĐỊA CHỈ GIAO HÀNG</h4>
		<div class="row card">
			<div class="col-md-12" style="padding: 10px;">
				<c:choose>
					<c:when test="${status=='success'}">
						<div class="alert alert-success">
							<strong>Success!</strong> Bạn đăng kí tài khoản thành công!
						</div>
					</c:when>
					<c:when test="${status=='faile'}">
						<div class="alert alert-danger">
							<strong>Faile!</strong> Bạn đăng kí tài khoản thất bại!
						</div>
					</c:when>
				</c:choose>
				<div class="card-body">
					<div class="panel-body">
						<form:form modelAttribute="customerNew" action="/checkout"
							enctype="multipart/form-data" id="registerForm">

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
								<label class="required">Email:</label>
								<form:input path="email" class="form-control"
									placeholder="email" />
							</div>

							<div class="form-group">
								<label class="required">Number:</label>
								<form:input type="number" path="address.number"
									class="form-control" placeholder="number" />
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

							<div class="card-body">
								<button type="submit" class="btn btn-success">
									<i class="fas fa-download"></i> Cập nhật
								</button> 
								
								<a href="/cart" class = "btn btn-secondary"><i class="fas fa-backspace"></i> Hủy bỏ</a>
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

</html>