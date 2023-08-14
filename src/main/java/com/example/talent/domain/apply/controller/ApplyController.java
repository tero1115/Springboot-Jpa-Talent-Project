package com.example.talent.domain.apply.controller;

import com.example.talent.domain.post.dto.ResPostTableDTO;
import com.example.talent.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ApplyController {

    private final PostService postService;

    @GetMapping("/apply/save/{postId}")
    public ModelAndView applySavePage(@PathVariable Integer postId) {

        ModelAndView modelAndView = new ModelAndView();

        ResPostTableDTO.Post dto = postService.getPostData(postId);
        modelAndView.addObject("dto", dto);

        modelAndView.setViewName("/apply/saveForm");
        return modelAndView;
    }
}
