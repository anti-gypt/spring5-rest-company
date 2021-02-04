package antigypt.springframework.Services;

import antigypt.springframework.api.v1.mapper.RecruitmentMapper;
import antigypt.springframework.api.v1.model.RecruitmentDTO;
import antigypt.springframework.controllers.api.v1.RecruitmentController;
import antigypt.springframework.domain.Address;
import antigypt.springframework.domain.Gender;
import antigypt.springframework.domain.Recruitment;
import antigypt.springframework.domain.Title;
import antigypt.springframework.repositories.RecruitmentRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class RecruitmnetServiceImplTest {
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
    RecruitmentRepository recruitmentRepository;
    RecruitmentMapper recruitmentMapper = RecruitmentMapper.INSTANCE;
    RecruitmnetServiceImpl recruitmentService;
    Byte[] getBytes;
    @SneakyThrows
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recruitmentService = new RecruitmnetServiceImpl(recruitmentRepository,recruitmentMapper);
         getBytes = new Byte[SENDED_IMAGE.getBytes().length];
        int i = 0 ;
        for (byte b : SENDED_IMAGE.getBytes()){
            getBytes[i++] = b;
        }

    }

    @Test
    void createNewRecruitmnet() throws IOException {

       Address address = new Address();
       address.setAddressLine(ADDRESS_LINE);
       address.setCity(CITY);
       address.setCountry(COUNTRY);
       address.setPostalCode(POSTAL_CODE);
       address.setRegion(REGION);
       Recruitment saveRec  = new Recruitment();
       saveRec.setRecruitmentId(1L);
       saveRec.setAddress(address);
       saveRec.setApplicationDate(LocalDate.now());
       saveRec.setBirthDate(LocalDate.now());
       saveRec.setDesiredSalary(DESIRED_SALARY);
       saveRec.setCv(getBytes);
       saveRec.setDetail(DETAIL);
       saveRec.setEmail(EMAIL);
       saveRec.setFirstName(FIRST_NAME);
       saveRec.setGender(Gender.MALE);
       saveRec.setHomePhone(HOME_PHONE);
       saveRec.setLastName(LAST_NAME);
       saveRec.setMobilePhone(MOBILE_PHONE);
       saveRec.setPhoto(getBytes);
       saveRec.setTitle(Title.ING);

       RecruitmentDTO retRec  = new RecruitmentDTO();
       retRec.setAddressLine(ADDRESS_LINE);
       retRec.setApplicationDate(APPLICATION_DATE);
       retRec.setBirthDate(BIRTH_DATE);
       retRec.setCity(CITY);
       retRec.setCountry(COUNTRY);
       retRec.setDesiredSalary(DESIRED_SALARY);
       retRec.setCv(getBytes);
       retRec.setDetail(DETAIL);
       retRec.setEmail(EMAIL);
       retRec.setFirstName(FIRST_NAME);
       retRec.setGender(GENDER);
       retRec.setHomePhone(HOME_PHONE);
       retRec.setLastName(LAST_NAME);
       retRec.setMobilePhone(MOBILE_PHONE);
       retRec.setPhoto(getBytes);
       retRec.setPostalCode(POSTAL_CODE);
       retRec.setRegion(REGION);
       retRec.setTitle(TITLE);
       when(recruitmentRepository.save(any(Recruitment.class))).thenReturn(saveRec);
       RecruitmentDTO savedReturnedDTO = recruitmentService.createNewRecruitmnet(retRec);
       assertEquals(savedReturnedDTO.getCv().length,SENDED_CV.getBytes().length);
       assertEquals(savedReturnedDTO.getPhoto().length,SENDED_IMAGE.getBytes().length);
       assertEquals(savedReturnedDTO.getFirstName(),saveRec.getFirstName());
       assertEquals(RecruitmentController.BASE_URL+"/1",savedReturnedDTO.getRecruitmentUrl());
    }

    @SneakyThrows
    @Test
    void findRecruitmentById() {
        Address address = new Address();
        address.setAddressLine(ADDRESS_LINE);
        address.setCity(CITY);
        address.setCountry(COUNTRY);
        address.setPostalCode(POSTAL_CODE);
        address.setRegion(REGION);
        Recruitment foundedRec  = new Recruitment();
        foundedRec.setRecruitmentId(1L);
        foundedRec.setAddress(address);
        foundedRec.setApplicationDate(LocalDate.now());
        foundedRec.setBirthDate(LocalDate.now());
        foundedRec.setDesiredSalary(DESIRED_SALARY);
        foundedRec.setCv(getBytes);
        foundedRec.setDetail(DETAIL);
        foundedRec.setEmail(EMAIL);
        foundedRec.setFirstName(FIRST_NAME);
        foundedRec.setGender(Gender.MALE);
        foundedRec.setHomePhone(HOME_PHONE);
        foundedRec.setLastName(LAST_NAME);
        foundedRec.setMobilePhone(MOBILE_PHONE);
        foundedRec.setPhoto(getBytes);
        foundedRec.setTitle(Title.ING);
        when(recruitmentRepository.findById(anyLong())).thenReturn(Optional.of(foundedRec));
        RecruitmentDTO returnedDTO = recruitmentService.findRecruitmentById(1L);
        assertEquals(returnedDTO.getCv().length,SENDED_CV.getBytes().length);
        assertEquals(returnedDTO.getPhoto().length,SENDED_IMAGE.getBytes().length);
        assertEquals(returnedDTO.getFirstName(),foundedRec.getFirstName());
        assertEquals(RecruitmentController.BASE_URL+"/1",returnedDTO.getRecruitmentUrl());


    }
}