package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.DepartmentNecessaryProductDTO;
import antigypt.springframework.domain.DepartmentNecessaryProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentNecessaryProductMappper {
    DepartmentNecessaryProductMappper INSTANCE = Mappers.getMapper(DepartmentNecessaryProductMappper.class);
    @Mappings({
            @Mapping(source = "department.addressLine",target = "department.address.addressLine"),
            @Mapping(source = "department.postalCode",target = "department.address.postalCode"),
            @Mapping(source = "department.country",target = "department.address.country"),
            @Mapping(source = "department.region",target = "department.address.region"),
            @Mapping(source = "department.city",target = "department.address.city"),
    })
    DepartmentNecessaryProduct departmentNecessaryProductDTOToDepartmentNecessaryProduct(DepartmentNecessaryProductDTO departmentNecessaryProductDTO);
    @Mappings({
            @Mapping(source = "department.address.addressLine",target = "department.addressLine"),
            @Mapping(source = "department.address.postalCode",target = "department.postalCode"),
            @Mapping(source = "department.address.country",target = "department.country"),
            @Mapping(source = "department.address.region",target = "department.region"),
            @Mapping(source = "department.address.city",target = "department.city"),
    })
    DepartmentNecessaryProductDTO departmentNecessaryProductToDepartmentNecessaryProductDTO(DepartmentNecessaryProduct departmentNecessaryProduct);
}
