{

    var businessQuestions = [{
        question: "question 1?",
        choices: ["a", "b", "c", "d"],
        correctAnswer: 1
    }, {
        question: "question 2?",
        choices: ["a", "b", "c", "d"],
        correctAnswer: 2
    }, {
        question: "question 3?",
        choices: ["a", "b", "c", "d"],
        correctAnswer: 1
    }, {
        question: "question 4?",
        choices: ["a", "b", "c", "d"],
        correctAnswer: 0
    }, {
        question: "question 5?",
        choices: ["a", "b", "c", "d"],
        correctAnswer: 0
    }];

    var currentQuestion = 0;
    var correctAnswers = 0;
    var quizOver = false;

    $(document).ready(function () {

        // Display the first question
        displayCurrentQuestion();
        $(this).find(".quizMessage").hide();

        // On clicking next, display the next question
        $(this).find(".nextButton").on("click", function () {
            if (!quizOver) {

                value = $("input[type='radio']:checked").val();

                if (value == undefined) {
                    $(document).find(".quizMessage").text("Please select an answer");
                    $(document).find(".quizMessage").show();
                } else {
                    // TODO: Remove any message -> not sure if this is efficient to call this each time....
                    $(document).find(".quizMessage").hide();

                    if (value == businessQuestions[currentQuestion].correctAnswer) {
                        correctAnswers++;
                        //below changes quiz messages if I want to display "correct" or "incorrect" but need to figure out how to not move to next page at the same time
                        // $(document).find(".quizMessage").text("Correct!");
                        // $(document).find(".quizMessage").show();
                    }
                    // else {
                    //     $(document).find(".quizMessage").text("Incorrect.");
                    //     $(document).find(".quizMessage").show();
                    // }

                    currentQuestion++; // Since we have already displayed the first question on DOM ready
                    if (currentQuestion < (businessQuestions.length -1)) {
                        displayCurrentQuestion();
                    } else if(currentQuestion === (businessQuestions.length -1)){
                        displayCurrentQuestion();
                        $(document).find(".nextButton").text("Submit")
                    } else {
                        displayScore();
                        //                    $(document).find(".nextButton").toggle();
                        //                    $(document).find(".playAgainButton").toggle();
                        // Change the text in the next button to ask if user wants to play again
                        $(document).find(".nextButton").hide();
                        quizOver = true;
                    }
                }
            }
            // else { // quiz is over and clicked the next button (which now displays 'Play Again?'
            //     quizOver = false;
            //     $(document).find(".nextButton").text("Next Question");
            //     resetQuiz();
            //     displayCurrentQuestion();
            //     hideScore();
            // }
        });

    });

// This displays the current question AND the choices
    function displayCurrentQuestion() {

        console.log("In display current Question");

        var question = businessQuestions[currentQuestion].question;
        var questionClass = $(document).find(".quizContainer > .question");
        var choiceList = $(document).find(".quizContainer > .choiceList");
        var numChoices = businessQuestions[currentQuestion].choices.length;

        // Set the questionClass text to the current question
        $(questionClass).text(question);

        // Remove all current <li> elements (if any)
        $(choiceList).find("li").remove();

        var choice;
        for (i = 0; i < numChoices; i++) {
            choice = businessQuestions[currentQuestion].choices[i];
            $('<li><input type="radio" value=' + i + ' name="dynradio" />' + choice + '</li>').appendTo(choiceList);
        }
    }

    // function resetQuiz() {
    //     currentQuestion = 0;
    //     correctAnswers = 0;
    //     hideScore();
    // }

    function displayScore() {
        $(document).find(".quizContainer > .result").text("You scored: " + correctAnswers + " out of " + businessQuestions.length);
        $(document).find(".quizContainer > .result").show();
        $(document).find("h1").text("Quiz Complete!");
    }

    function hideScore() {
        $(document).find(".result").hide();
    }
}
