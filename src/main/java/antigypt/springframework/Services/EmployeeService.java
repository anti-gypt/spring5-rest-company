package antigypt.springframework.Services;

import antigypt.springframework.api.v1.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO createNewEmployee(Long departmentId,EmployeeDTO  employeeDTO);
    EmployeeDTO  findEmployeeById(Long id);
    List<EmployeeDTO > getAllEmployees();
    EmployeeDTO  updateEmployeeByDTO(Long id,EmployeeDTO employeeDTO);
    void deleteEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployeesOfEmployee(Long id);
    boolean isNew(EmployeeDTO  employeeDTO );
    List<EmployeeDTO > findEmployeeByName(String EmployeeName);
}
