package com.lahee.psSocial.my.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String email;
    private String password;
    private String realName;
    private String role = "USER";
    private String userName;
}
