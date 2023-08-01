package com.example.talent.common.dto;

import com.example.talent.model.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class LoginUserDTO {

    private User user;

    public static LoginUserDTO of(UserEntity userEntity) {
        return LoginUserDTO.builder()
                .user(User.fromEntity(userEntity))
                .build();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @ToString
    public static class User {
        private Integer id;
        private String username;
        private String password;
        private String tel;
        private List<String> roleList;

        public static User fromEntity(UserEntity userEntity) {
            return User.builder()
                    .id(userEntity.getId())
                    .username(userEntity.getUsername())
                    .password(userEntity.getPassword())
                    .tel(userEntity.getTel())
                    .roleList(
                            userEntity.getUserRoleEntityList()
                                    .stream()
                                    .map(userRoleEntity -> userRoleEntity.getRole())
                                    .toList()
                    )
                    .build();
        }
    }
}
