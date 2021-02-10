package antigypt.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="JobTitle")
@Data
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobTitleId;


    @Column(name = "jobTitleName")
    private String jobTitleName;

    @OneToMany(mappedBy = "jobTitle" , cascade = CascadeType.ALL)
    private List<Employee> employeeList = new ArrayList<>();

   //@OneToOne(cascade = CascadeType.ALL)
   //@JoinColumn(name = "SalaryId")
   //private Salary salary;

}
