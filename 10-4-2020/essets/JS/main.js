    /*----MENU-----*/
var menu = {
    init: function() {
        this.clickbtn();
        this.laki();

    },
    clickbtn: function() {
        var list_menu = document.querySelector('.list_menu');
        var btn_click = document.querySelector('.link_click');

        btn_click.addEventListener('click', function() {
            list_menu.classList.toggle('show')
        })

    },
    laki: function() {
        var section = document.querySelectorAll(".section");
        var sections = {};
        var i = 0;

        Array.prototype.forEach.call(section, function(e) {
            sections[e.id] = e.offsetTop;
        });

        window.onscroll = function() {
            var scrollPosition = document.documentElement.scrollTop || document.body.scrollTop;

            for (i in sections) {
                if (sections[i] <= scrollPosition) {
                    document.querySelector('.active').setAttribute('class', ' ');
                    document.querySelector('a[href*=' + i + ']').setAttribute('class', 'active');
                }
            }
        };
    },
}


menu.init();

//// MODAL
const Modalcontent = {
    init: function() {
        this.clickShowModal('.protfolio__overlay', '.wrapperOverlay', ' .wrapperOverlay .modal__content .modal__button a', '.wrapperOverlay .modal', '.wrapper');
    },
    clickShowModal: function(btnOpen, wrapperOverlay, buttonCloses, contents, wrapperWeb) {
        let btns = document.querySelectorAll(btnOpen);
        let overlay = document.querySelector(wrapperOverlay);
        let btnCloses = document.querySelectorAll(buttonCloses);
        let items = document.querySelectorAll(contents)
        let wrapper = document.querySelector(wrapperWeb);
        btns.forEach((btn, index) =>
            btn.addEventListener('click', () => {
                wrapper.classList.add('wrapper2');
                overlay.classList.add('activeOverlay');
                items[index].classList.add('active');
            })
        );
        btnCloses.forEach((btnclose, index) =>
            btnclose.addEventListener('click', () => {
                wrapper.classList.remove('wrapper2');
                overlay.classList.remove('activeOverlay');
                items[index].classList.remove('active');
            })
        );
    }
}

Modalcontent.init();