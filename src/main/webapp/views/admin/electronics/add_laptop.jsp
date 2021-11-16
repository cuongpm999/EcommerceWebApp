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
								<form:form modelAttribute="laptop"
									action="/admin/electronics/add-laptop">
									<div class="form-group">
										<label class="required" for="txtInput">Manufacturer:</label>
										<form:select class="form-control" path="manufacturer.id">
											<form:options items="${manufacturers}" itemValue="id"
												itemLabel="name" />
										</form:select>
									</div>
									<div class="form-group">
										<label class="required">Name:</label>
										<form:input path="name" class="form-control" />
									</div>
									<div class="form-group">
										<label class="required">Cpu:</label>
										<form:input path="cpu" class="form-control" />
									</div>
									<div class="form-group">
										<label class="required">Ram:</label>
										<form:input path="ram" class="form-control" />
									</div>
									<div class="form-group">
										<label class="required">Card:</label>
										<form:input path="card" class="form-control" />
									</div>
									<div class="form-group">
										<label class="required">Hard drive:</label>
										<form:input path="hardDrive" class="form-control" />
									</div>
									<div class="form-group">
										<label class="required">Screend size:</label>
										<form:input path="screendSize" class="form-control" />
									</div>
									<div class="form-group">
										<label class="required">Warranty:</label>
										<form:input path="warranty" class="form-control" />
									</div>
									<div class="form-group">
										<label class="required">Specifications:</label>
										<form:textarea path="specifications" class="form-control"
											rows="5" id="summernote"></form:textarea>
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