package antigypt.springframework.Services;

import antigypt.springframework.api.v1.mapper.RecruitmentMapper;
import antigypt.springframework.api.v1.model.RecruitmentDTO;
import antigypt.springframework.controllers.api.v1.RecruitmentController;
import antigypt.springframework.domain.Recruitment;
import antigypt.springframework.repositories.RecruitmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class RecruitmnetServiceImpl implements RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final RecruitmentMapper recruitmentMapper;

    public RecruitmnetServiceImpl(RecruitmentRepository recruitmentRepository, RecruitmentMapper recruitmentMapper) {
        this.recruitmentRepository = recruitmentRepository;
        this.recruitmentMapper = recruitmentMapper;
    }

    @Override
    public RecruitmentDTO createNewRecruitmnet(RecruitmentDTO recruitmentDTO, MultipartFile imageFile , MultipartFile cvFile) {
        try {
            Byte[] getBytes = new Byte[imageFile.getBytes().length];
            int i = 0 ;
            for (byte b : imageFile.getBytes()){
                getBytes[i++] = b;
            }
            recruitmentDTO.setPhoto(getBytes);
            getBytes = new Byte[cvFile.getBytes().length];
            int j = 0 ;
            for (byte b : cvFile.getBytes()){
                getBytes[j++] = b;
            }
            recruitmentDTO.setCv(getBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Recruitment toBeSaved = recruitmentMapper.recruitmnetDTOToRecruitment(recruitmentDTO);
        Recruitment savedRecruitment = recruitmentRepository
                .save(toBeSaved);
        RecruitmentDTO returnedDTO = recruitmentMapper.recruitmentToRecruitmentDTO(savedRecruitment);
        recruitmentDTO.setRecruitmentUrl(RecruitmentController.BASE_URL+"/" +savedRecruitment.getRecruitmentId());
        return recruitmentDTO ;
    }
}
