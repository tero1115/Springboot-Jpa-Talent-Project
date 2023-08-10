package com.example.talent.domain.post.controller;

import com.example.talent.common.dto.LoginUserDTO;
import com.example.talent.common.exception.InvalidSessionException;
import com.example.talent.domain.post.dto.ReqSavePostDTO;
import com.example.talent.domain.post.service.PostServiceApiV1;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostControllerApiV1 {

    private final PostServiceApiV1 postServiceApiV1;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ReqSavePostDTO reqSavePostDTO, HttpSession session) {

        return postServiceApiV1.save(reqSavePostDTO, getLoginUserDTO(session));
    }

    private static LoginUserDTO getLoginUserDTO(HttpSession session) {
        if (session.getAttribute("loginUserDTO") == null) {
            throw new InvalidSessionException();
        }
        return (LoginUserDTO) session.getAttribute("loginUserDTO");
    }
}
