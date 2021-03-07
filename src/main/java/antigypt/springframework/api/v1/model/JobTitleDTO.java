package antigypt.springframework.api.v1.model;


import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobTitleDTO {

    @NotBlank
    private String jobTitleName;
    private Long jobTitleUrl;

}
