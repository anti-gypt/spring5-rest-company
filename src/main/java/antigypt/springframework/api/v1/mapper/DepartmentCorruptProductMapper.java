package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.DepartmentCorruptProductDTO;
import antigypt.springframework.domain.DepartmentCorruptProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentCorruptProductMapper {
    DepartmentCorruptProductMapper INSTANCE = Mappers.getMapper(DepartmentCorruptProductMapper.class);
    @Mappings({
            @Mapping(source = "department.addressLine",target = "department.address.addressLine"),
            @Mapping(source = "department.postalCode",target = "department.address.postalCode"),
            @Mapping(source = "department.country",target = "department.address.country"),
            @Mapping(source = "department.region",target = "department.address.region"),
            @Mapping(source = "department.city",target = "department.address.city"),
    })
    DepartmentCorruptProduct departmentCorruptProductDTOToDepartmentCorruptProduct(DepartmentCorruptProductDTO departmentCorruptProductDTO);
    @Mappings({
            @Mapping(source = "department.address.addressLine",target = "department.addressLine"),
            @Mapping(source = "department.address.postalCode",target = "department.postalCode"),
            @Mapping(source = "department.address.country",target = "department.country"),
            @Mapping(source = "department.address.region",target = "department.region"),
            @Mapping(source = "department.address.city",target = "department.city"),
    })
    DepartmentCorruptProductDTO departmentCorruptProductToDepartmentCorruptProductDTO(DepartmentCorruptProduct departmentCorruptProduct);
}
