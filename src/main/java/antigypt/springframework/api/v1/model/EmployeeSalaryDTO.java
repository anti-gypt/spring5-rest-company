package antigypt.springframework.api.v1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
