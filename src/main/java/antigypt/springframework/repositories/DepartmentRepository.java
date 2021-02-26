package antigypt.springframework.repositories;

import antigypt.springframework.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department , Long> {
    List<Department> findAllByEmail(String email);
}
