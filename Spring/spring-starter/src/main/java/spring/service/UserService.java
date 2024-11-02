package spring.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import spring.mapper.UserMapper;
import spring.repository.UserRepository;

@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
}
