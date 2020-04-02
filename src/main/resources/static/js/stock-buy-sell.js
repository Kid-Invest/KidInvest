{
    $(document).ready(() => {
        const subtractBtnEl = $(".subtract-btn");
        const addBtnEl = $(".add-btn");
        let newCount = 0;
        let totalCost = 0;

        // Event listener for add and subtract buttons
        for (let i = 0; i < subtractBtnEl.length; i++) {
            subtractBtnEl[i].addEventListener("click", function () {
                let stockEl = $(`#${i}`);
                let totalCostEl = $(`#${i}_total`);
                let stockCost = $(`#${i}_cost`).html();
                if (stockEl.val() !== '0') {
                    newCount = parseInt(stockEl.val()) - 1;
                    $(stockEl).val(newCount);
                    totalCostEl.html(
                        (newCount * parseFloat(stockCost)).toFixed(2)
                    );
                    totalCost -= parseFloat(stockCost);
                    $(".total_purchase_cost").val(totalCost.toFixed(2));
                }
            });
            addBtnEl[i].addEventListener("click", function () {
                let stockEl = $(`#${i}`);
                let totalCostEl = $(`#${i}_total`);
                let stockCost = $(`#${i}_cost`).html();
                newCount = parseInt(stockEl.val()) + 1;
                $(stockEl).val(newCount);
                totalCostEl.html(
                    (newCount * parseFloat(stockCost)).toFixed(2)
                );
                totalCost += parseFloat(stockCost);
                $(".total_purchase_cost").val(totalCost.toFixed(2));
            });
        }
    });
}
