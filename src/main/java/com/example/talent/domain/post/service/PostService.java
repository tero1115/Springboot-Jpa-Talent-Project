package com.example.talent.domain.post.service;

import com.example.talent.domain.post.dto.ResPostTableDTO;
import com.example.talent.model.post.entity.PostEntity;
import com.example.talent.model.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public ResPostTableDTO.Post getPostData(Integer postId) {
        Optional<PostEntity> postEntityOptional = postRepository.findByIdAndDeleteDateIsNull(postId);
        PostEntity postEntity = postEntityOptional.get();

        return ResPostTableDTO.Post.fromEntity(postEntity);
    }
}
