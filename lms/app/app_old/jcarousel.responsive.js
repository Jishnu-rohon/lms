(function($) {
    $(function() {
        var jcarousel = $('.jcarousel');

        jcarousel
            .on('jcarousel:reload jcarousel:create', function () {
                var width = jcarousel.innerWidth();

                if (width >= 600) {
                    width = width / 5;
                } else if (width >= 350) {
                    width = width / 2;
                }

                jcarousel.jcarousel('items').css('width', width + 'px');
            })
            .jcarousel({
                wrap: 'circular'
            });

        $('.jcarousel-control-prev')
            .jcarouselControl({
                target: '-=1'
            });

        $('.jcarousel-control-next')
            .jcarouselControl({
                target: '+=1'
            });
	
		jQuery('.jcarousel').jcarouselAutoscroll({
        autostart: true
   });
    });
})(jQuery);

/*** slider 2 ***/
(function($) {
    $(function() {
        var jcarousel = $('.jcarousel2');

        jcarousel
            .on('jcarousel:reload jcarousel:create', function () {
                var width = jcarousel.innerWidth();

                if (width >= 600) {
                    width = width / 5;
                } else if (width >= 350) {
                    width = width / 2;
                }

                jcarousel.jcarousel('items').css('width', width + 'px');
            })
            .jcarousel({
                wrap: 'circular'
            });

        $('.jcarousel2-control-prev')
            .jcarouselControl({
                target: '-=1'
            });

        $('.jcarousel2-control-next')
            .jcarouselControl({
                target: '+=1'
            });
	
		jQuery('.jcarousel2').jcarouselAutoscroll({
        autostart: true
   });
    });
})(jQuery);
/*** slider 2// ***/

/*** slider 3 ***/
(function($) {
    $(function() {
        var jcarousel = $('.jcarousel3');

        jcarousel
            .on('jcarousel:reload jcarousel:create', function () {
                var width = jcarousel.innerWidth();

                if (width >= 1024) {
                    width = width / 4;
                } 
				
				else if (width >= 700) {
                    width = width / 2;
                }
				
				else if (width <= 699) {
                    width = width / 1;
                }
				else if (width >= 350) {
                    width = width / 1;
                }

                jcarousel.jcarousel('items').css('width', width + 'px');
            })
            .jcarousel({
                wrap: 'circular'
            });

        $('.jcarousel3-control-prev')
            .jcarouselControl({
                target: '-=1'
            });

        $('.jcarousel3-control-next')
            .jcarouselControl({
                target: '+=1'
            });
	
		jQuery('.jcarousel3').jcarouselAutoscroll({
        autostart: true
   });
    });
})(jQuery);
/*** slider 3// ***/