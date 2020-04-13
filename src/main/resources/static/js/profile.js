{
    $(document).ready(()=> {
        const stockRowsEl = $(".stock-row");
        // const stockRowStatsEl = $(".owned-stock-stats");
        $('#portfolio-tut-modal').modal('show')

            $(stockRowsEl).click(function(item){
                console.log(item);
                    $(this).next().toggle();
            });
            // $(stockRowEl).click(function(){
            //     $(stockRowEl).slideDown();
            // });


    })
}