package com.example.talent.domain.auth.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReqJoinDTO {

    @Valid
    @NotNull(message = "유저 정보를 입력해주세요.")
    private JoinUserDTO joinUserDTO;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class JoinUserDTO {

        @NotBlank(message = "아이디를 입력해주세요.")
        @Size(min = 2, message = "아이디는 2자 이상 입력해주세요.")
        private String username;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        private String password;

        @NotBlank(message = "전화번호를 입력해주세요.")
        @Pattern(regexp = "^[0-9]{11}$", message = "하이픈(-)없이 숫자만 입력해주세요")
        private String tel;
    }

}
