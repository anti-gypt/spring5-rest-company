package antigypt.springframework.controllers.api.v1;

import antigypt.springframework.Services.RecruitmentService;
import antigypt.springframework.api.v1.model.RecruitmentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(RecruitmentController.BASE_URL)
public class RecruitmentController {
    public static final String BASE_URL = "/api/v1/recruitments";
    private final RecruitmentService recruitmentService;
    private static final String CREATE_UPDATE_RECRUITMENT_FORM = "recruitments/recruitmentForm";
    private static final String RECRUITMENT_SHOW = "recruitments/show";

    public RecruitmentController(RecruitmentService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }
    @GetMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public String creatNewRecruitmentForm(Model model){
        model.addAttribute("recruitmentForm" , new RecruitmentDTO());
        return CREATE_UPDATE_RECRUITMENT_FORM;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String processCreationForm(@ModelAttribute RecruitmentDTO recruitmentDTO,
                                      @RequestParam("imagefile") MultipartFile imageFile ,
                                      @RequestParam("cvfile") MultipartFile cvFile){
        RecruitmentDTO savedRecruitmentDTO = recruitmentService.createNewRecruitmnet(recruitmentDTO,imageFile,cvFile);
        return RECRUITMENT_SHOW;
    }

}
