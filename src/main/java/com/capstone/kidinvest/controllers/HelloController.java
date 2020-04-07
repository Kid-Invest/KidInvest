package com.capstone.kidinvest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "index";
    }

    @GetMapping("/home/aboutus")
    public String viewAboutUsPage(){
        return "aboutus";
    }

    @GetMapping("/game")
    public String viewGame() {

        return "business/game";
    }
}