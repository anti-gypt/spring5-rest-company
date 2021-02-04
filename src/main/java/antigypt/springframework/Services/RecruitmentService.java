package antigypt.springframework.Services;

import antigypt.springframework.api.v1.model.RecruitmentDTO;


public interface RecruitmentService {
    RecruitmentDTO createNewRecruitmnet(RecruitmentDTO recruitmentDTO);
    RecruitmentDTO findRecruitmentById(Long id);
}
