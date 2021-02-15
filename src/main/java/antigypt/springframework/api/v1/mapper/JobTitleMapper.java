package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.EmployeeDTO;
import antigypt.springframework.api.v1.model.JobTitleDTO;
import antigypt.springframework.domain.Employee;
import antigypt.springframework.domain.JobTitle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JobTitleMapper {
    JobTitleMapper INSTANCE = (JobTitleMapper) Mappers.getMapper(JobTitleMapper.class);

    @Mapping(
            source = "employeeList",
            target = "employees.employees"
    )
    JobTitleDTO jobTitleToJobTitleDTO(JobTitle jobTitle);

    @Mapping(
            source = "employees.employees",
            target = "employeeList"
    )
    JobTitle jobTitleDTOToJobTitle(JobTitleDTO jobTitleDTO);

    List<EmployeeDTO> listEmployeeToListEmployeeDTO(List<Employee> employees);

    List<Employee> listEmployeeDTOToListEmployee(List<EmployeeDTO> employees);
}
