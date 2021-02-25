package antigypt.springframework.api.v1.model;


import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private String vehicleModel;
    @Past
    private LocalDate yearOfMake;
    private Double price;
    @Min(5)
    private String plaque;
    private String additionalDetails;
    @Min(5)
    private String postalCode;
    private String vehiclType;
    private String vehicleCondition;
    private String transmission;
    private String owner;
    private Byte[] image;
    private String vehicleUrl;
    private EmployeeDTO employee;
}
