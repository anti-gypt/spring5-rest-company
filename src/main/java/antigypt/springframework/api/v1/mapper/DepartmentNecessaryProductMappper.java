package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.DepartmentNecessaryProductDTO;
import antigypt.springframework.domain.DepartmentNecessaryProduct;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentNecessaryProductMappper extends ProductMapper {
    DepartmentNecessaryProductMappper INSTANCE = Mappers.getMapper(DepartmentNecessaryProductMappper.class);

    DepartmentNecessaryProduct departmentNecessaryProductDTOToDepartmentNecessaryProduct(DepartmentNecessaryProductDTO departmentNecessaryProductDTO);
    DepartmentNecessaryProductDTO departmentNecessaryProductToDepartmentNecessaryProductDTO(DepartmentNecessaryProduct departmentNecessaryProduct);
}
