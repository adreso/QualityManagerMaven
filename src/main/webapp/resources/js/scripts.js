// Global
$(function() {
	if($(".main-sidebar").length) {
		$(".main-sidebar").niceScroll({
				cursoropacitymin: .1,
				cursoropacitymax: .8,
		});
		var sidebar_nicescroll = $(".main-sidebar").getNiceScroll();
	
		$(".main-sidebar .sidebar-menu li a.has-dropdown").on('click', function() {
			var me = $(this);

			me.parent().find('> .menu-dropdown').slideToggle(500, function() {
				sidebar_nicescroll.resize();
			});
			return false;
		});
	}

	$("[data-toggle='sidebar']").click(function() {
		var body = $("body");

		body.removeClass('search-show search-gone');
		if(body.hasClass('sidebar-gone')) {
			body.removeClass('sidebar-gone');
			body.addClass('sidebar-show');
			sidebar_nicescroll.resize();
		}else{
			body.addClass('sidebar-gone');
			body.removeClass('sidebar-show');
			sidebar_nicescroll.resize();
		}
		return false;
	});

});