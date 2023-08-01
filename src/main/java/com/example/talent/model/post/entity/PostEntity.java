package com.example.talent.model.post.entity;

import com.example.talent.model.apply.entity.ApplyEntity;
import com.example.talent.model.review.entity.ReviewEntity;
import com.example.talent.model.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "POST")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "create_date" , nullable = false)
    private LocalDateTime createDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "postEntity")
    private List<ApplyEntity> applyEntityList;

    @OneToMany(mappedBy = "postEntity")
    private List<ReviewEntity> reviewEntityList;
}
