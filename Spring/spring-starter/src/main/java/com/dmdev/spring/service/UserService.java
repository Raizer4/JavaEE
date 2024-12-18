package com.dmdev.spring.service;

import com.dmdev.spring.database.repository.UserRepository;
import com.dmdev.spring.dto.UserReadDto;
import com.dmdev.spring.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
}