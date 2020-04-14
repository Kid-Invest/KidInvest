{

    let stockQuestions = [{
        question: "1. What is a stock or share?",
        choices: [" a. A type of investment that represents a piece of a company", " b. The amount of money you have", " c. Total ownership in a company", " d. A list of all the items you have available"],
        correctAnswer: 0
    }, {
        question: "2. When you purchase a stock for $10 and sell it a few weeks later for $20 you are doing which of the following?",
        choices: [" a. buying low and selling high", " b. buying high and selling low", " c. making a profit", " d. both a and c"],
        correctAnswer: 3
    }, {
        question: "3. Why it is important to buy stock in different companies instead of focusing on just one?",
        choices: [" a. Other companies need your investment", " b. You make less money", " c. Some companies lose value or go out of business", " d. You have total ownership in every stock company"],
        correctAnswer: 2
    }, {
        question: "4. People who buy stocks are guaranteed to profit on the money they have invested.",
        choices: [" a. True", " b. False"],
        correctAnswer: 1
    }, {
        question: "5. The market price:",
        choices: [" a. Rises if more people want to buy a stock and falls when people do not want to buy it", " b. Increases and decreases throughout the trading day", " c. Is a price that a stock sells for at a given point in time", " d. All of the above"],
        correctAnswer: 3
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

                    if (value == stockQuestions[currentQuestion].correctAnswer) {
                        correctAnswers++;
                    }

                    //holds user answer and can be compared correct/incorrect later
                    let resultObject = {
                        question: stockQuestions[currentQuestion].question,
                        choices: stockQuestions[currentQuestion].choices,
                        correctAnswer: stockQuestions[currentQuestion].correctAnswer,
                        userAnswer: value
                    };
                    resultArray.push(resultObject);

                    currentQuestion++; // moves to next question
                    if (currentQuestion < (stockQuestions.length - 1)) {
                        displayCurrentQuestion();
                    } else if(currentQuestion === (stockQuestions.length - 1)){
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
        let question = stockQuestions[currentQuestion].question;
        let questionClass = $(document).find(".quizContainer > .question");
        let choiceList = $(document).find(".quizContainer > .choiceList");
        let numChoices = stockQuestions[currentQuestion].choices.length;
        let choice;

        // Set the questionClass text to the current question
        $(questionClass).text(question);
        // Remove all current <li> elements (if any)
        $(choiceList).find("li").remove();

        for (let i = 0; i < numChoices; i++) {
            choice = stockQuestions[currentQuestion].choices[i];
            $('<li><input type="radio" value="' + i + '" name="dynradio" /><label class="radio-label">' + choice + '</label></li>').appendTo(choiceList);
        }
    }

    function displayScore() {
        $(document).find(".quizContainer > .result").html("You scored: " + correctAnswers + " out of " + stockQuestions.length);
        $(document).find(".quizContainer > .result").show();

        $(document).find(".earnings").html("You earned: $" + (correctAnswers * 500) + "!");
        $(document).find(".earnings").show();
        $(document).find("h1").text("Stock Quiz Complete!");
    }

    function hideScore() {
        $(document).find(".result").hide();
        $(document).find(".earnings").hide();
    }

    function displayResults() {
        let resultAll = $(document).find(".resultAll");

        for(let i = 0; i < resultArray.length; i++){
            let numChoices = stockQuestions[i].choices.length;
            let choice;

            if(resultArray[i].userAnswer == resultArray[i].correctAnswer){
                $('<hr><div class="quiz-question">' + resultArray[i].question + '</div>').appendTo(resultAll);
                for (let j = 0; j < numChoices; j++) {
                    choice = stockQuestions[i].choices[j];
                    if(resultArray[i].correctAnswer == j){
                        $('<li class="correct listItem">' + choice + '</li>').appendTo(resultAll);
                    } else {
                        $('<li class="listItem">' + choice + '</li>').appendTo(resultAll);
                    }
                }
            } else {
                $('<hr><div class="quiz-question">' + resultArray[i].question + '</div>').appendTo(resultAll);
                for (let j = 0; j < numChoices; j++) {
                    choice = stockQuestions[i].choices[j];
                    if(resultArray[i].correctAnswer == j){
                        $('<li class="correct listItem">' + choice + '</li>').appendTo(resultAll);
                    } else if(resultArray[i].userAnswer == j){
                        $('<li class="wrong listItem">' + choice + '</li>').appendTo(resultAll);
                    } else {
                        $('<li class="listItem">' + choice + '</li>').appendTo(resultAll);
                    }
                }
            }
        }
    }
}
