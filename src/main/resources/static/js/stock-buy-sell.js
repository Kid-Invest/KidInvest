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
    });
}
