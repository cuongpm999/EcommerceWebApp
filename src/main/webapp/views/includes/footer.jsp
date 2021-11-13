<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- sử dụng taglibs của spring để bind-data từ end-point trả về. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- tích hợp jstl vào jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="fb-root"></div>
<script async defer crossorigin="anonymous"
	src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v8.0"
	nonce="ChmFo6ST"></script>

<!-- FOOTER -->
<div id="footer">
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<h5>CHÍNH HÃNG, UY TÍN, CHẤT LƯỢNG</h5>
				<ul>
					<li>
						<h4>ONLINE STORE</h4>
					</li>
					<li><a href="javascript:void(0);"><i
							class="fas fa-map-marker-alt"></i>&ensp;Address: PTIT, Hà Nội</a></li>
					<li><a href="javascript:void(0);"><i
							class="fas fa-envelope"></i>&ensp;Email:
							phamcuongth2000@gmail.com</a></li>
					<li><a href="javascript:void(0);"><i class="fas fa-phone"></i>&ensp;Mobile:
							0961656067</a></li>
				</ul>
			</div>
			<div class="col-md-3">
				<h5>SẢN PHẨM</h5>
				<ul>
					<li><a href="/book">Book</a></li>
					<li><a href="/clothes">Clothes</a></li>
					<li><a href="/electronics">Electronics</a></li>
					<li><a href="/shoes">Shoes</a></li>
				</ul>
			</div>

			<div class="col-md-4">
				<h5>KẾT NỐI VỚI CHÚNG TÔI</h5>
				<div class="fb-page"
					data-href="https://www.facebook.com/Computer-CuongPham-110156041221389"
					data-tabs="timeline" data-width="300" data-height="230"
					data-small-header="false" data-adapt-container-width="true"
					data-hide-cover="false" data-show-facepile="true">
					<blockquote
						cite="https://www.facebook.com/Computer-CuongPham-110156041221389"
						class="fb-xfbml-parse-ignore">
						<a
							href="https://www.facebook.com/Computer-CuongPham-110156041221389">Computer
							CuongPham</a>
					</blockquote>
				</div>

			</div>

			<hr>
			<div class="footer-copyright text-center py-3" style="width: 100%;">
				©
				<script>
					var now = new Date();
					document.write(now.getFullYear());
				</script>
				Copyright: <a href="https://www.facebook.com/cuongphamptit999/">
					CuongPham.com</a>
			</div>
		</div>
	</div>
</div>
<!-- ------ -->

<div id="toTop">
	<img src="/img/arrow5-up-512.png" id="onTop" />
</div>