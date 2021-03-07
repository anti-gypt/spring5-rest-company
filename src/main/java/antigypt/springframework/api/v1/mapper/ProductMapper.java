package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.DepartmentDTO;
import antigypt.springframework.api.v1.model.ProductDTO;
import antigypt.springframework.domain.Department;
import antigypt.springframework.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mappings({

    })
    Product productDTOToProduct(ProductDTO productDTO);
    @Mappings({

    })
    ProductDTO productToProductDTO(Product product);

    @Mappings({@Mapping(
            source = "address.addressLine",
            target = "addressLine"
    ), @Mapping(
            source = "address.country",
            target = "country"
    ), @Mapping(
            source = "address.city",
            target = "city"
    ), @Mapping(
            source = "address.region",
            target = "region"
    ), @Mapping(
            source = "address.postalCode",
            target = "postalCode"
    ),
            @Mapping(source = "productList",target = "productList.products")
    })
    DepartmentDTO departmentToDepartmentDTO(Department department);

    @Mappings({@Mapping(
            source = "addressLine",
            target = "address.addressLine"
    ), @Mapping(
            source = "country",
            target = "address.country"
    ), @Mapping(
            source = "city",
            target = "address.city"
    ), @Mapping(
            source = "region",
            target = "address.region"
    ), @Mapping(
            source = "postalCode",
            target = "address.postalCode"
    ),
            @Mapping(source = "productList.products",target = "productList")
    })
    Department departmentDTOToDepartment(DepartmentDTO departmentDTO);

}
