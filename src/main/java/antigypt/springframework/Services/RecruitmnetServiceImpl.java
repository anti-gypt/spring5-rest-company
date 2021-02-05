package antigypt.springframework.Services;

import antigypt.springframework.api.v1.mapper.RecruitmentMapper;
import antigypt.springframework.api.v1.model.RecruitmentDTO;
import antigypt.springframework.controllers.api.v1.RecruitmentController;
import antigypt.springframework.domain.Recruitment;
import antigypt.springframework.exceptions.ResourceNotFoundException;
import antigypt.springframework.repositories.RecruitmentRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class RecruitmnetServiceImpl implements RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final RecruitmentMapper recruitmentMapper;

    public RecruitmnetServiceImpl(RecruitmentRepository recruitmentRepository, RecruitmentMapper recruitmentMapper) {
        this.recruitmentRepository = recruitmentRepository;
        this.recruitmentMapper = recruitmentMapper;
    }
    @SneakyThrows
    @Override
    public RecruitmentDTO findRecruitmentById(Long id) {
        Optional<Recruitment> recruitmentOptional = recruitmentRepository.findById(id);
        if (!recruitmentOptional.isPresent()){
            log.info("Recruitment not found : " + id);
            throw new ResourceNotFoundException("Id is invalid : " + id);
        }
        Recruitment recruitment = recruitmentOptional.get();
        RecruitmentDTO returnedDTO = recruitmentMapper.recruitmentToRecruitmentDTO(recruitment);
        returnedDTO.setRecruitmentUrl(RecruitmentController.BASE_URL+"/"+recruitment.getRecruitmentId());
        return returnedDTO;
    }

    @Override
    public RecruitmentDTO createNewRecruitmnet(RecruitmentDTO recruitmentDTO) {

        Recruitment toBeSaved = recruitmentMapper.recruitmnetDTOToRecruitment(recruitmentDTO);
        Recruitment savedRecruitment = recruitmentRepository.save(toBeSaved);
        RecruitmentDTO returnedDTO = recruitmentMapper.recruitmentToRecruitmentDTO(savedRecruitment);
        recruitmentDTO.setRecruitmentUrl(RecruitmentController.BASE_URL+"/" +savedRecruitment.getRecruitmentId());
        return recruitmentDTO ;
    }


}
