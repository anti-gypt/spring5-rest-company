package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.EmployeeDTO;
import antigypt.springframework.domain.Employee;
import antigypt.springframework.qualifires.ListEmployeeDTOToListEmployee;
import antigypt.springframework.qualifires.LitEmployeeToListEmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mappings({@Mapping(
            source = "email",
            target = "email"
    ), @Mapping(
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
    ), @Mapping(
            source = "employeeList",
            target = "employees.employees",
            qualifiedBy = LitEmployeeToListEmployeeDTO.class
    ), @Mapping(
            source = "reportsTo",
            target = "reportsTo"
    ), @Mapping(
            source = "jobTitle",
            target = "jobTitle"
    ), @Mapping(
            source = "employeeSalary",
            target = "employeeSalary"
    ), @Mapping(
            source = "department",
            target = "department"
    ), @Mapping(
            source = "vehicle",
            target = "vehicle"
    )})
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    @Mappings({@Mapping(
            source = "email",
            target = "email"
    ), @Mapping(
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
    ), @Mapping(
            source = "employees.employees",
            target = "employeeList" ,
            qualifiedBy = ListEmployeeDTOToListEmployee.class
    ), @Mapping(
            source = "reportsTo",
            target = "reportsTo"
    ), @Mapping(
            source = "jobTitle",
            target = "jobTitle"
    ), @Mapping(
            source = "employeeSalary",
            target = "employeeSalary"
    ), @Mapping(
            source = "department",
            target = "department"
    ), @Mapping(
            source = "vehicle",
            target = "vehicle"
    )})
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);


    @ListEmployeeDTOToListEmployee
    List<Employee> listEmployeeDTOToListEmployee(List<EmployeeDTO> employees);

    @LitEmployeeToListEmployeeDTO
    List<EmployeeDTO> listEmployeeToListEmployeeDTO(List<Employee> employees);
}

