document.addEventListener("DOMContentLoaded",function(){
    var trangthai ='duoi500';
    var noi = 'ngayday';
    var menu = document.querySelector('.header_top');
    var about = document.querySelector('.about_top');   
    var vitri = about.offsetTop;
    var loadx = document.querySelectorAll('.block_ourteam');
    console.log(loadx);
    
        window.addEventListener('scroll',function(){
         if(window.pageYOffset>300){
             if(trangthai == 'duoi500'){
                
                 trangthai= 'tren500';
                 menu.classList.add('bg');
             }
         }
         else if(window.pageYOffset<=300){
                if (trangthai=='tren500') {
                    menu.classList.remove('bg');
                    trangthai='duoi500';
                }
         }

         if (window.pageYOffset>vitri) {
             if(noi == 'ngayday'){
                noi = 'dangshow';
                 about.classList.add('op');
               
             }
         }
         else if (window.pageYOffset<vitri){
             if(noi =='dangshow'){
                noi = 'ngayday';
                 about.classList.remove('op');
               
             }
         }
    })


})

