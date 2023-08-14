package com.example.talent.domain.post.service;

import com.example.talent.common.dto.LoginUserDTO;
import com.example.talent.common.dto.ResponseDTO;
import com.example.talent.common.exception.BadRequestException;
import com.example.talent.common.util.HtmlParser;
import com.example.talent.domain.post.dto.ReqSavePostDTO;
import com.example.talent.domain.post.dto.ReqUpdatePostDTO;
import com.example.talent.domain.post.dto.ResPostTableDTO;
import com.example.talent.model.post.entity.PostEntity;
import com.example.talent.model.post.repository.PostRepository;
import com.example.talent.model.user.entity.UserEntity;
import com.example.talent.model.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceApiV1 {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> getPostTableData() {

        List<PostEntity> postEntityList = postRepository.findByDeleteDateIsNull();

        return new ResponseEntity<>(
                new ResponseDTO<>(
                        0,
                        "글 목록 조회에 성공하였습니다.",
                        ResPostTableDTO.of(postEntityList)),
                HttpStatus.CREATED);
    }

    public ResponseEntity<?> getMyPostTableData(LoginUserDTO loginUserDTO) {

        List<PostEntity> postEntityList = postRepository.findByUserEntity_IdAndDeleteDateIsNull(loginUserDTO.getUser().getId());

        return new ResponseEntity<>(
                new ResponseDTO<>(
                        0,
                        "마이페이지 글 목록 조회에 성공하였습니다.",
                        ResPostTableDTO.of(postEntityList)),
                HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<?> save(ReqSavePostDTO dto, LoginUserDTO loginUserDTO) {

        // 유저 정보 확인
        Optional<UserEntity> userEntityOptional = userRepository.findById(loginUserDTO.getUser().getId());
        if (!userEntityOptional.isPresent()) {
            throw new BadRequestException("유저 정보가 없습니다.");
        }

        UserEntity userEntity = userEntityOptional.get();


        String thumbnail = HtmlParser.getThumbnail(dto.getPost().getContent());

        // 글 엔티티 생성
        PostEntity postEntity = PostEntity.builder()
                .title(dto.getPost().getTitle())
                .category(dto.getPost().getCategory())
                .content(dto.getPost().getContent())
                .thumbnail(thumbnail)
                .createDate(LocalDateTime.now())
                .userEntity(userEntity)
                .build();

        // 글 데이터 생성
        postRepository.save(postEntity);


        return new ResponseEntity<>(new ResponseDTO<>(0, "글작성 성공", null), HttpStatus.CREATED);
    }


    public ResponseEntity<?> update(ReqUpdatePostDTO reqUpdatePostDTO, LoginUserDTO loginUserDTO) {

        return new ResponseEntity<>(new ResponseDTO<>(0, "글수정 성공", null), HttpStatus.OK);
    }


}
