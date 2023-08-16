package com.example.talent.domain.auth.controller;

import com.example.talent.common.util.GetLoginUser;
import com.example.talent.domain.auth.dto.ReqEditDTO;
import com.example.talent.domain.auth.dto.ReqJoinDTO;
import com.example.talent.domain.auth.dto.ReqLoginDTO;
import com.example.talent.domain.auth.service.AuthServiceApiV1;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthControllerApiV1 {

    private final AuthServiceApiV1 authServiceApiV1;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody ReqLoginDTO dto, HttpSession session) {
        // 서비스에서 로그인하기
        return authServiceApiV1.login(dto, session);
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@Valid @RequestBody ReqJoinDTO dto) {
        // 서비스에서 회원가입하기
        return authServiceApiV1.join(dto);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> edit(@Valid @RequestBody ReqEditDTO dto, HttpSession session) {
        return authServiceApiV1.edit(dto, GetLoginUser.getLoginUserDTO(session));
    }
}