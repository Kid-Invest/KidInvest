{
    $(document).ready(() => {
        const subtractBtnEl = $(".subtract-btn");
        const addBtnEl = $(".add-btn");
        const subtract10BtnEl = $(".subtract10-btn");
        const add10BtnEl = $(".add10-btn");
        let newCount = 0;
        let totalCost = 0;

        // Event listener for add and subtract buttons
        for (let i = 0; i < subtractBtnEl.length; i++) {
            subtractBtnEl[i].addEventListener("click", function () {
                let ingredientEl = $(`#${i}`);
                let totalCostEl = $(`#${i}_total`);
                let ingredientCost = $(`#${i}_cost`).html();
                if (ingredientEl.val() !== '0') {
                    newCount = parseInt(ingredientEl.val()) - 1;
                    $(ingredientEl).val(newCount);
                    totalCostEl.html(
                        (newCount * parseFloat(ingredientCost)).toFixed(2)
                    );
                    totalCost -= parseFloat(ingredientCost);
                    $("#total_purchase_cost").val(totalCost.toFixed(2));
                }
            });
            subtract10BtnEl[i].addEventListener("click", function () {
                let ingredientEl = $(`#${i}`);
                let totalCostEl = $(`#${i}_total`);
                let ingredientCost = $(`#${i}_cost`).html();
                if (parseInt(ingredientEl.val()) >= 10) {
                    newCount = parseInt(ingredientEl.val()) - 10;
                    $(ingredientEl).val(newCount);
                    totalCostEl.html(
                        (newCount * parseFloat(ingredientCost)).toFixed(2)
                    );
                    totalCost -= parseFloat(ingredientCost) * 10;
                    $("#total_purchase_cost").val(totalCost.toFixed(2));
                }
            });
            addBtnEl[i].addEventListener("click", function () {
                let ingredientEl = $(`#${i}`);
                let totalCostEl = $(`#${i}_total`);
                let ingredientCost = $(`#${i}_cost`).html();
                newCount = parseInt(ingredientEl.val()) + 1;
                $(ingredientEl).val(newCount);
                totalCostEl.html(
                    (newCount * parseFloat(ingredientCost)).toFixed(2)
                );
                totalCost += parseFloat(ingredientCost);
                $("#total_purchase_cost").val(totalCost.toFixed(2));
            });
            add10BtnEl[i].addEventListener("click", function () {
                let ingredientEl = $(`#${i}`);
                let totalCostEl = $(`#${i}_total`);
                let ingredientCost = $(`#${i}_cost`).html();
                newCount = parseInt(ingredientEl.val()) + 10;
                $(ingredientEl).val(newCount);
                totalCostEl.html(
                    (newCount * parseFloat(ingredientCost)).toFixed(2)
                );
                totalCost += parseFloat(ingredientCost) * 10;
                $("#total_purchase_cost").val(totalCost.toFixed(2));
            });
        }
    });
}
