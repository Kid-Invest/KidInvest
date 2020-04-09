{
    $(document).ready(()=> {
        const stockRowsEl = $(".stock-row");
        // const stockRowStatsEl = $(".owned-stock-stats");


            $(stockRowsEl).click(function(item){
                console.log(item);
                    $(this).next().toggle();
            });
            // $(stockRowEl).click(function(){
            //     $(stockRowEl).slideDown();
            // });


    })
}