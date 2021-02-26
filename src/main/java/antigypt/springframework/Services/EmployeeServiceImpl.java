package antigypt.springframework.Services;

import antigypt.springframework.api.v1.mapper.DepartmentMapper;
import antigypt.springframework.api.v1.mapper.EmployeeMapper;
import antigypt.springframework.api.v1.model.EmployeeDTO;
import antigypt.springframework.domain.Department;
import antigypt.springframework.domain.Employee;
import antigypt.springframework.exceptions.ResourceNotFoundException;
import antigypt.springframework.repositories.DepartmentRepository;
import antigypt.springframework.repositories.EmployeeRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @SneakyThrows
    @Override
    public EmployeeDTO createNewEmployee(Long departmentId , EmployeeDTO employeeDTO) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (!optionalDepartment.isPresent()){
            throw new ResourceNotFoundException("invalid id : "+ departmentId);
        }
        Department foundedDepartment = optionalDepartment.get();
        Employee savedEmployee = employeeRepository.save(employeeMapper.employeeDTOToEmployee(employeeDTO));
        foundedDepartment.getEmployeeList().add(savedEmployee);
        departmentRepository.save(foundedDepartment);
        EmployeeDTO returnedEmployeeDTO = employeeMapper.employeeToEmployeeDTO(savedEmployee);
        returnedEmployeeDTO.setEmployeeUrl("/api/v1/employees/"+savedEmployee.getEmployeeId());
        return returnedEmployeeDTO;
    }

    @Override
    public EmployeeDTO findEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        System.out.println();
        return null;
    }

    @Override
    public EmployeeDTO updateEmployeeByDTO(Long id, EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Long id) {

    }

    @Override
    public List<EmployeeDTO> getAllEmployeesOfEmployee(Long id) {
        return null;
    }

    @Override
    public boolean isNew(EmployeeDTO employeeDTO) {
        return false;
    }

    @Override
    public List<EmployeeDTO> findEmployeeByName(String EmployeeName) {
        return null;
    }
}
