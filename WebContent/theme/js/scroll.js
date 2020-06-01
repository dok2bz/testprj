

// ====================================================
                        // ANIMATION
// ====================================================
	$(function () {
	    // animate on scroll
	    new WOW().init();
	});

// ====================================================
                        // NAVIGATION
// ====================================================
	$(function(){
		$(".scroll").click(function(e){
		var destination = $(this).attr('href');
		e.preventDefault();
		$('html,body').animate({
		scrollTop:$(destination).offset().top},750);
		});
		});
		$('#mainNav ul li a').on('click',function(){
		$(this).addClass('active');
		$(this).parent().siblings().find('a').removeClass('active');
		});	