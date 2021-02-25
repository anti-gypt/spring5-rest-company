package antigypt.springframework.api.v1.model;


import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSalaryDTO {

    @NotBlank
    private Double monthlySalary;
    private Double reward;
    private Double penalty;
    private Double extraCost;
    @NotBlank
    private Double salaryTax;
    private Double totalSalary;
    private Long employeeSalaryUrl;
    private EmployeeDTO employee;
}
