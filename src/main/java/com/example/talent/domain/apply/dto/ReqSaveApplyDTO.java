package com.example.talent.domain.apply.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReqSaveApplyDTO {

    @Valid
    @NotNull(message = "글 정보를 입력해주세요.")
    private Apply apply;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class Apply {

        @NotNull(message = "제목을 입력해주세요.")
        private String title;
        @NotNull(message = "내용을 입력해주세요.")
        private String content;

        private Integer postId;
    }
}
