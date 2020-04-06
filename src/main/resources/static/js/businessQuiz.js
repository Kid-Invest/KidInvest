{

    let businessQuestions = [{
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

    let businessResults = [];
    let currentQuestion = 0;
    let correctAnswers = 0;
    let quizOver = false;

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
                        let correctAnswer = {
                            question: businessQuestions[currentQuestion].question,
                            choices: businessQuestions[currentQuestion].choices,
                            correctAnswer: businessQuestions[currentQuestion].correctAnswer,
                            color: "green",
                            userAnswer: value
                        };
                        businessResults.push(correctAnswer);
                    }
                    else {
                        // $(document).find(".quizMessage").text("Incorrect.");
                        // $(document).find(".quizMessage").show();
                        let incorrectAnswer = {
                            question: businessQuestions[currentQuestion].question,
                            choices: businessQuestions[currentQuestion].choices,
                            correctAnswer: businessQuestions[currentQuestion].correctAnswer,
                            color: "red",
                            userAnswer: value,
                        };
                        businessResults.push(incorrectAnswer);
                    }

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
                        displayResults();
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

        let question = businessQuestions[currentQuestion].question;
        let questionClass = $(document).find(".quizContainer > .question");
        let choiceList = $(document).find(".quizContainer > .choiceList");
        let numChoices = businessQuestions[currentQuestion].choices.length;

        // Set the questionClass text to the current question
        $(questionClass).text(question);

        // Remove all current <li> elements (if any)
        $(choiceList).find("li").remove();

        let choice;
        for (let i = 0; i < numChoices; i++) {
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

    function displayResults() {

        for(let i = 0; i < businessResults.length; i++){

            let numChoices = businessQuestions[i].choices.length;
            let choice;


            if(businessResults[i].userAnswer === businessResults[i].correctAnswer){
                console.log('question ' + (i + 1) + ': ' + businessResults[i].question);
                // console.log('question ' + (i + 1) + ': ' + businessResults[i].question);
                for (let j = 0; j < numChoices; j++) {
                    choice = businessQuestions[i].choices[j];
                    // $('<li><input type="radio" value=' + j + ' name="dynradio" />' + choice + '</li>').appendTo(choiceList);
                    console.log(choice);
                }
                console.log('your correct answer was' + (i + 1) + ': ' + businessResults[i].correctAnswer);
                console.log('correct answer ' + (i + 1) + ': ' + businessResults[i].color);
            } else {
                console.log('question ' + (i + 1) + ': ' + businessResults[i].question);
                // console.log('question ' + (i + 1) + ': ' + businessResults[i].question);
                for (let j = 0; j < numChoices; j++) {
                    choice = businessQuestions[i].choices[j];
                    // $('<li><input type="radio" value=' + j + ' name="dynradio" />' + choice + '</li>').appendTo(choiceList);
                    console.log(choice);
                }
                console.log('the correct answer was' + (i + 1) + ': ' + businessResults[i].correctAnswer);
                console.log('your answer was' + (i + 1) + ': ' + businessResults[i].userAnswer);
                console.log('correct answer ' + (i + 1) + ': ' + businessResults[i].color);
            }

        }
    }
}
