package spring.mapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import spring.dto.UserDto;
@Component
@RequiredArgsConstructor
@ToString
public class UserMapper {
    private final UserDto userDto;
}
