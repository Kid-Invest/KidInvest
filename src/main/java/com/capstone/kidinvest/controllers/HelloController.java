package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.services.RestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
//    private RestService restService;

    @GetMapping("/")
    public String hello(){
//        System.out.println(restService.getStocksPlainJSON());
        return "index";
    }

    public static void main(String[] args) {
         RestService restService;

        System.out.println(restService.getStocksPlainJSON());

    }

}


