package spring.integration.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import spring.ApplicationRunner;
import spring.service.CompanyService;

@ActiveProfiles("test")
@SpringBootTest(classes = ApplicationRunner.class)
public class CompanyServiceIT {
    private static final Integer COMPANY_ID = 1;

    @Autowired
    private CompanyService companyService;



    @Test
    void findById(){

    }

}
