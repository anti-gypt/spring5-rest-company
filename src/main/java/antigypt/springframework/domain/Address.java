package antigypt.springframework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by omid on 11/16/2020.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String addressLine;
    private String city;
    private String region;
    private String postalCode;
    private String country;

}
