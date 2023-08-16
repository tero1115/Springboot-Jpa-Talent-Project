package com.example.talent.domain.main.service;

import com.example.talent.common.dto.LoginUserDTO;
import com.example.talent.common.dto.ResponseDTO;
import com.example.talent.common.exception.BadRequestException;
import com.example.talent.domain.main.dto.ReqPasswordCheckDTO;
import com.example.talent.domain.main.dto.ResMainApiDTO;
import com.example.talent.model.post.entity.PostEntity;
import com.example.talent.model.post.repository.PostRepository;
import com.example.talent.model.user.entity.UserEntity;
import com.example.talent.model.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MainServiceApiV1 {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

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

    public ResponseEntity<?> passwordCheck(ReqPasswordCheckDTO dto, LoginUserDTO loginUserDTO) {

        // 리파지토리에서 아이디로 유저 찾기
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(dto.getUser().getUsername());

        // 없으면 (존재하지 않는 사용자입니다.) 메시지 리턴
        if (!userEntityOptional.isPresent()) {
            throw new BadRequestException("존재하지 않는 사용자입니다.");
        }
        UserEntity userEntity = userEntityOptional.get();

        if (!userEntity.getId().equals(loginUserDTO.getUser().getId())) {
            throw new BadRequestException("권한이 없습니다.");
        }

        if (!userEntity.getPassword().equals(dto.getUser().getPassword())) {
            throw new BadRequestException("비밀번호가 맞지 않습니다.");
        }

        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("비밀번호 체크에 성공했습니다.")
                        .build(),
                HttpStatus.OK);
    }
}
