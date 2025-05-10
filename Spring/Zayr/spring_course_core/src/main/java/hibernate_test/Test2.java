package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Elena", "Petrova"
                    , "Sales", 200);

            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();


            int myid = emp.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myid);

            System.out.println(employee);

            session.getTransaction().commit();
        }finally {
            factory.close();
        }


    }
}
