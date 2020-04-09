{

    let stockQuestions = [{
        question: "1. question?",
        choices: ["right", "wrong", "wrong", "wrong"],
        correctAnswer: 0
    }, {
        question: "2. question?",
        choices: ["right", "wrong", "wrong", "wrong"],
        correctAnswer: 0
    }, {
        question: "3. question?",
        choices: ["wrong", "wrong", "right", "wrong"],
        correctAnswer: 2
    }, {
        question: "4. question?",
        choices: ["wrong", "right", "wrong", "wrong"],
        correctAnswer: 1
    }, {
        question: "5. question 5?",
        choices: ["wrong", "right", "wrong", "wrong"],
        correctAnswer: 1
    }];

    //defaults and buckets
    let resultArray = [];
    let currentQuestion = 0;
    let correctAnswers = 0;
    let quizOver = false;
    let resultsSent = false;
    // let quizTaken = false;

    $(document).ready(function () {
        let quizTaken = $('#quiz_boolean').val();
        console.log(typeof quizTaken);
        console.log(typeof !quizTaken);


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
                        $('#viewResultsBtn').on("click", function(){
                            $('#quiz_result').val(correctAnswers * 500);
                            // $('#quiz_boolean').val(true);
                            resultsSent = true;
                            quizOver = true;
                        });
                    } else {
                        $(document).find("#formSubmit").hide();
                    }
                }
            });
        // } else {
        //     // displayScore();
        //     // displayResults();
        //     // $(document).find("#formSubmit").hide();
        //     // $(document).find(".nextButton").hide();
        //     $(document).find('.quizDiv').html("<h1>Quiz Already Taken</h1>")
        //     // $('#quiz_boolean').val(true);
        //
        // }
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
            $('<li><input type="radio" value="' + i + '" name="dynradio" />' + choice + '</li>').appendTo(choiceList);
        }
    }

    function displayScore() {
        $(document).find(".quizContainer > .result").html("You scored: " + correctAnswers + " out of " + stockQuestions.length +
                                                          "<br> You have earned: $" + (correctAnswers * 500) + "!");
        $(document).find(".quizContainer > .result").show();
        $(document).find("h1").text("Quiz Complete!");
    }

    function hideScore() {
        $(document).find(".result").hide();
    }

    function displayResults() {
        let resultAll = $(document).find(".resultAll");

        for(let i = 0; i < resultArray.length; i++){
            let numChoices = stockQuestions[i].choices.length;
            let choice;

            if(resultArray[i].userAnswer == resultArray[i].correctAnswer){
                $('<div>' + resultArray[i].question + '</div>').appendTo(resultAll);
                for (let j = 0; j < numChoices; j++) {
                    choice = stockQuestions[i].choices[j];
                    if(resultArray[i].correctAnswer == j){
                        $('<li style="background-color: lightgreen; color: green">' + choice + '</li>').appendTo(resultAll);
                    } else {
                        $('<li>' + choice + '</li>').appendTo(resultAll);
                    }
                }
            } else {
                $('<div>' + resultArray[i].question + '</div>').appendTo(resultAll);
                for (let j = 0; j < numChoices; j++) {
                    choice = stockQuestions[i].choices[j];
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
