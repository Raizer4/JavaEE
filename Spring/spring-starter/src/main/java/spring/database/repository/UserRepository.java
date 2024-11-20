package spring.database.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.database.repository.pool.ConnectionPool;

@Repository
@ToString
public class UserRepository {

    @Autowired
    private ConnectionPool connectionPool;

    @PostConstruct
    public void init(){
        System.out.println("init UserRepository");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy UserRepository");
    }

}
