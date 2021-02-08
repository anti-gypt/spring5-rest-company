package antigypt.springframework.Services;

import antigypt.springframework.api.v1.model.RecruitmentDTO;


import java.util.List;


public interface RecruitmentService {
    RecruitmentDTO createNewRecruitmnet(RecruitmentDTO recruitmentDTO);
    RecruitmentDTO findRecruitmentById(Long id);
    List<RecruitmentDTO> getAllRecruitments();
    boolean isNew(RecruitmentDTO recruitmentDTO);

    void deleteRecruitmentById(Long id);
}
