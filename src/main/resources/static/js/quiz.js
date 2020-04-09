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
    let stockResultArray = [];
    let currentQuestion = 0;
    let correctAnswers = 0;
    let quizOver = false;

    function displayResults(resultArray) {

        let resultAll = $(document).find("#resultPage");

        for (let i = 0; i < resultArray.length; i++) {
            let numChoices = stockQuestions[i].choices.length;
            let choice;

            if (resultArray[i].userAnswer == resultArray[i].correctAnswer) {
                $('<div>' + resultArray[i].question + '</div>').appendTo(resultAll);
                for (let j = 0; j < numChoices; j++) {
                    choice = stockQuestions[i].choices[j];
                    if (resultArray[i].correctAnswer == j) {
                        $('<li style="background-color: lightgreen; color: green">' + choice + '</li>').appendTo(resultAll);
                    } else {
                        $('<li>' + choice + '</li>').appendTo(resultAll);
                    }
                }
            } else {
                $('<div>' + resultArray[i].question + '</div>').appendTo(resultAll);
                for (let j = 0; j < numChoices; j++) {
                    choice = stockQuestions[i].choices[j];
                    if (resultArray[i].correctAnswer == j) {
                        $('<li style="background-color: lightgreen; color: darkgreen">' + choice + '</li>').appendTo(resultAll);
                    } else if (resultArray[i].userAnswer == j) {
                        $('<li style="background-color: palevioletred; color: darkred">' + choice + '</li>').appendTo(resultAll);
                    } else {
                        $('<li>' + choice + '</li>').appendTo(resultAll);
                    }
                }
            }
        }
    }
}