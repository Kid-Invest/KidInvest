{
    $(document).ready(() => {
        let disable = function () {
            let hiddenInputEl = $(`#${i}`);
            if(hiddenInputEl.val() === "true"){
                $(this).prop("disabled", true).html("Purchased");
            }
        }

        const purchaseBtnEl = $(".purchase-btn");
        // Event listener for purchase buttons
        for (let i = 0; i < purchaseBtnEl.length; i++) {
            purchaseBtnEl[i].addEventListener("click", function() {
                let hiddenInputEl = $(`#${i}`);
                hiddenInputEl.val("true");

            })
        }
    });
}
