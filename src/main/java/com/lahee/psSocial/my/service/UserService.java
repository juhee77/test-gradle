package com.lahee.psSocial.my.service;

import com.lahee.psSocial.my.domain.Role;
import com.lahee.psSocial.my.domain.User;
import com.lahee.psSocial.my.domain.dto.user.UserRequestDto;
import com.lahee.psSocial.my.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void signUp(UserRequestDto userRequestDto) {
        User user = User.builder().userName(userRequestDto.getUserName())
                .email(userRequestDto.getEmail())
                .Role(Role.valueOf(userRequestDto.getRole()))
                .realName(userRequestDto.getRealName())
                .password(userRequestDto.getPassword()).build();
        userRepository.save(user);
    }
}
