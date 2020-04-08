package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.User;
import com.capstone.kidinvest.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LearningController {
    private UserRepo userDao;

    public LearningController(UserRepo userDao){
        this.userDao = userDao;
    }

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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "learning/stockQuiz";
    }

    @PostMapping("/learning/stock/quiz")
    public String doAddStockResultToBalance(@RequestParam String quiz_result){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        // Increase user's balance based off quiz result ($500/correct answer)
        dbUser.setBalance(dbUser.getBalance() + Double.parseDouble(quiz_result));
        // Save user's balance
        userDao.save(dbUser);
        return "redirect:/learning";
    }

    @GetMapping("/learning/business/quiz")
    public String viewBusinessQuizPage(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "redirect:/learning";
    }

    @PostMapping("/learning/business/quiz")
    public String doAddBusinessResultToBalance(@RequestParam String quiz_result){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        // Increase user's balance based off quiz result ($500/correct answer)
        dbUser.setBalance(dbUser.getBalance() + Double.parseDouble(quiz_result));
        // Save user's balance
        userDao.save(dbUser);
        return "redirect:/learning";
    }
}
