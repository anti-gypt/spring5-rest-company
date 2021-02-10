package antigypt.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by omid on 11/17/2020.
 */
@Entity
@Table(name = "Department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "detail")
    private String detail;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "addressLine", column = @Column(name = "addressLine")),
            @AttributeOverride( name = "city", column = @Column(name = "city")),
            @AttributeOverride( name = "region", column = @Column(name = "region")),
            @AttributeOverride( name = "postalCode", column = @Column(name = "postalCode")),
            @AttributeOverride( name = "country", column = @Column(name = "country"))
    })
    private Address address;

    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL)
    private List<Employee> employeeList = new ArrayList<>();


   //@OneToMany(mappedBy = "department" , cascade = CascadeType.ALL)
   //private List<Shift> shiftList = new ArrayList<>();
   //@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
   //private List<Order> orderList = new ArrayList<>();


}