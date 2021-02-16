package antigypt.springframework.Services;

import antigypt.springframework.api.v1.mapper.DepartmentMapper;
import antigypt.springframework.api.v1.mapper.EmployeeMapper;
import antigypt.springframework.api.v1.model.DepartmentDTO;
import antigypt.springframework.domain.Address;
import antigypt.springframework.domain.Department;
import antigypt.springframework.domain.Employee;
import antigypt.springframework.repositories.DepartmentRepository;
import antigypt.springframework.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    private static final String PHONENUMBER = "12345678";
    private static final String EMAIL = "omid@gmail.com";
    private static final String DETAIL = "this is detail";
    private static final String ADDRESSLINE = "Elisenstarse 1";
    private static final String COUNTRY = "Austria";
    private static final String CITY = "Wien";
    private static final String POSTALCODE = "1230";
    private static final String REGION = "Liesing";
    private static final String UPDATED_ADDRESS_LINE = "Elisenstrasse 1";
    private static final String UPDATED_COUNTRY = "German";
    private static final String UPDATED_CITY = "Hamburg";
    private static final String UPDATED_EMAIL = "ali@gmail.com";
    private static final String UPDATED_POSTAL_CODE = "1120";
    private static final String UPDATED_REGION = "Wien mitte";
    private static final String UPDATED_PHONENUMBER = "87654321";
    private static final String BIRTH_DATE = LocalDate.of(1989,9,5).toString();
    private static final String HIRE_DATE = LocalDate.of(2012,9,5).toString();
    private static final String FIRST_NAME = "Omid";
    private static final String LAST_NAME = "Joukar";
    private static final String GENDER = "MALE";
    private static final String HOME_PHONE = "123456";
    private static final String MOBILE_PHONE = "1234567890";

    @Mock
    DepartmentRepository departmentRepository;
    @Mock
    EmployeeRepository employeeRepository;
    DepartmentMapper departmentMapper;
    EmployeeMapper employeeMapper;
    DepartmentService departmentService;

    Department savedReturnedDepartment;
    DepartmentDTO sendedDepartmentDTO;
    Address address;
    Employee employee1;
    Employee employee2;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        departmentMapper = DepartmentMapper.INSTANCE;
        employeeMapper = EmployeeMapper.INSTANCE;
        departmentService = new DepartmentServiceImpl(departmentMapper,employeeMapper,departmentRepository,employeeRepository);

        address = new Address();
        address.setAddressLine(ADDRESSLINE);
        address.setCity(CITY);
        address.setCountry(COUNTRY);
        address.setPostalCode(POSTALCODE);
        address.setRegion(REGION);

        employee1 = new Employee();
        employee1.setEmployeeId(1L);
        employee1.setFirstName(FIRST_NAME);
        employee1.setLastName(LAST_NAME);
        employee1.setBirthDate(LocalDate.of(1989,9,5));
        employee1.setHireDate(LocalDate.of(2012,9,5));
        employee1.setEmail(EMAIL);
        employee1.setHomePhone(HOME_PHONE);
        employee1.setMobilePhone(MOBILE_PHONE);
        employee1.setAddress(address);
        employee1.setDepartment(savedReturnedDepartment);

        employee2 = new Employee();
        employee2.setEmployeeId(1L);
        employee2.setFirstName(FIRST_NAME);
        employee2.setLastName(LAST_NAME);
        employee2.setBirthDate(LocalDate.of(1989,9,5));
        employee2.setHireDate(LocalDate.of(2012,9,5));
        employee2.setEmail(EMAIL);
        employee2.setHomePhone(HOME_PHONE);
        employee2.setMobilePhone(MOBILE_PHONE);
        employee2.setAddress(address);
        employee2.setDepartment(savedReturnedDepartment);

        savedReturnedDepartment = new Department();
        savedReturnedDepartment.setDepartmentId(1L);
        savedReturnedDepartment.setEmail(EMAIL);
        savedReturnedDepartment.setPhoneNumber(PHONENUMBER);
        savedReturnedDepartment.setDetail(DETAIL);
        savedReturnedDepartment.setAddress(address);
        savedReturnedDepartment.getEmployeeList().addAll(Arrays.asList(employee1,employee2));

        sendedDepartmentDTO = new DepartmentDTO();
        sendedDepartmentDTO.setAddressLine(ADDRESSLINE);
        sendedDepartmentDTO.setCity(CITY);
        sendedDepartmentDTO.setCountry(COUNTRY);
        sendedDepartmentDTO.setDetail(DETAIL);
        sendedDepartmentDTO.setEmail(EMAIL);
        sendedDepartmentDTO.setPhoneNumber(PHONENUMBER);
        sendedDepartmentDTO.setPostalCode(POSTALCODE);
        sendedDepartmentDTO.setRegion(REGION);
    }

    @Test
    void createNewDepartment() {
        when(departmentRepository.save(any(Department.class))).thenReturn(savedReturnedDepartment);
        DepartmentDTO savedReturnedDepartmentDTO = departmentService.createNewDepartment(sendedDepartmentDTO);
        assertEquals(savedReturnedDepartmentDTO.getEmployees().getEmployees().size() , savedReturnedDepartment.getEmployeeList().size());
    }

    @Test
    void findDepartmentById() {
    }

    @Test
    void getAllDepartments() {
    }

    @Test
    void updateDepartmentByDTO() {
    }

    @Test
    void deleteDepartmentById() {
    }

    @Test
    void getAllDepartmentEmployees() {
    }

    @Test
    void isNew() {
    }
}