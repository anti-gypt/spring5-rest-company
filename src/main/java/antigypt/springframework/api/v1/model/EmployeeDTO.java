package antigypt.springframework.api.v1.model;

import antigypt.springframework.domain.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Past
    private LocalDate birthDate;
    private LocalDate hireDate;
    @Email
    private String email;
    @Min(6)
    @Max(10)
    private String homePhone;
    @Min(8)
    @Max(14)
    private String mobilePhone;
    private String detail;
    @NotBlank
    private String addressLine;
    @NotBlank
    private String city;
    @NotBlank
    private String region;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String country;
    private String title;
    private String gender;
    private Byte[] photo;
    private String employeeUrl;

    private EmployeeListDTO employees;
    private EmployeeDTO reportsTo;
    private JobTitleDTO jobTitle;
    private EmployeeSalaryDTO employeeSalary;
    private DepartmentDTO department;
    private VehicleDTO vehicle;

}
