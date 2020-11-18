
$('.crafting__product').isotope({
  itemSelector: '.crafting__product-item',

});
$('.crafting__main__list li').click(function() {
  var selector = $(this).attr('data-filter');
  $('.crafting__product').isotope({
      filter: selector
  });
  return false;
});
 

document.addEventListener("DOMContentLoaded" , function(){
    var trangthai = 'duoi11';
    var add = document.querySelector('.degital__main__block ');
    var adx = document.querySelector('.ap');
    
 
    window.addEventListener('scroll',function(){

        if (window.pageYOffset>=  1300) {
          if (trangthai=='duoi11') {
              trangthai == 'tren11';
              add.classList.add('ax');
              adx.classList.add('amn2');    
          }

        }


    })

})
// scroll 
 document.addEventListener("DOMContentLoaded",function(){
      var btn  = document.querySelector('.adp1');
      var btn1  = document.querySelector('.adp2');
      var btn2  = document.querySelector('.adp3');
      var location ='dui100'
       

        window.addEventListener('scroll',function(){
            if (window.pageYOffset>2200) {
              if (location=='dui100') {
                    location == 'tren100';
                    btn.classList.add('ccxs');
                    btn1.classList.add('ccxs1');
                    btn2.classList.add('ccxs2');
              }
              
            }
        })
 })

/// Menu 
document.addEventListener("DOMContentLoaded",function(){
  var btn = document.querySelector('.header__top__hambuger');
  var menu = document.querySelector('.header__top_list_1');
  var over = document.querySelector('.over_lay');
 btn.onclick=function(){
   menu.classList.toggle('show_menu');
   over.classList.toggle('show1');
 }
})

// item
// const item1 = {
//   init : function()  {
//       this.clickshowitem('#item-1','#item-1-1','sx' );
//       this.clickshowitem('#item-2','#item-2-2','sx' );
//       this.clickshowitem('#item-3','#item-3-3','sx' );


//   },
//   clickshowitem(btn1,item1,togleclass) {
//       var  button1 = document.querySelector(btn1);
//       var doituong21= document.querySelector(item1);

//       button1.addEventListener('click' , () =>{
//         doituong21.classList.toggle(togleclass);
//       })
//   }
// }
// item1.init();

