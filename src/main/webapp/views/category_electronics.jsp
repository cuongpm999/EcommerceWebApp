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
<link rel="stylesheet" type="text/css" href="/css/category.css">
<!-- --- -->

<title>BookShop</title>
</head>

<body>
	<!-- HEADER -->
	<%@ include file="/views/includes/header.jsp"%>
	<!-- ------ -->
	
	<!-- MAIN -->
    <div id="main" class="container all-item">
        <h4 class="tieude-tp">LAPTOP</h4>
        <div class="loc-sp">
            <span class="title-x">LỌC SẢN PHẨM</span>
            <div class="danh-muc">
                <span class="title">DANH MỤC</span>
                <ul class="list-unstyled">
                    <li><a href="/shop-all-item/${laptopManufacturer_.seo }/?page=1"><i
                                class="fas fa-angle-double-right"></i> HP</a></li>
                    <li><a href="/shop-all-item/${laptopManufacturer_.seo }/?page=1"><i
                                class="fas fa-angle-double-right"></i> Dell</a></li>
                    <li><a href="/shop-all-item/${laptopManufacturer_.seo }/?page=1"><i
                                class="fas fa-angle-double-right"></i> Apple</a></li>
                    <li><a href="/shop-all-item/${laptopManufacturer_.seo }/?page=1"><i
                                class="fas fa-angle-double-right"></i> Lenovo</a></li>
                    <li><a href="/shop-all-item/${laptopManufacturer_.seo }/?page=1"><i
                                class="fas fa-angle-double-right"></i> Asus</a></li>
                </ul>
            </div>
            <div class="khoang-gia">
                <span class="title">KHOẢNG GIÁ</span>
                <ul class="list-unstyled">
                    <c:choose>
                        <c:when test="${empty price }">
                            <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('price', 'duoi20trieu')"><i
                                        class="far fa-square"></i> Dưới 20 triệu</a></li>
                            <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('price', '20den30trieu')"><i
                                        class="far fa-square"></i> 20 triệu - 30 triệu</a></li>
                            <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('price', '30den40trieu')"><i
                                        class="far fa-square"></i> 30 triệu - 40 triệu</a></li>
                            <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('price', '40den50trieu')"><i
                                        class="far fa-square"></i> 40 triệu - 50 triệu </a></li>
                            <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('price', 'tren50trieu')"><i
                                        class="far fa-square"></i> Trên 50 triệu</a></li>
                        </c:when>

                    </c:choose>
                </ul>
            </div>
            <div class="cpu">
                <span class="title">CPU</span>
                <ul class="list-unstyled">
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('cpu', 'i3')"><i
                                class="far fa-square"></i> Intel Core i3</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('cpu', 'i5')"><i
                                class="far fa-square"></i> Intel Core i5</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('cpu', 'i7')"><i
                                class="far fa-square"></i> Intel Core i7</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('cpu', 'i9')"><i
                                class="far fa-square"></i> Intel Core i9</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('cpu', 'amd ryzen 3')"><i
                                class="far fa-square"></i> AMD Ryzen 3 </a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('cpu', 'amd ryzen 5')"><i
                                class="far fa-square"></i> AMD Ryzen 5</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('cpu', 'amd ryzen 7')"><i
                                class="far fa-square"></i> AMD Ryzen 7 </a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('cpu', 'amd ryzen 9')"><i
                                class="far fa-square"></i> AMD Ryzen 9 </a></li>
                </ul>
            </div>
            <div id="waypoint_here" class="ram">
                <span class="title">RAM</span>
                <ul class="list-unstyled">
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('ram', '4gb')"><i
                                class="far fa-square"></i> 4GB</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('ram', '8gb')"><i
                                class="far fa-square"></i> 8GB</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('ram', '16gb')"><i
                                class="far fa-square"></i> 16GB</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('ram', '32gb')"><i
                                class="far fa-square"></i> 32GB</a></li>
                </ul>
            </div>

            <div class="o-cung">
                <span class="title">Ổ CỨNG</span>
                <ul class="list-unstyled">
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('oCung', 'ssd')"><i
                                class="far fa-square"></i> SSD</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('oCung', 'hhd')"><i
                                class="far fa-square"></i> HDD</a></li>
                </ul>
            </div>

            <div class="vga">
                <span class="title">VGA</span>
                <ul class="list-unstyled">
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('vga', 'nvidia')"><i
                                class="far fa-square"></i> NVIDIA</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('vga', 'amd')"><i
                                class="far fa-square"></i> AMD</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('vga', 'onboard')"><i
                                class="far fa-square"></i> Onboard</a></li>
                </ul>
            </div>

            <div class="man-hinh">
                <span class="title">KÍCH THƯỚC MÀN HÌNH</span>
                <ul class="list-unstyled">
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('manHinh', '12.3')"><i
                                class="far fa-square"></i> 12.3 inch</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('manHinh', '12.5')"><i
                                class="far fa-square"></i> 12.5 inch</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('manHinh', '13.3')"><i
                                class="far fa-square"></i> 13.3 inch</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('manHinh', '13')"><i
                                class="far fa-square"></i> 13 inch</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('manHinh', '14')"><i
                                class="far fa-square"></i> 14 inch</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('manHinh', '15.4')"><i
                                class="far fa-square"></i> 15.4 inch</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('manHinh', '15.6')"><i
                                class="far fa-square"></i> 15.6 inch</a></li>
                    <li><a href="javascript:void(0);" onclick="Shop.addUrlParameter('manHinh', '17.3')"><i
                                class="far fa-square"></i> 17.3 inch</a></li>
                </ul>
            </div>
        </div>

        <div class="product-sp">
            <div class="product-list">
                <div class="list-sort">
                    <select id="sort-select" onchange="Shop.addUrlParameter('sort', this.value)">
                        <option value="">Sắp xếp sản phẩm</option>
                        <option value="low-to-high">Giá
                            tăng dần</option>
                        <option value="high-to-low">Giá
                            giảm dần</option>
                    </select>
                    
                </div>

                <div class="list-book">
                    <div class="row">
                        <div class="col-md-3">
                            <div style="text-align: center;"><a href="#"><img src="/img/book.jpg" alt="product"></a></div>
                            <div class="infor" style="text-align: center;">
                                <a href="#">
                                    <h6>Cân bằng cảm xúc</h6>
                                </a>
                                <div class="gia-goc">
                                    <p class="gia-chinh">200.000 Đ</p>
                                    <p class="khuyen-mai">(Tiết kiệm: 7%)</p>
                                </div>
                                <h6 class="gia-ban">26.599.000 Đ</h6>
                                <a href="#"><i class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
                            </div>
                        </div>
                    </div>
                </div>
 
                <div class="list-sort" style="margin-top: 3rem;">

                    <div class="paging mx-auto">
                        <a href="javascript:Shop.goPrev()">Previous</a> <a href="javascript:void(0);"
                            onclick="Shop.addUrlParameter('page', 1)">1</a> <a href="javascript:void(0);"
                            onclick="Shop.addUrlParameter('page', 2)">2</a> <a href="javascript:void(0);"
                            onclick="Shop.addUrlParameter('page', 3)">3</a> <a class="pa4" href="javascript:void(0);"
                            onclick="Shop.addUrlParameter('page', 4)">4</a> <a class="pa5" href="javascript:void(0);"
                            onclick="Shop.addUrlParameter('page', 5)">5</a>
                        <a href="javascript:Shop.goNext()">Next</a>
                    </div>
                </div>


            </div>
        </div>

    </div>
    <div class="clear-with-height"></div>
    <!-- --- -->
    
    <!-- FOOTER -->
	<%@ include file="/views/includes/footer.jsp"%>
	<!-- ------ -->


</body>

</html>
	