package antigypt.springframework.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="EmployeeSalary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "employee")
public class EmployeeSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeSalaryId;

    @Column(name = "monthlySalary")
    private double monthlySalary;
    @Column(name = "reward")
    private double reward;
    @Column(name = "penalty")
    private double penalty;
    @Column(name = "extraCost")
    private double extraCost;
    @Column(name = "salaryTax")
    private double salaryTax;
    @Column(name = "totalSalary")
    private double totalSalary;


    @OneToOne(mappedBy = "employeeSalary",cascade = CascadeType.ALL)
    private Employee employee;

}
