package antigypt.springframework.api.v1.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeListDTO {
    List<EmployeeDTO> employees;
}
