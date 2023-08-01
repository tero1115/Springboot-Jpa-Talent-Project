package com.example.talent.domain.main.service;

import com.example.talent.common.dto.ResponseDTO;
import com.example.talent.domain.main.dto.ResMainApiDTO;
import com.example.talent.model.post.entity.PostEntity;
import com.example.talent.model.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MainServiceApiV1 {

    private final PostRepository postRepository;

    @Transactional
    public ResponseEntity<?> getPostTable() {
        List<PostEntity> postEntityList = postRepository.findAll();

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("포스트 리스트 조회에 성공했습니다")
                        .data(ResMainApiDTO.of(postEntityList))
                        .build(),
                HttpStatus.OK
        );
    }
}
