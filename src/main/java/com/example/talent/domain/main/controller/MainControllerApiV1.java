package com.example.talent.domain.main.controller;

import com.example.talent.domain.main.service.MainServiceApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/main")
public class MainControllerApiV1 {

    private final MainServiceApiV1 mainServiceApiV1;

    @GetMapping
    public ResponseEntity<?> getPostList() {
        return mainServiceApiV1.getPostTable();
    }
}
