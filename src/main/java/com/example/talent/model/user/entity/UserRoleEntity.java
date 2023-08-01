package com.example.talent.model.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER_ROLE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false, nullable = false)
    private UserEntity userEntity;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;
}
