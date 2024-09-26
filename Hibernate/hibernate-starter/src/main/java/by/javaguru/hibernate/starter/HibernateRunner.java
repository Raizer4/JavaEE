package by.javaguru.hibernate.starter;

import by.javaguru.hibernate.starter.entity.*;
import by.javaguru.hibernate.starter.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;


import java.time.LocalDate;
@Slf4j
public class HibernateRunner {

    public static void main(String[] args) {
        Company company = Company.builder()
                .name("Google")
                .build();

        User user = User.builder()
                .username("ivan@mail43.ru")
                .personalInfo(PersonalInfo.builder()
                                .firstname("Ivan")
                                .lastname("Ivaniv")
                                .birthDate(new Birthday(LocalDate.of(2000, 01, 01)))
                                .build())
                .role(Role.ADMIN)
                .company(company)
                .build();

        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession())
        {
            session.beginTransaction();

            session.saveOrUpdate(company);
            session.saveOrUpdate(user);

            session.getTransaction().commit();
        }

    }


}
