package com.capstone.kidinvest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LearningController {

    @GetMapping("/learning")
    public String viewLearningPage(){
        return "learning/learning";
    }

    @GetMapping("/learning/stock")
    public String viewStockLearningPage(){
        return "learning/stockLearning";
    }

    @GetMapping("/learning/business")
    public String viewBusinessLearningPage(){
        return "learning/businessLearning";
    }

    @GetMapping("/learning/stock/quiz")
    public String viewStockQuizPage(){
        return "learning/stockQuiz";
    }

    @PostMapping("/learning/stock/quiz")
    public String doAddResultToBalance(){
        return "learning/stockQuiz";
    }

    @GetMapping("/learning/business/quiz")
    public String viewBusinessQuizPage(){
        return "learning/businessQuiz";
    }
}
