package antigypt.springframework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {


    private String productName;
    private String expirationDate;
    private String produceDate;
    private String price;
    private String discount;
    private String productCount;
    private String weight;
    private String detail;
    private String productUrl;

    private Byte[] serialNumber;
    private Byte[] image;

    private ProductTypeDTO productType;

}
