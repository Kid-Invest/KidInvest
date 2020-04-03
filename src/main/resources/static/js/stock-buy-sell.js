{
    $(document).ready(() => {
        const subtractBtnEl = $("#subtract-btn")[0];
        const addBtnEl = $("#add-btn")[0];
        const currentStockEl = $("#currentStock");
        const currentTotalEl = $("#currentStock_total");
        const marketPriceEl = $("#marketPrice").html();
        const userBalance = $("#user-balance").html();
        let newCount = 0;
        let totalCost = 0;
        console.log(subtractBtnEl);
        console.log(currentStockEl.val());
        console.log(currentTotalEl);
        console.log(userBalance);
        console.log(marketPriceEl);

        subtractBtnEl.addEventListener("click", function (){
            console.log(subtractBtnEl);
            newCount = parseInt(currentStockEl.val()) - 1;
            if (newCount >= 1){
                currentStockEl.val(newCount);
                currentTotalEl.html((newCount * parseFloat(marketPriceEl)).toFixed(2));
            }
        });
        addBtnEl.addEventListener("click", function (){
            newCount = parseInt(currentStockEl.val()) + 1;
            if (userBalance >= (newCount * marketPriceEl)) {
                currentStockEl.val(newCount);
                currentTotalEl.html((newCount * parseFloat(marketPriceEl)).toFixed(2));
            }
        });


        // Event listener for add and subtract buttons
    //         subtractBtnEl[i].addEventListener("click", function () {
    //             let stockEl = $(`#${i}`);
    //             let totalCostEl = $(`#${i}_total`);
    //             let stockCost = $(`#${i}_cost`).html();
    //             if (stockEl.val() !== '0') {
    //                 newCount = parseInt(stockEl.val()) - 1;
    //                 $(stockEl).val(newCount);
    //                 totalCostEl.html(
    //                     (newCount * parseFloat(stockCost)).toFixed(2)
    //                 );
    //                 totalCost -= parseFloat(stockCost);
    //                 $("#total_purchase_cost").val(totalCost.toFixed(2));
    //             }
    //         });
    //         addBtnEl[i].addEventListener("click", function () {
    //             let stockEl = $(`#${i}`);
    //             let totalCostEl = $(`#${i}_total`);
    //             let stockCost = $(`#${i}_cost`).html();
    //             newCount = parseInt(stockEl.val()) + 1;
    //             $(stockEl).val(newCount);
    //             totalCostEl.html(
    //                 (newCount * parseFloat(stockCost)).toFixed(2)
    //             );
    //             totalCost += parseFloat(stockCost);
    //             $("#total_purchase_cost").val(totalCost.toFixed(2));
    //         });
    //
    });
}
