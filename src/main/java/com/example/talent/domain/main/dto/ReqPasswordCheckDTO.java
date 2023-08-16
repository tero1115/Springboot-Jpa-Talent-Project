package com.example.talent.domain.main.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReqPasswordCheckDTO {

    @Valid
    @NotNull(message = "유저 정보를 입력해주세요.")
    private User user;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class User {

        @NotBlank(message = "로그인을 해주세요")
        String username;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        String password;

    }
}
