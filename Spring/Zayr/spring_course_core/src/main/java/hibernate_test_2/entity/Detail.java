package hibernate_test_2.entity;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    private String phone_number;

    private String email;

}
