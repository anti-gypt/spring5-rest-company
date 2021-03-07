package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.EmployeeSalaryDTO;
import antigypt.springframework.domain.EmployeeSalary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeSalaryMapper {
    EmployeeSalaryMapper INSTANCE = Mappers.getMapper(EmployeeSalaryMapper.class);

    @Mappings({@Mapping(
                    source="employee",
                    target = "employee"),
            @Mapping(
                    source = "employee.department.productList.products",
                    target = "employee.department.productList"),
            @Mapping(
                    source ="employee.department" ,
                    target ="employee.department")

            })
    EmployeeSalary employeeSalaryDTOToEmployeeSalary(EmployeeSalaryDTO employeeSalaryDTO);

    @Mappings({@Mapping(
                    source= "employee",
                    target = "employee"),
            @Mapping(
                    source = "employee.department.productList",
                    target = "employee.department.productList.products"),
            @Mapping(
                    source ="employee.department" ,
                    target ="employee.department")
    })
    EmployeeSalaryDTO employeeSalaryToEmployeeSalaryDTO(EmployeeSalary employeeSalary);
}