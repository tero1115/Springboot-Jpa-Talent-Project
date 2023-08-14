package com.example.talent.domain.main.service;

import com.example.talent.domain.main.dto.ResMainApiDTO;
import com.example.talent.model.post.entity.PostEntity;
import com.example.talent.model.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MainService {

    private final PostRepository postRepository;

    public ResMainApiDTO getPostTable() {
        List<PostEntity> postEntityList = postRepository.findByDeleteDateIsNull();

        return ResMainApiDTO.of(postEntityList);
    }
}
