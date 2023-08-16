package com.example.talent.domain.main.controller;

import com.example.talent.common.util.GetLoginUser;
import com.example.talent.domain.main.dto.ReqPasswordCheckDTO;
import com.example.talent.domain.main.service.MainServiceApiV1;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/main")
public class MainControllerApiV1 {

    private final MainServiceApiV1 mainServiceApiV1;

    @GetMapping
    public ResponseEntity<?> getPostList() {
        return mainServiceApiV1.getPostTable();
    }


    @PostMapping("/passwordCheck")
    public ResponseEntity<?> passwordCheck(@Valid @RequestBody ReqPasswordCheckDTO dto, HttpSession session) {
        return mainServiceApiV1.passwordCheck(dto, GetLoginUser.getLoginUserDTO(session));
    }
}
