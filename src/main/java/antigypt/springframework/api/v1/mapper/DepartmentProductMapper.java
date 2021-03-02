package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.DepartmentProductDTO;
import antigypt.springframework.domain.DepartmentProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentProductMapper {
    DepartmentProductMapper INSTANCE = Mappers.getMapper(DepartmentProductMapper.class);
    DepartmentProduct departmentProductDTOToDepartmentProduct(DepartmentProductDTO departmentProductDTO);
    DepartmentProductDTO departmentProductToDepartmentProductDTO(DepartmentProduct departmentProduct);

}
