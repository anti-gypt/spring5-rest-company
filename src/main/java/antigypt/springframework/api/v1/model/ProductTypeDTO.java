package antigypt.springframework.api.v1.model;

import antigypt.springframework.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeDTO {


    private ProductTypeName productTypeName;
    private ProductCategory productCategory;
    private String detail;
    private String productTypeUrl;


}
