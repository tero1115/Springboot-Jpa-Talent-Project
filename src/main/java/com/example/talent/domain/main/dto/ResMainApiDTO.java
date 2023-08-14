package com.example.talent.domain.main.dto;

import com.example.talent.model.post.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ResMainApiDTO {

    private List<Post> postList;

    public static ResMainApiDTO of(List<PostEntity> postEntityList) {
        return ResMainApiDTO.builder()
                .postList(Post.fromEntityList(postEntityList))
                .build();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Post {
        private Integer id;
        private String title;
        private String category;
        private String username;
        private String thumbnail;
        private LocalDateTime createDate;

        public static Post fromEntity(PostEntity postEntity) {
            return Post.builder()
                    .id(postEntity.getId())
                    .title(postEntity.getTitle())
                    .category(postEntity.getCategory())
                    .username(postEntity.getUserEntity().getUsername())
                    .thumbnail(postEntity.getThumbnail())
                    .createDate(postEntity.getCreateDate())
                    .build();
        }

        public static List<Post> fromEntityList(List<PostEntity> postEntityList) {
            return postEntityList
                    .stream()
                    .map((postEntity)->Post.fromEntity(postEntity))
                    .toList();
        }
    }
}
