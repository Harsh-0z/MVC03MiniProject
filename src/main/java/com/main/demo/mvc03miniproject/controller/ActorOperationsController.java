package com.main.demo.mvc02miniproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ActorOperationsController {

    @GetMapping("/")
    public String showHome(){
        //return logical view name
        return "home";
    }

}
