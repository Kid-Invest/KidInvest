package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.User;
import com.capstone.kidinvest.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String viewStockLearningPage(Model view){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());

        view.addAttribute("dbUser", dbUser);
        return "learning/stockLearning";
    }

    @GetMapping("/learning/stock/quiz")
    public String viewStockQuizPage(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        return "learning/stockQuiz";
    }

    @PostMapping("/learning/stock/quiz")
    public String doAddStockResultToBalance(Model view, @RequestParam String quiz_result){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        int taken = dbUser.getTakenStockQuiz();

        if(taken == 0){
            // Increase user's balance based off quiz result ($500/correct answer)
            dbUser.setBalance(dbUser.getBalance() + Double.parseDouble(quiz_result));
            dbUser.setTakenStockQuiz(1);
            // Save user's balance and takenstockquiz
            userDao.save(dbUser);
            System.out.println("added to balance");
        }
        return "redirect:/profile";
    }

    @GetMapping("/learning/business")
    public String viewBusinessLearningPage(Model view){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());

        view.addAttribute("dbUser", dbUser);
        return "learning/businessLearning";
    }

    @GetMapping("/learning/business/quiz")
    public String viewBusinessQuizPage(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        return "learning/businessQuiz";
    }

    @PostMapping("/learning/business/quiz")
    public String doAddBusinessResultToBalance(Model view, @RequestParam String quiz_result){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        int taken = dbUser.getTakenBusinessQuiz();

        if(taken == 0){
            // Increase user's balance based off quiz result ($500/correct answer)
            dbUser.setBalance(dbUser.getBalance() + Double.parseDouble(quiz_result));
            dbUser.setTakenBusinessQuiz(1);
            // Save user's balance and takenbusinessquiz
            userDao.save(dbUser);
            System.out.println("added to balance");
        }
        return "redirect:/profile";
    }
}
