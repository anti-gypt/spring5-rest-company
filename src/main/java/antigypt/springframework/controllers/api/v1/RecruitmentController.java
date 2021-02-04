package antigypt.springframework.controllers.api.v1;

import antigypt.springframework.Services.RecruitmentService;
import antigypt.springframework.api.v1.model.RecruitmentDTO;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Controller
@RequestMapping(RecruitmentController.BASE_URL)
public class RecruitmentController {
    public static final String BASE_URL = "/api/v1/recruitments";
    public static final String RECRUITMENTS_RECRUITMENT_CV = "recruitments/recruitmentCV";
    private final RecruitmentService recruitmentService;
    public static final String CREATE_UPDATE_RECRUITMENT_FORM = "recruitments/recruitmentForm";
    public static final String RECRUITMENT_SHOW = "recruitments/show";

    public RecruitmentController(RecruitmentService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }
    @GetMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public String creatNewRecruitmentForm(Model model){
        model.addAttribute("recruitmentForm" , new RecruitmentDTO());
        return CREATE_UPDATE_RECRUITMENT_FORM;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String showRecruitmentDetails(@PathVariable Long id, Model model){
        model.addAttribute("recruitment", recruitmentService.findRecruitmentById(id));
        return RECRUITMENT_SHOW;
    }

    @PostMapping
    public String processCreationForm(@ModelAttribute RecruitmentDTO recruitmentDTO, BindingResult result){
        if (result.hasErrors()){

        }
        RecruitmentDTO savedRecruitmentDTO = recruitmentService.createNewRecruitmnet(recruitmentDTO);
        return "redirect:/api/v1/recruitments/"+savedRecruitmentDTO.getRecruitmentUrl().split("/")[4];
    }



    @SneakyThrows
    @GetMapping("/{id}/showimage")
    @ResponseStatus(HttpStatus.OK)
    public void showRecruitmentImage(@PathVariable Long id, HttpServletResponse response){
        RecruitmentDTO foundedRecruitmentDTO = recruitmentService.findRecruitmentById(id);
        byte[] getBytes = new byte[foundedRecruitmentDTO.getPhoto().length];
        int i = 0 ;
        for (byte b : foundedRecruitmentDTO.getPhoto()){
            getBytes[i++] = b;
        }
        InputStream is = new ByteArrayInputStream(getBytes);
        response.setContentType("image/jpeg");
        IOUtils.copy(is , response.getOutputStream());
    }

    @SneakyThrows
    @GetMapping("/{id}/showcv")
    @ResponseStatus(HttpStatus.OK)
    public void showRecruitmentCV(@PathVariable Long id, HttpServletResponse response){
        RecruitmentDTO foundedRecruitmentDTO = recruitmentService.findRecruitmentById(id);
        byte[] getBytes = new byte[foundedRecruitmentDTO.getCv().length];
        int i = 0 ;
        for (byte b : foundedRecruitmentDTO.getCv()){
            getBytes[i++] = b;
        }
        InputStream is = new ByteArrayInputStream(getBytes);
        response.setContentType("application/pdf");
        IOUtils.copy(is , response.getOutputStream());
    }


    @SneakyThrows
    @GetMapping("/{id}/processcv")
    @ResponseStatus(HttpStatus.OK)
    public String processShowRecruitmentCV(@PathVariable Long id, Model model){
        model.addAttribute("recruitment" , recruitmentService.findRecruitmentById(id));
        return RECRUITMENTS_RECRUITMENT_CV;
    }
}
