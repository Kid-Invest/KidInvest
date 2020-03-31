package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.User;
import com.capstone.kidinvest.models.UserStock;
import com.capstone.kidinvest.repositories.UserRepo;
//import org.springframework.security.crypto.password.PasswordEncoder;
import com.capstone.kidinvest.repositories.UserStockRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private UserRepo userDao;
    private UserStockRepo userStockDao;
    //private PasswordEncoder passwordEncoder;


    public UserController(UserRepo userDao, UserStockRepo userStockDao) {
        this.userDao = userDao;
        this.userStockDao = userStockDao;
        //this.passwordEncoder = passwordEncoder;
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
        //String hash = passwordEncoder.encode(user.getPassword());
        //user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

//    @GetMapping("/profile/user/{id}")
//    public String viewProfilePage(Model view, @PathVariable long id){
//        List<User> userList = userDao.findUserById(id);
//        view.addAttribute("user", userList);
//        return "user/profile";
//    }

    @GetMapping("/profile/{id}")
    public String viewUserStock(Model view, @PathVariable long id){
        List<UserStock> userStockList = userStockDao.findUserStockByUserId(id);
        view.addAttribute("userStock", userStockList);
        return "user/profile";
    }


}
