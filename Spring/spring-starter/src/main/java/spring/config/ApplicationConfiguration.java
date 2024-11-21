package spring.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import spring.database.repository.pool.ConnectionPool;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ConnectionPool connectionPool() {
        return new ConnectionPool("postgres", "1", 20, "url");
    }


}
