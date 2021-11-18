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
<meta name="description"
	content="ban laptop uy tin, chat luong, dich vu tot">
<meta name="keywords"
	content="laptop, asus, dell, hp, lenovo, acer, apple, msi, lg">
<meta name="author" content="CuongPham">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS & JAVA_SCRIPT -->
<%@ include file="/views/includes/css_js.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/manage.css">
<!-- ----------------- -->

<title>Ecommerce Project</title>
</head>

<body>

	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v8.0"
		nonce="ChmFo6ST"></script>

	<!-- MAIN -->
	<div id="main">
		<%@ include file="/views/admin/header_admin.jsp"%>

		<div class="main-content">
			<div class="row">
				<div class="col-md-12">
					<div class="form-add">
						<input class="form-control" id="myInput" type="text"
							placeholder="Search..">
						<h3 class="my-3"></h3>

						<table class="table">
							<thead class="thead-light">
								<tr>
									<th>#</th>
									<th>Name</th>
									<th>Price</th>
									<th>Address</th>
									<th>Total Quantity</th>
								</tr>
							</thead>
							<tbody id="myTable">
								<c:forEach items="${shipmentStats }" var="shipmentStat" varStatus="loop">
									<tr>
										<td>${loop.index + 1}</td>
										<td>${shipmentStat.name }</td>
										<td><fmt:formatNumber type="number" maxFractionDigits="3"
												value="${shipmentStat.price }" /> ₫</td>
										<td>${shipmentStat.address }</td>
										<td>${shipmentStat.totalQuantity }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/views/admin/footer_admin.jsp"%>
	</div>
	</div>

</body>

</html>