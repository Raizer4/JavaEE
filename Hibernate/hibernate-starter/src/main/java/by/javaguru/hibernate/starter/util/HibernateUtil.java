package by.javaguru.hibernate.starter.util;

import by.javaguru.hibernate.starter.convertor.BirthdayConverter;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.configure();
        configuration.addAttributeConverter(new BirthdayConverter(),true);
        return configuration.buildSessionFactory();
    }

}
