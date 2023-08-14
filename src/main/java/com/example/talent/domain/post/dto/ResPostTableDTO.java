package com.example.talent.domain.post.dto;

import com.example.talent.model.post.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ResPostTableDTO {

    private List<Post> postList;

    public static ResPostTableDTO of(List<PostEntity> postEntityList) {
        return ResPostTableDTO.builder()
                .postList(
                        postEntityList.stream()
                                .map(postEntity -> Post.fromEntity(postEntity))
                                .toList()
                )
                .build();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Post{
        private Integer id;
        private String title;
        private String category;
        private String content;

        public static Post fromEntity(PostEntity postEntity) {
            return Post.builder()
                    .id(postEntity.getId())
                    .title(postEntity.getTitle())
                    .category(postEntity.getCategory())
                    .content(postEntity.getContent())
                    .build();

        }

    }
}
