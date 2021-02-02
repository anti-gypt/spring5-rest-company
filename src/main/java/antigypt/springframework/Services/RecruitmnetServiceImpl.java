package antigypt.springframework.Services;

import antigypt.springframework.repositories.RecruitmentRepository;
import org.springframework.stereotype.Service;

@Service
public class RecruitmnetServiceImpl implements RecruitmentService {
    public RecruitmnetServiceImpl(RecruitmentRepository recruitmentRepository) {
        this.recruitmentRepository = recruitmentRepository;
    }

    private final RecruitmentRepository recruitmentRepository;

}
