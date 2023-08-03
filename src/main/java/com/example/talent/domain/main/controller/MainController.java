package com.example.talent.domain.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView mainPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("main/main");

        return modelAndView;
    }
}
