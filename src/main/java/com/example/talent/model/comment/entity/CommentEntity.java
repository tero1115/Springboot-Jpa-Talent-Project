package com.example.talent.model.comment.entity;

import com.example.talent.model.apply.entity.ApplyEntity;
import com.example.talent.model.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CommentEntity {

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
    @JoinColumn(name = "apply_id", referencedColumnName = "id", nullable = false)
    private ApplyEntity applyEntity;
}
