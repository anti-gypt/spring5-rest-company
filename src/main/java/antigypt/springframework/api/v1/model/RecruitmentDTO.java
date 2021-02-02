package antigypt.springframework.api.v1.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RecruitmentDTO {


    private String firstName;
    private String lastName;
    private String title;
    private String gender;
    private String birthDate;
    private String applicationDate;
    private String email;
    private String addressLine;
    private String city;
    private String country;
    private String region;
    private String postalCode;
    private String homePhone;
    private String mobilePhone;
    private Double desiredSalary;
    private Byte[] photo;
    private String detail;
    private Byte[] cv;
    @JsonProperty("recruitment_url")
    private String recruitmentUrl;
}
