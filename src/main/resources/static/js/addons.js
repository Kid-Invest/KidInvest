{
    $(document).ready(() => {
        const subtractBtnEl = $(".subtract-btn");
        const addBtnEl = $(".add-btn");
        let newCount = 0;
        let totalCost = 0;

        // Event listener for add and subtract buttons
        for (let i = 0; i < subtractBtnEl.length; i++) {
            subtractBtnEl[i].addEventListener("click", function () {
                let addonEl = $(`#${i}`);
                let totalCostEl = $(`#${i}_total`);
                let addonPrice = $(`#${i}_price`).html();
                if (addonEl.val() !== '0') {
                    newCount = parseInt(addonEl.val()) - 1;
                    $(addonEl).val(newCount);
                    totalCostEl.html(
                        (newCount * parseFloat(addonPrice)).toFixed(2)
                    );
                    totalCost -= parseFloat(addonPrice);
                    $("#total_purchase_cost").html(totalCost.toFixed(2));
                }
            });
            addBtnEl[i].addEventListener("click", function () {
                let addonEl = $(`#${i}`);
                let totalCostEl = $(`#${i}_total`);
                let addonPrice = $(`#${i}_price`).html();
                newCount = parseInt(addonEl.val()) + 1;
                $(addonEl).val(newCount);
                totalCostEl.html(
                    (newCount * parseFloat(addonPrice)).toFixed(2)
                );
                totalCost += parseFloat(addonPrice);
                $("#total_purchase_cost").html(totalCost.toFixed(2));
            });
        }
    });
}
