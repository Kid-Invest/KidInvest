{
    $(document).ready(() => {
        const purchaseBtn = $(".purchase-btn");
        let totalCost = 0;
        console.log("hello");

        // Event listener for purchase buttons
        for (let i = 0; i < purchaseBtn.length; i++) {
            purchaseBtn[i].click(function () {
                let addonEl = $(`#${i}`);
                addonEl.val('true');
                console.log(addonEl);
                console.log(addonEl.val());
                //totalCost = parseFloat(addonPrice);
                //purchaseBtn.val(totalCost.toFixed(2));
            });
        }
    });
}
