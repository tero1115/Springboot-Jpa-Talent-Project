package com.example.talent.domain.auth.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.talent.domain.auth.dto.ReqEditDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.talent.common.dto.LoginUserDTO;
import com.example.talent.common.dto.ResponseDTO;
import com.example.talent.common.exception.BadRequestException;
import com.example.talent.domain.auth.dto.ReqJoinDTO;
import com.example.talent.domain.auth.dto.ReqLoginDTO;
import com.example.talent.model.user.entity.UserEntity;
import com.example.talent.model.user.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthServiceApiV1 {

    private final UserRepository userRepository;

    public ResponseEntity<?> login(ReqLoginDTO dto, HttpSession session) {
        // 리파지토리에서 아이디로 삭제되지 않은 유저 찾기
        Optional<UserEntity> userEntityOptional = userRepository.findByUsernameAndDeleteDateIsNull(dto.getUser().getUsername());

        // 없으면 (존재하지 않는 사용자입니다.) 메시지 리턴
        if (!userEntityOptional.isPresent()) {
            throw new BadRequestException("존재하지 않는 사용자입니다.");
        }

        UserEntity userEntity = userEntityOptional.get();

        // 비밀번호가 일치하지 않으면 (비밀번호가 일치하지 않습니다.) 메시지 리턴
        if (!userEntity.getPassword().equals(dto.getUser().getPassword())) {
            throw new BadRequestException("비밀번호가 일치하지 않습니다.");
        }

        // 세션에 로그인 유저 정보 저장
        session.setAttribute("loginUserDTO", LoginUserDTO.of(userEntity));

        // 응답 데이터로 리턴하기 (로그인에 성공하였습니다.)
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("로그인에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> join(ReqJoinDTO dto) {

        // 리파지토리에서 아이디로 유저 찾기
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(dto.getUser().getUsername());

        // 있으면 (이미 존재하는 아이디입니다.) 메시지 리턴
        if (userEntityOptional.isPresent()) {

            throw new BadRequestException("이미 존재하는 아이디입니다.");
        }

        // 없으면 회원가입 처리
        UserEntity userEntity = UserEntity.builder()
                .username(dto.getUser().getUsername())
                .password(dto.getUser().getPassword())
                .tel(dto.getUser().getTel())
                // TODO 기본프로필 넣기
                .profile("")
                .createDate(LocalDateTime.now())
                .build();

        userRepository.save(userEntity);

        // 응답 데이터로 리턴하기 (회원가입에 성공하였습니다.)
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("회원가입에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);
    }


    @Transactional
    public ResponseEntity<?> edit(ReqEditDTO dto, LoginUserDTO loginUserDTO) {

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

        userEntity.editUserInfo(dto.getUser().getPassword(),dto.getUser().getTel());


        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .code(0)
                        .message("유저 정보 수정에 성공하였습니다.")
                        .build(),
                HttpStatus.OK);

    }


}
