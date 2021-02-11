package antigypt.springframework.api.v1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobTitleDTO {

    @NotBlank
    private String jobTitleName;
    private Long jobTitleUrl;
    private EmployeeListDTO employees;
}
