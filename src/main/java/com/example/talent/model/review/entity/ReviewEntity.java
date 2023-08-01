package com.example.talent.model.review.entity;

import com.example.talent.model.post.entity.PostEntity;
import com.example.talent.model.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "REVIEW")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

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

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private PostEntity postEntity;
}
