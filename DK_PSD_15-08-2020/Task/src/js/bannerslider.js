$('.banner_slider').owlCarousel({
    loop:true,
    margin:0,
    responsiveClass:true,
    autoplay: true,
    autoplayTimeout: 2000,
    // nav:true;
    responsive:{
        0:{
            items:1,
            
        },
        600:{
            items:1,
           
        },
        1000:{
            items:1,
        
            loop:true,
        }
    }
})