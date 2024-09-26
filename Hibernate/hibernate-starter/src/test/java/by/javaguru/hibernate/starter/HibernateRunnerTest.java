package by.javaguru.hibernate.starter;

import by.javaguru.hibernate.starter.entity.*;

import by.javaguru.hibernate.starter.util.HibernateUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;


class HibernateRunnerTest {

    @Test
    public void checkManyToMany(){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();


        Chat chat = session.get(Chat.class,1L);
        User user = session.get(User.class,2L);

        UserChat userChat = UserChat.builder()
                .createdAt(Instant.now())
                .createdBy("Andrei")
                .build();

        userChat.setChat(chat);
        userChat.setUser(user);

        session.save(userChat);

        session.getTransaction().commit();
    }

    @Test
    public void checkOneToOne(){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        User user = User.builder()
                .username("ivan1525@mail43.ru")
                .build();

        Profile profile = Profile.builder()
                .language("RU")
                .street("Pobedy 11")
                .build();

        session.save(user);
        profile.setUser(user);
        session.save(profile);

        session.getTransaction().commit();
    }

    @Test
    public void checkOrphalRemoval(){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        Company company = session.get(Company.class, 1);
        company.getUsers().removeIf(user -> user.getId().equals(1));

        session.getTransaction().commit();
    }

    @Test
    public void addNewUserAndCompany(){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        Company company = Company.builder()
                .name("Yandex")
                .build();

        User user = User.builder()
                .username("ivan12@mail43.ru")
                .build();

        company.addUser(user);

        session.save(company);

        session.getTransaction().commit();
    }

    @Test
    public void checkOneToMany(){
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();

        var company = session.get(Company.class,1);
        System.out.println(company);

        session.getTransaction().commit();
    }


    @Test
    public void testHibernateApi() throws SQLException, IllegalAccessException {
        /*
        var user = User.builder()
                .username("ivan1@mail.ru")
                .firstname("Ivan")
                .lastname("Ivaniv")
                .birthDate(LocalDate.of(2000, 01, 01))
                .age(23)
                .build();

        var sql = """
                insert into
                %s
                (%s)
                values
                (%s)
                """;

        var tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
                .map(table -> table.schema() + "." + table.name())
                .orElse(user.getClass().getName());

        Field[] fields = user.getClass().getDeclaredFields();

        var columnName = Arrays.stream(fields)
                .map(field -> Optional.ofNullable(field.getAnnotation(Column.class))
                        .map(Column::name)
                        .orElse(field.getName())
                ).collect(Collectors.joining(", "));

        var columnValues = Arrays.stream(fields)
                .map(field -> "?")
                .collect(Collectors.joining(", "));


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres","1");

        PreparedStatement preparedStatement = connection
                .prepareStatement(sql.formatted(tableName,columnName,columnValues));

        for (int i = 0; i < fields.length; i++){
            fields[i].setAccessible(true);
            preparedStatement.setObject(i + 1,fields[i].get(user));
        }

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

         */
    }

}