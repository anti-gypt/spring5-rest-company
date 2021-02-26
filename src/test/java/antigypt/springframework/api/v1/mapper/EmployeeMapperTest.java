package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.EmployeeDTO;
import antigypt.springframework.domain.Address;
import antigypt.springframework.domain.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    private static final String EMAIL = "omid@gmail.com";
    private static final String DETAIL = "this is detail";
    private static final String ADDRESSLINE = "Elisenstarse 1";
    private static final String COUNTRY = "Austria";
    private static final String CITY = "Wien";
    private static final String POSTALCODE = "1230";
    private static final String REGION = "Liesing";
    private static final String FIRST_NAME = "Omid";
    private static final String LAST_NAME = "Joukar";
    private static final String GENDER = "MALE";
    private static final String HOME_PHONE = "123456";
    private static final String MOBILE_PHONE = "1234567890";
    EmployeeMapper employeeMapper;
    Employee employee1;
    Address address;
    Employee employee2;
    @BeforeEach
    void setUp() {
        employeeMapper = EmployeeMapper.INSTANCE;

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
        employee1.getEmployeeList().add(employee2);


    }
    @Test
    public void convertEmployeeToEmployeeDTO(){
        EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employee1);
        assertNotNull(employeeDTO);

    }
    @Test
    public void testEmployeeListEmployeeListDto(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        List<EmployeeDTO> employeeDTOList = employeeMapper.listEmployeeToListEmployeeDTO(employeeList);
        assertNotNull(employeeDTOList);
    }
}