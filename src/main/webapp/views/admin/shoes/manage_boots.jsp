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

<title>Laptop Project</title>
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
							placeholder="Search.."> <a href="/admin/shoes/add-boots"
							class="btn btn-success" style="margin-top: 10px"><i
							class="fas fa-plus"></i> Add boots</a>
						<h1 class="my-3"></h1>

						<table class="table">
							<thead class="thead-light">
								<tr>
									<th>Name</th>
									<th>Style</th>
									<th>Material</th>
									<th>Color</th>
									<th>Size</th>
									<th>Is shoelace</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody id="myTable">
								<c:forEach items="${boots }" var="boot">
									<tr>
										<td>${boot.name }</td>
										<td>${boot.style }</td>
										<td>${boot.material }</td>
										<td>${boot.color }</td>
										<td>${boot.size }</td>
										<td>${boot.isShoelace == true ? 'Yes' : 'No' }</td>
										<td><a href="/admin/edit-laptop/${book.id }"
											class="btn btn-primary">Edit <i class="fas fa-edit"></i></a>
											<a href="javascript:void(0);"
											onclick="Shop.deleteForm('modalDeleteForm', ${book.id }, '/rest/api/laptop/delete')"
											class="btn btn-danger">Delete <i class="fas fa-eraser"></i></a></td>
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