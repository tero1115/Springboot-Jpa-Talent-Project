package com.example.talent.domain.apply.service;

import com.example.talent.common.dto.LoginUserDTO;
import com.example.talent.common.dto.ResponseDTO;
import com.example.talent.common.exception.BadRequestException;
import com.example.talent.common.util.HtmlParser;
import com.example.talent.domain.apply.dto.ReqSaveApplyDTO;
import com.example.talent.model.apply.entity.ApplyEntity;
import com.example.talent.model.apply.repository.ApplyRepository;
import com.example.talent.model.post.entity.PostEntity;
import com.example.talent.model.post.repository.PostRepository;
import com.example.talent.model.user.entity.UserEntity;
import com.example.talent.model.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplyServiceApiV1 {

    private final ApplyRepository applyRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public ResponseEntity<?> save(ReqSaveApplyDTO dto, LoginUserDTO loginUserDTO) {

        // 유저 정보 확인
        Optional<UserEntity> userEntityOptional = userRepository.findById(loginUserDTO.getUser().getId());
        if (!userEntityOptional.isPresent()) {
            throw new BadRequestException("유저 정보가 없습니다.");
        }

        UserEntity userEntity = userEntityOptional.get();

        // 신청할 글 확인
        Optional<PostEntity> postEntityOptional = postRepository.findById(dto.getApply().getPostId());
        if (!postEntityOptional.isPresent()) {
            throw new BadRequestException("글 정보가 없습니다.");
        }

        PostEntity postEntity = postEntityOptional.get();

        // 글 엔티티 생성
        ApplyEntity applyEntity = ApplyEntity.builder()
                .title(dto.getApply().getTitle())
                .content(dto.getApply().getContent())
                .createDate(LocalDateTime.now())
                .userEntity(userEntity)
                .postEntity(postEntity)
                .build();

        // 글 데이터 생성
        applyRepository.save(applyEntity);

        return new ResponseEntity<>(new ResponseDTO<>(0, "글작성 성공", null), HttpStatus.CREATED);

    }
}
