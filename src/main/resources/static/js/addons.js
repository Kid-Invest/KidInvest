{
    $(document).ready(() => {
        const purchaseBtn = $(".purchase-btn");
        let totalCost = 0;

        // Event listener for purchase buttons
        for (let i = 0; i < purchaseBtn.length; i++) {
            purchaseBtn[i].click(function () {
                let addonID = $(`#${i}`);
                let totalCostEl = $(`#${i}_total`);
                let addonCost = $(`#${i}_cost`).html();
                if (addonEl.val() < '1') {
                    newCount = parseInt(addonEl.val()) + 1;
                    $(addonEl).val(newCount);
                    totalCostEl.html(
                        (newCount * parseFloat(addonCost)).toFixed(2)
                    );
                    totalCost += parseFloat(addonCost);
                    $("#total_purchase_cost").val(totalCost.toFixed(2));
                }
            });
        }
    });
}
