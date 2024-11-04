package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.dto.UserDto;
import spring.ioc.Container;
import spring.mapper.UserMapper;
import spring.repository.UserRepository;
import spring.service.UserService;

public class SpringRunner {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        var userRepository = context.getBean(UserService.class);
        System.out.println(userRepository);
    }

}
