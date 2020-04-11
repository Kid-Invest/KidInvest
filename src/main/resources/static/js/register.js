{
    $(document).ready(()=> {
        console.log("here");
        const kidSpritesEl = $('.char-sprite');
        const charIdEl = $('#char-id');
        console.log(kidSpritesEl);
        $(charIdEl).val(1);



        for (let i = 0; i < kidSpritesEl.length; i++) {
            kidSpritesEl[i].addEventListener("click", function () {
                // toggle highlight around sprite
                kidSpritesEl[i].classList.toggle("active-img");
                removeActiveClass(i);
                // change value of input to character id
                console.log($(charIdEl));
                console.log($(charIdEl).val(i+1));
                console.log($(charIdEl).val());
            });
        }

        let removeActiveClass = (index) => {
            for (let i = 0; i < kidSpritesEl.length; i++) {
                if (i !== index) {
                    kidSpritesEl[i].classList.remove("active-img");
                }
            }
        }

    })
}