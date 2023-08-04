package com.example.talent.domain.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {


    @GetMapping("/post/save")
    public ModelAndView postSavePage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/post/saveForm");

        return modelAndView;
    }

    @GetMapping("/post/detail/{id}")
    public ModelAndView postDetailPage(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/post/detail");

        return modelAndView;
    }
}
