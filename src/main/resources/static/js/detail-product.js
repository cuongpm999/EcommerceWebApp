$(document).ready(function () {
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
        centerMode: true,
        focusOnSelect: true
      })

      $('#show1').click(function(){
          $('#detail').css({height: "auto"})
      })
      $('#show2').click(function(){
        $('#tableID').css({height: "auto"})
    })
});