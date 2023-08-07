package com.example.talent.domain.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView mainPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("main/main");

        return modelAndView;
    }

    @GetMapping("/mypage")
    public ModelAndView myPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("main/myPage");

        return modelAndView;
    }

    @GetMapping("/mypage/editUserInfo")
    public ModelAndView editUserInfoPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/mypage/editUserInfo");

        return modelAndView;
    }

    @GetMapping("/mypage/myPost")
    public ModelAndView myPostPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/mypage/myPost");

        return modelAndView;
    }

    @GetMapping("/mypage/myPost/{id}")
    public ModelAndView myPostDetailPage(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/mypage/myPostDetail");

        return modelAndView;
    }

    @GetMapping("/mypage/myApply")
    public ModelAndView myApplyPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/mypage/myApply");

        return modelAndView;
    }

    @GetMapping("/mypage/myApply/{id}")
    public ModelAndView myApplyDetailPage(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/mypage/myApplyDetail");

        return modelAndView;
    }

    @GetMapping("/mypage/myReceiveApply")
    public ModelAndView myReceiveApplyPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/mypage/myReceiveApply");

        return modelAndView;
    }

    @GetMapping("/mypage/myReceiveApply/{id}")
    public ModelAndView myReceiveApplyDetailPage(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/mypage/myReceiveApplyDetail");

        return modelAndView;
    }
}
