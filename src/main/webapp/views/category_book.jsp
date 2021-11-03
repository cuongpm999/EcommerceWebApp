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
<link rel="stylesheet" type="text/css" href="/css/danh_muc.css">

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

<title>PTTK Project</title>
</head>

<body>

	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v8.0"
		nonce="ChmFo6ST"></script>

	<!-- HEADER -->
	<div id='header'></div>
	<!-- ------ -->

	<!-- MAIN -->
	<div id="main" class="container all-item">
		<h4 class="tieude-tp">Sách</h4>
		<div class="loc-sp">
			<span class="title-x">LỌC SẢN PHẨM</span>
			<div class="danh-muc">
				<span class="title">TÁC GIẢ</span>
				<ul class="list-unstyled">
					<c:forEach var="author" items="${authors }" varStatus="loop">
						<c:if test="${loop.index < 4 }">
							<li><a href="#"><i class="fas fa-angle-double-right"></i>
									${author.name }</a></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<div class="khoang-gia">
				<span class="title">KHOẢNG GIÁ</span>
				<ul class="list-unstyled">
					<%-- <c:choose>
                        <c:when test="${empty price }"> --%>
					<li><a href="javascript:void(0);"
						onclick="Shop.addUrlParameter('price', 'duoi10trieu')"><i
							class="far fa-square"></i> Dưới 100.000₫</a></li>
					<li><a href="javascript:void(0);"
						onclick="Shop.addUrlParameter('price', '10den20trieu')"><i
							class="far fa-square"></i> Từ 100.000₫ đến 200.000₫</a></li>
					<li><a href="javascript:void(0);"
						onclick="Shop.addUrlParameter('price', 'tren50trieu')"><i
							class="far fa-square"></i> Trên 200.000₫</a></li>
					<%--  </c:when>

                    </c:choose> --%>
				</ul>
			</div>
			<div class="cpu">
				<span class="title">NHÀ XUẤT BẢN</span>
				<ul class="list-unstyled">
					<c:forEach var="publisher" items="${publishers }" varStatus="loop">
						<c:if test="${loop.index < 4 }">
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('cpu', 'i3')"><i
									class="far fa-square"></i> ${publisher.name }</a></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<div class="cpu">
				<span class="title">NHÀ XUẤT BẢN</span>
				<ul class="list-unstyled">
					<c:forEach var="publisher" items="${publishers }" varStatus="loop">
						<c:if test="${loop.index < 4 }">
							<li><a href="javascript:void(0);"
								onclick="Shop.addUrlParameter('cpu', 'i3')"><i
									class="far fa-square"></i> ${publisher.name }</a></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div class="product-sp">
			<div class="product-list">
				<div class="list-sort">
					<select id="sort-select"
						onchange="Shop.addUrlParameter('sort', this.value)">
						<option value="">Sắp xếp sản phẩm</option>
						<option value="low-to-high">Giá tăng dần</option>
						<option value="high-to-low">Giá giảm dần</option>
					</select>

				</div>

				<div class="list-book">
					<div class="row">
						<c:forEach var="bookItem" items="${bookItems }">
							<div class="col-md-3">
								<div style="text-align: center;">
									<a href="#"><img
										src="/files_item/${bookItem.imgBookItems.get(0).name }"
										alt="product"></a>
								</div>
								<div class="infor" style="text-align: center;">
									<a href="">
										<h6>${bookItem.book.title }</h6>
									</a>
									<c:choose>
										<c:when test="${bookItem.discount > 0}">
											<div class="gia-goc">
												<p class="gia-chinh">${bookItem.price }Đ</p>
												<p class="khuyen-mai">(Tiết kiệm: ${bookItem.discount}%)</p>
											</div>
										</c:when>
									</c:choose>
									<h6 class="gia-ban">${bookItem.price*(100-bookItem.discount)/100 }</h6>
									<a href="buy?id=${product.id }"><i
										class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
								</div>
							</div>

						</c:forEach>
					</div>
				</div>

				<div class="list-sort" style="margin-top: 3rem;">

					<div class="paging mx-auto">
						<a href="javascript:Shop.goPrev()">Previous</a> <a
							href="javascript:void(0);"
							onclick="Shop.addUrlParameter('page', 1)">1</a> <a
							href="javascript:void(0);"
							onclick="Shop.addUrlParameter('page', 2)">2</a> <a
							href="javascript:void(0);"
							onclick="Shop.addUrlParameter('page', 3)">3</a> <a class="pa4"
							href="javascript:void(0);"
							onclick="Shop.addUrlParameter('page', 4)">4</a> <a class="pa5"
							href="javascript:void(0);"
							onclick="Shop.addUrlParameter('page', 5)">5</a> <a
							href="javascript:Shop.goNext()">Next</a>
					</div>
				</div>


			</div>
		</div>

	</div>
	<div class="clear-with-height"></div>
	<!-- --- -->

	<!--  FOOTER -->
	<div id="footer"></div>
	<!-- ------- -->

</body>


</html>
