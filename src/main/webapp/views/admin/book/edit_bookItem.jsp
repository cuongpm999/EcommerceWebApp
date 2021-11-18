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
<!-- CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/fontawesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/shop_home.css">
<link rel="stylesheet" type="text/css" href="/css/manage.css">

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
						<%-- <c:choose>
								<c:when test="${status=='success'}">
									<div class="alert alert-success">
										<strong>Success!</strong> Bạn đã thêm thành công!
									</div>
								</c:when>
								<c:when test="${status=='faile'}">
									<div class="alert alert-danger">
										<strong>Faile!</strong> Bạn đã thêm thất bại!

									</div>
								</c:when>
							</c:choose> --%>

						<div class="card-body">
							<div class="panel-body">
								<form:form modelAttribute="bookItem"
									action="/admin/edit-book-item" method="post">
									<form:hidden path="barCode" />
									<form:hidden path="slug" />
									<form:hidden path="book.id" />
									<div class="form-group">
										<label class="required">Price:</label>
										<form:input path="price" class="form-control" />
									</div>
									<div class="form-group">
										<label>Discount:</label>
										<form:input path="discount" class="form-control" />
									</div>
									<button type="submit" class="btn btn-success">
										<i class="fas fa-download"></i> Save
									</button>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/views/admin/footer_admin.jsp"%>
	</div>
	</div>
	<!-- --- -->

</body>


</html>