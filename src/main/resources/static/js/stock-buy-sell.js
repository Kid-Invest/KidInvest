{
    $(document).ready(() => {
        const subtractBtnEl = $("#subtract-btn")[0];
        const addBtnEl = $("#add-btn")[0];
        const currentStockEl = $("#currentStock");
        const currentTotalEl = $("#currentStock_total");
        const marketPriceEl = $("#marketPrice").html();
        const userBalance = $("#user-balance").html();

        const buyBtn = $("#buyBtn")[0];
        const sellBtn = $("#sellBtn")[0];
        const stockActionEl = $("#stockAction");
        const modalBuySellBtn = $("#modal-buy-sell-btn");
        const ownShares = $("#ownShares");
        let newCount = 0;

        $('#stock-tut-modal').modal('show')
        console.log("here");

        subtractBtnEl.addEventListener("click", function (){
            console.log(subtractBtnEl);
            newCount = parseInt(currentStockEl.val()) - 1;
            if (newCount >= 1){
                currentStockEl.val(newCount);
                currentTotalEl.val((newCount * parseFloat(marketPriceEl)).toFixed(2));
            }
        });
        addBtnEl.addEventListener("click", function (){
            newCount = parseInt(currentStockEl.val()) + 1;

            if (((Number.parseFloat(userBalance.split(",").join(""))  >= (newCount * marketPriceEl)) && (stockActionEl.val() === "buy"))) {
                currentStockEl.val(newCount);
                currentTotalEl.val((newCount * parseFloat(marketPriceEl)).toFixed(2));
            }
            if((newCount <= parseInt(ownShares.html())) && (stockActionEl.val() === "sell")){
                currentStockEl.val(newCount);
                currentTotalEl.val((newCount * parseFloat(marketPriceEl)).toFixed(2));

            }
        });

        buyBtn.addEventListener("click", function () {
            modalBuySellBtn.html("Buy");
            stockActionEl.val("buy");
        });
        sellBtn.addEventListener("click", function () {
            modalBuySellBtn.html("Sell");
            stockActionEl.val("sell");
        });
    });
}
