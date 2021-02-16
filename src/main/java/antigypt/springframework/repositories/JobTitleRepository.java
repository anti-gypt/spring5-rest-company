package antigypt.springframework.repositories;

import antigypt.springframework.domain.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle , Long> {
}
