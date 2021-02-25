package antigypt.springframework.api.v1.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    @Min(6)
    private String phoneNumber;
    @Email
    private String email;
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
    @JsonProperty("depratment_url")
    private String DepartmetnUrl;

}
