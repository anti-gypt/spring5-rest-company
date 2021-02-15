package antigypt.springframework.Services;

import antigypt.springframework.api.v1.model.DepartmentDTO;
import antigypt.springframework.api.v1.model.EmployeeDTO;

import java.util.List;


public interface DepartmentService {
    DepartmentDTO createNewDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO findDepartmentById(Long id);
    List<DepartmentDTO> getAllDepartments();
    DepartmentDTO updateDepartmentByDTO(Long id,DepartmentDTO departmentDTO);
    void deleteDepartmentById(Long id);
    List<EmployeeDTO> getAllDepartmentEmployees(Long id);
    boolean isNew(DepartmentDTO departmentDTO);
}
