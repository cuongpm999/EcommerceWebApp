$(document).ready(function() {
	// jquery cho onTop
	$(document).scroll(function() {
		if ($(document).scrollTop() != 0) {
			$("#onTop").fadeIn();
		} else {
			$("#onTop").fadeOut();
		}
	});
	$("#onTop").click(function() {
		$("html, body").animate({ scrollTop: 0 }, 700);
	});

	// jquery cho sticky scroll
	$('#waypoint_here').waypoint(function(direction) {
		if (direction == "down") {
			$('.head-top').addClass('fixed-top');

			$('.head-top-row').addClass('head-top-row-justify-content');
			$('.item-logo').addClass('item-logo-display');
			$('.widget_search').addClass('widget_search-margin-top-text-align');
			$('.item-action').addClass('item-action-margin-top-justify-content-flex-start-padding');
			$('.taikhoan').addClass('d-flex-taikhoan-margin-right');
			$('.btn-all-item').addClass('btn-all-item-display');

		} else {
			$('.head-top').removeClass('fixed-top');

			$('.head-top-row').removeClass('head-top-row-justify-content');
			$('.item-logo').removeClass('item-logo-display');
			$('.widget_search').removeClass('widget_search-margin-top-text-align');
			$('.item-action').removeClass('item-action-margin-top-justify-content-flex-start-padding');
			$('.taikhoan').removeClass('d-flex-taikhoan-margin-right');
			$('.btn-all-item').removeClass('btn-all-item-display');

		}
	}, {
		offset: '700px'
	})

	$("#summernote").summernote({
		placeholder: 'Nội dung chi tiết',
		tabsize: 2,
		height: 300
	});

	$("#myInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#myTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});

	$("#searchNameLaptop").autocomplete({
		source: '/rest/api/data/autocomplete'
	});

	// slick-slider
	$('.your-class').slick({
		dots: true,
		infinite: true,
		speed: 500,
		fade: true,
		cssEase: 'linear'
	});

	$('.responsive').slick({
		dots: false,
		infinite: true,
		speed: 300,
		slidesToShow: 2,
		slidesToScroll: 2,
		responsive: [
			{
				breakpoint: 1024,
				settings: {
					slidesToShow: 2,
					slidesToScroll: 2,
					infinite: true,
					dots: false
				}
			},
			{
				breakpoint: 600,
				settings: {
					slidesToShow: 2,
					slidesToScroll: 2
				}
			},
			{
				breakpoint: 480,
				settings: {
					slidesToShow: 2,
					slidesToScroll: 2
				}
			}
			// You can unslick at a given breakpoint now by adding:
			// settings: "unslick"
			// instead of a settings object
		]
	});


	$('.slider-for').slick({
		slidesToShow: 1,
		slidesToScroll: 1,
		arrows: false,
		fade: true,
		asNavFor: '.slider-nav'
	});
	$('.slider-nav').slick({
		slidesToShow: 3,
		slidesToScroll: 1,
		asNavFor: '.slider-for',
		dots: false,
		centerMode: true,
		focusOnSelect: true,
		autoplay: true,
		autoplaySpeed: 2000,
	});
	/////////////////

});

var Shop = {

	addToCart: function(slug, category) {
		var data = {};
		data["slug"] = slug;
		data["category"] = category;

		$.ajax({
			url: "/rest/api/cart/addToCart",
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(data),

			dataType: "json",
			success: function(jsonResult) {
				if (jsonResult.status == "600") {
					alert("Bạn đã thêm hàng thành công");
					$("span.count-item").html(jsonResult.data);
				}
			}
		});
	},

	addToCartNow: function(slug, category) {
		var data = {};
		data["slug"] = slug;
		data["category"] = category;

		$.ajax({
			url: "/rest/api/cart/addToCart",
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(data),

			dataType: "json",
			success: function(jsonResult) {
				location.href = "/cart";
				$("span.count-item").html(jsonResult.data);
			}
		});
	},

	deleteCart: function(slug, category) {
		var flag = confirm("Bạn có chắc chắn muốn xóa sản phẩm này khỏi giỏ hàng?");
		if (flag == true) {
			var data = {};
			data["slug"] = slug;
			data["category"] = category;

			$.ajax({
				url: "/rest/api/cart/deleteCart",
				type: "post",
				contentType: "application/json",
				data: JSON.stringify(data),

				dataType: "json",
				success: function(jsonResult) {
					if (jsonResult.status == "500") {
						location.href = "/cart";
						$("span.count-item").html(jsonResult.data);
					}
				}
			});
		}
	},

	editCart: function(slug, category) {
		var quantity = $("#quantity" + slug).val();
		var data = {};
		data["quantity"] = quantity;
		data["slug"] = slug;
		data["category"] = category;


		$.ajax({
			url: "/rest/api/cart/editCart",
			type: "post",
			contentType: "application/json",
			data: JSON.stringify(data),

			dataType: "json",
			success: function(jsonResult) {
				if (jsonResult.status == "400") {
					$("span.count-item").html(jsonResult.data.val1);
					$("#price" + slug).html(jsonResult.data.val2 + "₫");
					$("#total_value").html(jsonResult.data.val3);
				}
			}
		});
	},

	deleteForm: function(entityId, restApi) {
		$("#deleteOk").click(function() {
			var data = {};
			data["entityId"] = entityId;
			$.ajax({
				url: restApi,
				type: "post",
				contentType: "application/json",
				data: JSON.stringify(data),

				dataType: "json",
				success: function(jsonResult) {
					if (jsonResult.status == "69") {
						window.location.reload();

					}
				}
			});
		});
	},

	goNext() {
		var tech = Shop.getUrlParameter('page') || 1;
		Shop.addUrlParameter('page', (parseInt(tech) + 1));
	},

	getUrlParameter: function(sParam) {
		var sPageURL = window.location.search.substring(1),
			sURLVariables = sPageURL.split('&'),
			sParameterName,
			i;

		for (i = 0; i < sURLVariables.length; i++) {
			sParameterName = sURLVariables[i].split('=');

			if (sParameterName[0] === sParam) {
				return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
			}
		}
	},

	goPrev() {
		var tech = Shop.getUrlParameter('page') || 1;
		if (parseInt(tech) > 1)
			Shop.addUrlParameter('page', (parseInt(tech) - 1));

	},

	addUrlParameter(name, value) {
		var searchParams = new URLSearchParams(window.location.search);
		searchParams.set(name, value);
		window.location.search = searchParams.toString();
	},

	deleteUrlParameter(name) {
		var searchParams = new URLSearchParams(window.location.search);
		searchParams.delete(name);
		window.location.search = searchParams.toString();
	}

}