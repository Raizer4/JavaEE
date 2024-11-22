package spring.database.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;
import spring.database.repository.pool.ConnectionPool;

@Repository
@ToString
@RequiredArgsConstructor
public class UserRepository {


    private final ConnectionPool connectionPool;

    @PostConstruct
    public void init(){
        System.out.println("init UserRepository");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy UserRepository");
    }

}
