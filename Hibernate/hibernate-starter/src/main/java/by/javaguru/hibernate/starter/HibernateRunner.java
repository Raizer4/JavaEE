package by.javaguru.hibernate.starter;

import by.javaguru.hibernate.starter.entity.Birthday;
import by.javaguru.hibernate.starter.entity.PersonalInfo;
import by.javaguru.hibernate.starter.entity.Role;
import by.javaguru.hibernate.starter.entity.User;
import by.javaguru.hibernate.starter.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;


import java.time.LocalDate;
@Slf4j
public class HibernateRunner {

    public static void main(String[] args) {

        User user = User.builder()
                .username("ivan@mail43.ru")
                .personalInfo(PersonalInfo.builder()
                                .firstname("Ivan")
                                .lastname("Ivaniv")
                                .birthDate(new Birthday(LocalDate.of(2000, 01, 01)))
                                .build())
                .role(Role.ADMIN)
                .build();

        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession())
        {
            session.beginTransaction();

            session.saveOrUpdate(user);

            session.getTransaction().commit();
        }

    }


}
