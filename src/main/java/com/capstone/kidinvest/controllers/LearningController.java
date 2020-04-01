package com.capstone.kidinvest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/learning/business/quiz")
    public String viewBusinessQuizPage(){
        return "learning/businessQuiz";
    }
}
