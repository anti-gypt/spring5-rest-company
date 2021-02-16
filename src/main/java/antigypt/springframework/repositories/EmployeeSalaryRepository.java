package antigypt.springframework.repositories;

import antigypt.springframework.domain.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary , Long> {
}
