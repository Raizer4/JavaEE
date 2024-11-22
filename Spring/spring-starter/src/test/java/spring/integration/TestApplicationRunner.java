package spring.integration;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;
import spring.database.repository.pool.ConnectionPool;

@TestConfiguration
public class TestApplicationRunner {

    @SpyBean(name = "connectionPool2")
    private ConnectionPool pool1;
}
