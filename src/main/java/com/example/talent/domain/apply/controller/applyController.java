package com.example.talent.domain.apply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class applyController {


    @GetMapping("/apply/save")
    public ModelAndView applySavePage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/apply/saveForm");
        return modelAndView;
    }
}
