package antigypt.springframework.repositories;


import antigypt.springframework.domain.DepartmentCorruptProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentCorruptProductRepository extends JpaRepository<DepartmentCorruptProduct, Long> {

}
