package antigypt.springframework.repositories;

import antigypt.springframework.domain.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitmentRepository extends JpaRepository<Recruitment,Long> {
}
