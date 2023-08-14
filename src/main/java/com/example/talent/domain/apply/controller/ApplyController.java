package com.example.talent.domain.apply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplyController {

    @GetMapping("/apply/save/{id}")
    public ModelAndView applySavePage(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/apply/saveForm");
        return modelAndView;
    }
}
