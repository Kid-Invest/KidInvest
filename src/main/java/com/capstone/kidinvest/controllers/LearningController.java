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
        User dbUser = userDao.findUserById(user.getId());
        return "learning/stockQuiz";
    }

    private int done = 0;

    @PostMapping("/learning/stock/quiz")
    public String doAddStockResultToBalance(Model view, @RequestParam String quiz_result, @RequestParam boolean quiz_boolean){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());

        if(done != 0){
            boolean quizTaken = true;
            view.addAttribute("quiz_boolean", quizTaken);
            System.out.println("quiz taken is true");
        } else {
            // Increase user's balance based off quiz result ($500/correct answer)
            dbUser.setBalance(dbUser.getBalance() + Double.parseDouble(quiz_result));
            // Save user's balance
            userDao.save(dbUser);
            System.out.println("added to balance");
            done++;
        }
        return "redirect:/learning/stock";
    }

    @GetMapping("/learning/business/quiz")
    public String viewBusinessQuizPage(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "learning/businessQuiz";
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
