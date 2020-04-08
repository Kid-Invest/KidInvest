package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String doAddResultToBalance(@RequestParam String quiz_result){
        System.out.println(quiz_result);
        return "redirect:/learning";
    }

    @GetMapping("/learning/stock/results")
    public String viewStockQuizResultsPage(){
        return "learning/stockQuizResults";
    }

    @GetMapping("/learning/business/quiz")
    public String viewBusinessQuizPage(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return "learning/businessQuiz";
    }
}
