package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.User;
import com.capstone.kidinvest.models.UserStock;
import com.capstone.kidinvest.repositories.UserRepo;
//import org.springframework.security.crypto.password.PasswordEncoder;
import com.capstone.kidinvest.repositories.UserStockRepo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@ComponentScan("com.capstone.kidinvest")
@Controller
public class UserController {

    private UserRepo userDao;
    private UserStockRepo userStockDao;
    private PasswordEncoder passwordEncoder;


    public UserController(UserRepo userDao, UserStockRepo userStockDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.userStockDao = userStockDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "/login";
    }

    @GetMapping("/register")
    public String viewRegistrationPage(Model view) {
        view.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String doRegistration(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        //
        user.setBalance(10000.00);
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String viewUserStock(Model view){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        List<UserStock> userStockList = userStockDao.findUserStockByUserId(id);
//        User user = userDao.findUserById(id);
//        view.addAttribute("userStock", userStockList);
        view.addAttribute("user", user);
        return "user/profile";
    }




}
