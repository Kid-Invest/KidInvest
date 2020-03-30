package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.User;
import com.capstone.kidinvest.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserRepo userDao;

    private UserController (UserRepo userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/register")
    public String viewRegistrationPage(Model view) {
        view.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String doRegistration(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/";
    }

}
