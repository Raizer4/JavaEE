package spring.integration.annotation;

import jakarta.transaction.Transactional;
import spring.ApplicationRunner;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import spring.integration.TestApplicationRunner;


import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ActiveProfiles("test")
@SpringBootTest(classes = TestApplicationRunner.class)
@Transactional
public @interface IT {
}
