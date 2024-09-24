package by.javaguru.hibernate.starter;

import by.javaguru.hibernate.starter.convertor.BirthdayConverter;
import by.javaguru.hibernate.starter.entity.Birthday;
import by.javaguru.hibernate.starter.entity.Role;
import by.javaguru.hibernate.starter.entity.User;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAttributeConverter(new BirthdayConverter(),true);

        try (var sessionFactory = configuration.buildSessionFactory();
             var session = sessionFactory.openSession())
        {
            session.beginTransaction();

            session.save(User.builder()
                    .username("ivan@mail3.ru")
                    .firstname("Ivan")
                    .lastname("Ivaniv")
                    .birthDate(new Birthday(LocalDate.of(2000, 01, 01)))
                    .role(Role.ADMIN)
                    .build()
            );

            session.getTransaction().commit();
        }

    }


}
