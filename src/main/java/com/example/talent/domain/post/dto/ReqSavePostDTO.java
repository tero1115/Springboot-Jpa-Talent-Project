package com.example.talent.domain.post.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReqSavePostDTO {

    @Valid
    @NotNull(message = "글 정보를 입력해주세요.")
    private Post post;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Builder
    public static class Post {

        @NotNull(message = "제목을 입력해주세요.")
        private String title;

        @NotNull(message = "카테고리를 선택해주세요.")
        private String category;

        @NotNull(message = "내용을 입력해주세요.")
        private String content;

    }
}
