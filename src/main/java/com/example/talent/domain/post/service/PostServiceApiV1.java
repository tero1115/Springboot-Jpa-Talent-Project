package com.example.talent.domain.post.service;

import com.example.talent.common.dto.LoginUserDTO;
import com.example.talent.common.dto.ResponseDTO;
import com.example.talent.common.exception.BadRequestException;
import com.example.talent.domain.post.dto.ReqSavePostDTO;
import com.example.talent.model.post.entity.PostEntity;
import com.example.talent.model.post.repository.PostRepository;
import com.example.talent.model.user.entity.UserEntity;
import com.example.talent.model.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceApiV1 {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public ResponseEntity<?> save(ReqSavePostDTO dto, LoginUserDTO loginUserDTO) {

        // 유저 정보 확인
        Optional<UserEntity> userEntitoyOptional = userRepository.findById(loginUserDTO.getUser().getId());
        if (!userEntitoyOptional.isPresent()) {
            throw new BadRequestException("유저 정보가 없습니다.");
        }

        UserEntity userEntity = userEntitoyOptional.get();

        // 글 엔티티 생성
        PostEntity postEntity = PostEntity.builder()
                .title(dto.getPost().getTitle())
                .category(dto.getPost().getCategory())
                .content(dto.getPost().getContent())
                .createDate(LocalDateTime.now())
                .userEntity(userEntity)
                .build();

        // 글 데이터 생성
        postRepository.save(postEntity);


        return new ResponseEntity<>(new ResponseDTO<>(0, "글작성 성공", null), HttpStatus.CREATED);
    }


}
