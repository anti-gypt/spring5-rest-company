package antigypt.springframework.Services;

import antigypt.springframework.api.v1.model.RecruitmentDTO;
import org.springframework.web.multipart.MultipartFile;

public interface RecruitmentService {
    RecruitmentDTO createNewRecruitmnet(RecruitmentDTO recruitmentDTO, MultipartFile imageFile , MultipartFile cvFile);
}
