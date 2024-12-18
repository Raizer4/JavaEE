package com.dmdev.spring.database.repository.pool;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component()
@RequiredArgsConstructor
public class ConnectionPool {

    private String username;
    private String password;
    private Integer poolSize;
    private String url;

    public ConnectionPool(String username, String password, Integer poolSize, String url) {
        this.username = username;
        this.password = password;
        this.poolSize = poolSize;
        this.url = url;
    }

}
