package com.example.talent.domain.post.controller;

import com.example.talent.domain.post.dto.ResPostTableDTO;
import com.example.talent.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post/save")
    public ModelAndView postSavePage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/post/saveForm");

        return modelAndView;
    }

    @GetMapping("/post/detail/{postId}")
    public ModelAndView postDetailPage(@PathVariable Integer postId) {

        ModelAndView modelAndView = new ModelAndView();

        ResPostTableDTO.Post dto = postService.getPostData(postId);
        modelAndView.addObject("dto", dto);


        modelAndView.setViewName("/post/detail");

        return modelAndView;
    }
}
