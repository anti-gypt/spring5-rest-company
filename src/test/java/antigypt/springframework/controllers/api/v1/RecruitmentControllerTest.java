package antigypt.springframework.controllers.api.v1;

import antigypt.springframework.Services.RecruitmentService;
import antigypt.springframework.api.v1.model.RecruitmentDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.io.IOException;
import java.time.LocalDate;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RecruitmentControllerTest {

    private static final String ADDRESS_LINE = "Elisenstarse 1";
    private static final String COUNTRY = "Austria";
    private static final String APPLICATION_DATE = LocalDate.now().toString();
    private static final String BIRTH_DATE = LocalDate.now().toString();
    private static final String CITY = "Wien";
    private static final Double DESIRED_SALARY = 1000.0;
    private static final String DETAIL = "this is detail";
    private static final String EMAIL = "omid@gmail.com";
    private static final String FIRST_NAME = "Omid";
    private static final String LAST_NAME = "Joukar";
    private static final String GENDER = "MALE";
    private static final String HOME_PHONE = "123";
    private static final String MOBILE_PHONE = "123";
    private static final String POSTAL_CODE = "1230";
    private static final String REGION = "Liesing";
    private static final String TITLE = "ING";
    private static final MockMultipartFile SENDED_IMAGE =
            new MockMultipartFile("imagefile","imagefile","text.txt","this si a byte sample".getBytes());
    private static final MockMultipartFile SENDED_CV =
            new MockMultipartFile("cvfile","cvfile","text.txt","this si a byte sample".getBytes());

    @Mock
    RecruitmentService recruitmentService;
    @InjectMocks
    RecruitmentController recruitmentController;
    MockMvc mockMvc;
    Byte[] getBytes;

    RecruitmentDTO returnedRecruitmentDTO;
    
    @BeforeEach
    void setUp() throws IOException {
        mockMvc = MockMvcBuilders.standaloneSetup(recruitmentController).build();
        getBytes = new Byte[SENDED_IMAGE.getBytes().length];
        int i =0 ;
        for (byte b : SENDED_IMAGE.getBytes()){
            getBytes[i++] = b;
        }
        
        returnedRecruitmentDTO = new RecruitmentDTO();
        returnedRecruitmentDTO.setAddressLine(ADDRESS_LINE);
        returnedRecruitmentDTO.setApplicationDate(APPLICATION_DATE);
        returnedRecruitmentDTO.setBirthDate(BIRTH_DATE);
        returnedRecruitmentDTO.setCity(CITY);
        returnedRecruitmentDTO.setCountry(COUNTRY);
        returnedRecruitmentDTO.setDesiredSalary(DESIRED_SALARY);
        returnedRecruitmentDTO.setCv(getBytes);
        returnedRecruitmentDTO.setDetail(DETAIL);
        returnedRecruitmentDTO.setEmail(EMAIL);
        returnedRecruitmentDTO.setFirstName(FIRST_NAME);
        returnedRecruitmentDTO.setGender(GENDER);
        returnedRecruitmentDTO.setHomePhone(HOME_PHONE);
        returnedRecruitmentDTO.setLastName(LAST_NAME);
        returnedRecruitmentDTO.setMobilePhone(MOBILE_PHONE);
        returnedRecruitmentDTO.setPhoto(getBytes);
        returnedRecruitmentDTO.setPostalCode(POSTAL_CODE);
        returnedRecruitmentDTO.setRegion(REGION);
        returnedRecruitmentDTO.setTitle(TITLE);
        returnedRecruitmentDTO.setRecruitmentUrl(RecruitmentController.BASE_URL+"/1");
    }

    @Test
    void creatNewRecruitmentForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(RecruitmentController.BASE_URL+"/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("recruitmentForm"))
                .andExpect(view().name(RecruitmentController.CREATE_UPDATE_RECRUITMENT_FORM));
    }

    @Test
    void showRecruitmentDetails() throws Exception {
        when(recruitmentService.findRecruitmentById(anyLong())).thenReturn(returnedRecruitmentDTO);
        mockMvc.perform(get(RecruitmentController.BASE_URL+"/1"))
                .andExpect(status().isOk())
                .andExpect(view().name(RecruitmentController.RECRUITMENT_SHOW))
                .andExpect(model().attributeExists("recruitment"))
                .andExpect(model().attribute("recruitment",
                        hasProperty("firstName", equalTo(FIRST_NAME))))
                .andExpect(model().attribute("recruitment",
                        hasProperty("lastName", equalTo(LAST_NAME))))
                .andExpect(model().attribute("recruitment",
                        hasProperty("recruitmentUrl", equalTo(RecruitmentController.BASE_URL+"/1"))))
                .andExpect(model().attribute("recruitment"
                        ,hasProperty("desiredSalary",  equalTo(DESIRED_SALARY))));

    }

    @Test
    void processCreationForm() throws Exception {
        when(recruitmentService.createNewRecruitmnet(any(RecruitmentDTO.class))).thenReturn(returnedRecruitmentDTO);
        mockMvc.perform(post(RecruitmentController.BASE_URL)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("firstName" , "Omid")
        .param("lastName" , "Jouakr"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:"+RecruitmentController.BASE_URL+"/1"));
        verify(recruitmentService,times(1)).createNewRecruitmnet(any());

    }


    @Test
    void showRecruitmentImage() throws Exception {
        when(recruitmentService.findRecruitmentById(anyLong())).thenReturn(returnedRecruitmentDTO);
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/recruitments/1/showimage"))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        byte[] responseAsByteArray = response.getContentAsByteArray();
        assertNotNull(responseAsByteArray);
        assertEquals(responseAsByteArray.length,getBytes.length);

    }

    @Test
    void showRecruitmentCV() throws Exception {
        when(recruitmentService.findRecruitmentById(anyLong())).thenReturn(returnedRecruitmentDTO);
        MockHttpServletResponse response = mockMvc.perform(get("/api/v1/recruitments/1/showcv"))
                .andExpect(status().isOk())
                .andReturn().getResponse();
        byte[] responseAsByteArray = response.getContentAsByteArray();
        assertNotNull(responseAsByteArray);
        assertEquals(responseAsByteArray.length,getBytes.length);
    }

    @Test
    void processShowRecruitmentCV() throws Exception {
        when(recruitmentService.findRecruitmentById(anyLong())).thenReturn(returnedRecruitmentDTO);
        mockMvc.perform(get(RecruitmentController.BASE_URL+"/1/processcv"))
                .andExpect(status().isOk())
                .andExpect(view().name(RecruitmentController.RECRUITMENTS_RECRUITMENT_CV))
                .andExpect(model().attributeExists("recruitment"))
                .andExpect(model().attribute("recruitment",
                        hasProperty("firstName", equalTo(FIRST_NAME))))
                .andExpect(model().attribute("recruitment",
                        hasProperty("lastName", equalTo(LAST_NAME))))
                .andExpect(model().attribute("recruitment",
                        hasProperty("recruitmentUrl", equalTo(RecruitmentController.BASE_URL+"/1"))))
                .andExpect(model().attribute("recruitment"
                        ,hasProperty("desiredSalary",  equalTo(DESIRED_SALARY))));
    }
}