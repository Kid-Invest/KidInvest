{
    $(document).ready(() => {
        const purchaseBtn = $(".purchase-btn");
        let totalCost = 0;

        // Event listener for purchase buttons
        for (let i = 0; i < purchaseBtn.length; i++) {
            purchaseBtn[i].click(function () {
                let addonPrice = $(`#${i}`);
                // let totalCostEl = $(`#${i}_total`);
                //let addonCost = $(`#${i}_cost`).html();
                let totalPurchaseCost = $(`#purchase_cost_${i}`);

                    // totalPurchaseCost.html(
                    //     (parseFloat(addonCost)).toFixed(2)
                    // );
                    totalCost += parseFloat(addonCost);
                    totalPurchaseCost.val(totalCost.toFixed(2));
            });
        }
    });
}
