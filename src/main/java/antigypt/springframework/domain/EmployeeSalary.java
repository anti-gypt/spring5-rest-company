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
    private Double monthlySalary;
    @Column(name = "reward")
    private Double reward;
    @Column(name = "penalty")
    private Double penalty;
    @Column(name = "extraCost")
    private Double extraCost;
    @Column(name = "salaryTax")
    private double salaryTax;
    @Column(name = "totalSalary")
    private double totalSalary;


    @OneToOne(mappedBy = "employeeSalary",cascade = CascadeType.ALL)
    private Employee employee;

}
