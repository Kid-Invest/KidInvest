package com.capstone.kidinvest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LearningController {

    @GetMapping("/learning")
    public String viewLearningPage(){
        return "learning/learning";
    }
}
