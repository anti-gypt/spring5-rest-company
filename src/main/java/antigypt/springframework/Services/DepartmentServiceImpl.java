package antigypt.springframework.Services;

import antigypt.springframework.api.v1.mapper.DepartmentMapper;
import antigypt.springframework.api.v1.mapper.EmployeeMapper;
import antigypt.springframework.api.v1.model.DepartmentDTO;
import antigypt.springframework.api.v1.model.EmployeeDTO;
import antigypt.springframework.domain.Department;
import antigypt.springframework.exceptions.ResourceNotFoundException;
import antigypt.springframework.repositories.DepartmentRepository;
import antigypt.springframework.repositories.EmployeeRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;
    private final EmployeeMapper employeeMapper;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper, EmployeeMapper employeeMapper, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentMapper = departmentMapper;
        this.employeeMapper = employeeMapper;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DepartmentDTO createNewDepartment(DepartmentDTO departmentDTO) {
        Department savedDepartment =  departmentRepository.save(departmentMapper.departmentDTOToDepartment(departmentDTO));
        DepartmentDTO savedDepartmentDTO = departmentMapper.departmentToDepartmentDTO(savedDepartment);
        savedDepartmentDTO.setDepartmetnUrl("/api/v1/departments/"+savedDepartment.getDepartmentId());
        return savedDepartmentDTO;
    }

    @SneakyThrows
    @Override
    public DepartmentDTO findDepartmentById(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (!optionalDepartment.isPresent()){
            throw new ResourceNotFoundException("id is invalid : " + id);
        }
        Department foundedDepartment = optionalDepartment.get();
        DepartmentDTO foundedDepartmentDTO  = departmentMapper.departmentToDepartmentDTO(foundedDepartment);
        foundedDepartmentDTO.setDepartmetnUrl("/api/v1/departments"+ foundedDepartment.getDepartmentId());
        return foundedDepartmentDTO;
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream().map(department -> {
            DepartmentDTO departmentDTO = departmentMapper.departmentToDepartmentDTO(department);
            departmentDTO.setDepartmetnUrl("/api/v1/departments/"+department.getDepartmentId());
            return departmentDTO;
        }).collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public DepartmentDTO updateDepartmentByDTO(Long id, DepartmentDTO departmentDTO) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (!departmentOptional.isPresent()){
            throw new ResourceNotFoundException("Id is invalid : " + id);
        }
        Department department = departmentOptional.get();
        department.setDepartmentId(id);
        department.setPhoneNumber(departmentDTO.getPhoneNumber());
        department.setEmail(departmentDTO.getEmail());
        department.getAddress().setAddressLine(departmentDTO.getAddressLine());
        department.getAddress().setCity(departmentDTO.getCity());
        department.getAddress().setRegion(departmentDTO.getRegion());
        department.getAddress().setPostalCode(departmentDTO.getPostalCode());
        department.getAddress().setPostalCode(departmentDTO.getCountry());
        DepartmentDTO updatedDepartmentDTO = departmentMapper.departmentToDepartmentDTO(departmentRepository.save(department));
        updatedDepartmentDTO.setDepartmetnUrl("/api/v1/departments"+department.getDepartmentId());
        return updatedDepartmentDTO;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);

    }

    @Override
    public List<EmployeeDTO> getAllDepartmentEmployees(Long id) {

        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getDepartment().getDepartmentId().equals(id))
                .map(employee -> {
                    EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);
                    employeeDTO.setEmployeeUrl("/api/v1/employees/"+employee.getEmployeeId());
                    return employeeDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public boolean isNew(DepartmentDTO departmentDTO) {
        boolean isObjectNew = true;
        List<DepartmentDTO> departmentDTOList = getAllDepartments();
        for (DepartmentDTO object : departmentDTOList){
            if (object.getEmail().equals(departmentDTO.getEmail())){
                isObjectNew = false;
                break;
            }
        }
        return isObjectNew;
    }
}
