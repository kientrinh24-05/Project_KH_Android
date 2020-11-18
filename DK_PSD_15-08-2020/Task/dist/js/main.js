const menu = {
  init: function() {
     this.clickshowmenu('.menu__main-hamburger','.menu__main-list','showmenu');
    this.clickshowmenu('#item .lastest__main-btn','#item .lastest__main-list','showMenu');
  },
  clickshowmenu :function(btn1,list_menu,togleclass){
    let button1 = document.querySelector(btn1);
    let nav = document.querySelector(list_menu);
    button1.addEventListener('click', () => {
      nav.classList.toggle(togleclass);
    });
  },
}
menu.init();






