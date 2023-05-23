package com.lahee.psSocial.my.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE user SET deleteAt = CURRENT_TIMESTAMP WHERE member_id = ?")
@Where(clause = "deleteAt IS NULL")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime lastModifiedAt;
    private LocalDateTime deleteAt;
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
