package com.example.talent.model.user.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.example.talent.model.apply.entity.ApplyEntity;
import com.example.talent.model.comment.entity.CommentEntity;
import com.example.talent.model.post.entity.PostEntity;
import com.example.talent.model.review.entity.ReviewEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "tel", nullable = false)
    private String tel;

    @Column(name = "profile")
    private String profile;

    @Column(name = "create_date" , nullable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER)
    private List<UserRoleEntity> userRoleEntityList;

    @OneToMany(mappedBy = "userEntity")
    private List<PostEntity> postEntityList;

    @OneToMany(mappedBy = "userEntity")
    private List<ApplyEntity> applyEntityList;

    @OneToMany(mappedBy = "userEntity")
    private List<CommentEntity> commentEntityList;

    @OneToMany(mappedBy = "userEntity")
    private List<ReviewEntity> reviewEntityList;

    public void editUserInfo(String password, String tel) {
        this.password = password;
        this.tel = tel;
        this.updateDate = LocalDateTime.now();
    }

}
