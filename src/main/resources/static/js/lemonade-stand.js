{
    $(document).ready(() => {
        console.log("hello");
        const stockRowsEl = $(".stock-row");
        console.log(stockRowsEl);

        for (let i = 0; i < stockRowsEl.length; i++) {
            stockRowsEl[i].addEventListener("click", function() {

            })
        }
        // stockRowsEl.(function () {
        //     this.addEventListener("click", function() {
        //         console.log("clicked");
        //     })
        // })
    })
}