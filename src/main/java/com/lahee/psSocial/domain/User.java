package com.lahee.psSocial.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @CreatedBy
    private LocalDateTime createdAt;
    @LastModifiedBy
    private LocalDateTime lastModifiedAt;
    @Column(unique = true)
    private String email;
    private String password;
    private String realName;
    @Enumerated(EnumType.STRING)
    private Role Role;
    @Column(unique = true)
    private String userName;
    private String profile;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", lastModifiedAt=" + lastModifiedAt +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", Role=" + Role +
                ", userName='" + userName + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
