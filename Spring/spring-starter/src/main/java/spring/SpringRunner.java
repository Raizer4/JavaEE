package spring;

import spring.dto.UserDto;
import spring.mapper.UserMapper;
import spring.repository.UserRepository;
import spring.service.UserService;

public class SpringRunner {

    public static void main(String[] args) {
        var userRepository = new UserRepository();
        var userDto = new UserDto();

        var userMapper = new UserMapper(userDto);
        var userService = new UserService(userMapper,userRepository);
    }

}
