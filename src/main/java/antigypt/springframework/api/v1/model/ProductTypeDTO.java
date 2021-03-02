package antigypt.springframework.api.v1.model;

import antigypt.springframework.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
