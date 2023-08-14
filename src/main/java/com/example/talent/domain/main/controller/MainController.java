package com.example.talent.domain.main.controller;

import com.example.talent.domain.main.dto.ResMainApiDTO;
import com.example.talent.domain.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class MainController {
    
    private final MainService mainService;

    @GetMapping("/")
    public ModelAndView mainPage() {

        ModelAndView modelAndView = new ModelAndView();

        ResMainApiDTO dto = mainService.getPostTable();
        modelAndView.addObject("dto",dto);

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
