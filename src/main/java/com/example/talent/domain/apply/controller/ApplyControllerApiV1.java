package com.example.talent.domain.apply.controller;

import com.example.talent.common.util.GetLoginUser;
import com.example.talent.domain.apply.dto.ReqSaveApplyDTO;
import com.example.talent.domain.apply.service.ApplyServiceApiV1;
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
@RequestMapping("/api/v1/apply")
public class ApplyControllerApiV1 {

    private final ApplyServiceApiV1 applyServiceApiV1;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ReqSaveApplyDTO reqSaveApplyDTO, HttpSession session) {

        return applyServiceApiV1.save(reqSaveApplyDTO, GetLoginUser.getLoginUserDTO(session));
    }
}
