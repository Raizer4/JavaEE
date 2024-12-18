package com.dmdev.spring.mapper;

import com.dmdev.spring.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ToString
public class UserMapper {
    private final UserDto userDto;
}
