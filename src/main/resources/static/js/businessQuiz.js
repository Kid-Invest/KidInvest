{

    let businessQuestions = [{
        question: "1. A transaction is",
        choices: [" a. When you buy something", " b.  A list of the items you have available to sell", " c. When you sell something", " d. Both a and c"],
        correctAnswer: 3
    }, {
        question: "2. You can make a profit by doing which of the following?",
        choices: [" a. Selling your lemonades for more than the cost of ingredients", " b. Buying low and selling high", " c. Increasing your business popularity and lemonade prices", " d. All of the above"],
        correctAnswer: 3
    }, {
        question: "3. Inventory is a complete list of the items you have available to make and sell a product.",
        choices: [" a. True", " b. False"],
        correctAnswer: 0
    }, {
        question: "4. What is your account balance?",
        choices: [" a. The amount of money you have after subtracting all your business and stock earnings and adding all your purchases", " b. The amount of money you have after adding all your business and stock earnings and subtracting all your purchases", " c. A complete list of the items you have available to make lemonades", " d. A grouping of your stock and business profits"],
        correctAnswer: 1
    }, {
        question: "5. Purchasing addons will do which of the following?",
        choices: [" a. Increase your popularity", " b. Increase your account balance", " c. Decrease your popularity", " d. Increase your stock investments"],
        correctAnswer: 0
    }];

    //defaults and buckets
    let resultArray = [];
    let currentQuestion = 0;
    let correctAnswers = 0;
    let quizOver = false;
    let resultsSent = false;

    $(document).ready(function () {

        // Display the first question
        displayCurrentQuestion();
        $(this).find(".quizMessage").hide();
        $(document).find("#formSubmit").hide();

        // On clicking next, display the next question
        $(this).find(".nextButton").on("click", function () {
            if (!quizOver) {

                //stores user answer
                value = $("input[type='radio']:checked").val();

                if (value == undefined) {
                    //prompts user for an answer if they haven't selected an answer
                    $(document).find(".quizMessage").text("Please select an answer");
                    $(document).find(".quizMessage").show();
                } else {
                    // hides message if they have now answered
                    $(document).find(".quizMessage").hide();

                    if (value == businessQuestions[currentQuestion].correctAnswer) {
                        correctAnswers++;
                    }

                    //holds user answer and can be compared correct/incorrect later
                    let resultObject = {
                        question: businessQuestions[currentQuestion].question,
                        choices: businessQuestions[currentQuestion].choices,
                        correctAnswer: businessQuestions[currentQuestion].correctAnswer,
                        userAnswer: value
                    };
                    resultArray.push(resultObject);

                    currentQuestion++; // moves to next question
                    if (currentQuestion < (businessQuestions.length - 1)) {
                        displayCurrentQuestion();
                    } else if(currentQuestion === (businessQuestions.length - 1)){
                        //last question button display changes to "submit"
                        displayCurrentQuestion();
                        $(document).find(".nextButton").text("Submit");
                    }
                    else {
                        // Quiz is now over
                        $(document).find(".nextButton").html("Display Results");

                        $(document).find(".quizContainer > .question").hide();
                        $(document).find(".quizContainer > .choiceList").hide();
                        displayScore();
                        quizOver = true;
                    }
                }
            }
            else { // quizOver = true;
                displayResults();
                // quiz is over Need to lock out of quiz and only show results
                $(document).find(".nextButton").hide();
                if(!resultsSent){
                    $(document).find("#formSubmit").show();

                    //onclick, results are sent to balance
                    $('.viewResultsBtn').on("click", function(){
                        $('#quiz_result').val(correctAnswers * 500);
                        resultsSent = true;
                        quizOver = true;
                    });
                } else {
                    $(document).find("#formSubmit").hide();
                }
            }
        });
    });

    // This displays the current question AND the choices
    function displayCurrentQuestion() {
        let question = businessQuestions[currentQuestion].question;
        let questionClass = $(document).find(".quizContainer > .question");
        let choiceList = $(document).find(".quizContainer > .choiceList");
        let numChoices = businessQuestions[currentQuestion].choices.length;
        let choice;

        // Set the questionClass text to the current question
        $(questionClass).text(question);
        // Remove all current <li> elements (if any)
        $(choiceList).find("li").remove();

        for (let i = 0; i < numChoices; i++) {
            choice = businessQuestions[currentQuestion].choices[i];
            $('<li><input type="radio" value="' + i + '" name="dynradio" />' + choice + '</li>').appendTo(choiceList);
        }
    }

    function displayScore() {
        $(document).find(".quizContainer > .result").html("You scored: " + correctAnswers + " out of " + businessQuestions.length);
        $(document).find(".quizContainer > .result").show();

        $(document).find(".quizContainer > .earnings").html("You have earned: $" + (correctAnswers * 500) + "!");
        $(document).find(".quizContainer > .earnings").show();
        $(document).find("h1").text("Business Quiz Complete!");
    }

    function hideScore() {
        $(document).find(".result").hide();
        $(document).find(".earnings").hide();
    }

    function displayResults() {
        let resultAll = $(document).find(".resultAll");

        for(let i = 0; i < resultArray.length; i++){
            let numChoices = businessQuestions[i].choices.length;
            let choice;

            if(resultArray[i].userAnswer == resultArray[i].correctAnswer){
                $('<div>' + resultArray[i].question + '</div>').appendTo(resultAll);
                for (let j = 0; j < numChoices; j++) {
                    choice = businessQuestions[i].choices[j];
                    if(resultArray[i].correctAnswer == j){
                        $('<li style="background-color: lightgreen; color: green">' + choice + '</li>').appendTo(resultAll);
                    } else {
                        $('<li>' + choice + '</li>').appendTo(resultAll);
                    }
                }
            } else {
                $('<div>' + resultArray[i].question + '</div>').appendTo(resultAll);
                for (let j = 0; j < numChoices; j++) {
                    choice = businessQuestions[i].choices[j];
                    if(resultArray[i].correctAnswer == j){
                        $('<li style="background-color: lightgreen; color: darkgreen">' + choice + '</li>').appendTo(resultAll);
                    } else if(resultArray[i].userAnswer == j){
                        $('<li style="background-color: palevioletred; color: darkred">' + choice + '</li>').appendTo(resultAll);
                    } else {
                        $('<li>' + choice + '</li>').appendTo(resultAll);
                    }
                }
            }
        }
    }
}
