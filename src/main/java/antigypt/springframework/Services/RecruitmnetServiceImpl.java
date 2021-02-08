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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
    public List<RecruitmentDTO> getAllRecruitments() {
        return recruitmentRepository.findAll().stream()
                .map(recruitment -> {
                    RecruitmentDTO returnedDto = recruitmentMapper.recruitmentToRecruitmentDTO(recruitment);
                    returnedDto.setRecruitmentUrl(RecruitmentController.BASE_URL+"/"+recruitment.getRecruitmentId());
                    return returnedDto;
                }).collect(Collectors.toList());
    }

    @Override
    public RecruitmentDTO createNewRecruitmnet(RecruitmentDTO recruitmentDTO) {
        Recruitment toBeSaved = recruitmentMapper.recruitmnetDTOToRecruitment(recruitmentDTO);
        Recruitment savedRecruitment = recruitmentRepository.save(toBeSaved);
        RecruitmentDTO returnedDTO = recruitmentMapper.recruitmentToRecruitmentDTO(savedRecruitment);
        returnedDTO.setRecruitmentUrl(RecruitmentController.BASE_URL+"/" +savedRecruitment.getRecruitmentId());
        return returnedDTO ;
    }

    @Override
    public void deleteRecruitmentById(Long id) {
        recruitmentRepository.deleteById(id);
    }

    @Override
    public boolean isNew(RecruitmentDTO recruitmentDTO) {
        boolean isObjectNew = true;
        for (RecruitmentDTO recruitmentDTO1 : getAllRecruitments()) {
            if (recruitmentDTO.getFirstName().equals(recruitmentDTO1.getFirstName()) &&
                    recruitmentDTO.getLastName().equals(recruitmentDTO1.getLastName()) &&
                    recruitmentDTO.getBirthDate().equals(recruitmentDTO1.getBirthDate())) {
                isObjectNew = false;
                break;
            }
        }
        return isObjectNew;
    }
}
