package hibernate_test_2;

import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Detail detail = Detail.builder()
                            .city("Toms")
                            .phone_number("124348")
                            .email("email.com")
                            .build();


            Employee employee = Employee.builder()
                    .name("Negr")
                    .surname("razumist")
                    .department("It")
                    .salary(300)
                    .emdDetail(detail)
                    .build();

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
        }finally {
            factory.close();
        }


    }
}
