package antigypt.springframework.repositories;

import antigypt.springframework.domain.DepartmentNecessaryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentNecessaryProductRepository extends JpaRepository<DepartmentNecessaryProduct ,Long> {
}
