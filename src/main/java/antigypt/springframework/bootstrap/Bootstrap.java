package antigypt.springframework.bootstrap;

import antigypt.springframework.domain.Address;
import antigypt.springframework.domain.Gender;
import antigypt.springframework.domain.Recruitment;
import antigypt.springframework.domain.Title;
import antigypt.springframework.repositories.RecruitmentRepository;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.time.LocalDate;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final RecruitmentRepository recruitmentRepository;

    public Bootstrap(RecruitmentRepository recruitmentRepository) {
        this.recruitmentRepository = recruitmentRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        recruitmentRepository.save(getRecruitment());
        System.out.println("Recruitment added");
    }
    @SneakyThrows
    public ByteArrayOutputStream convertInputStreamToByteArrayOutputStream(InputStream source){
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = source.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer;
    }
    public Byte[] convertByteArrayOutputStreamToWrapperByte(ByteArrayOutputStream source){
        int i = 0 ;
        Byte[] getBytes = new Byte[source.size()];
        for (byte b : source.toByteArray()){
            getBytes[i++] = b;
        }
        return getBytes;
    }
    @SneakyThrows
    public Recruitment getRecruitment(){
        File imageFile = ResourceUtils.getFile("classpath:static/images/recruitments/omid.jpg");
        InputStream photoStream  = new FileInputStream(imageFile);
        File cvFile = ResourceUtils.getFile("classpath:static/pdfs/recruitments/omid.pdf");
        InputStream cvStream = new FileInputStream(cvFile);
        Byte[] getBytesPhoto = convertByteArrayOutputStreamToWrapperByte(convertInputStreamToByteArrayOutputStream(photoStream));
        Byte[] getBytesCv =  convertByteArrayOutputStreamToWrapperByte(convertInputStreamToByteArrayOutputStream(cvStream));

        Address address = new Address();
        address.setAddressLine("Ehamagasse 46-29");
        address.setCity("ghaemshahr");
        address.setCountry("Austria");
        address.setRegion("liesing");
        address.setPostalCode("1230");
        Recruitment recruitment = new Recruitment();
        recruitment.setFirstName("Roghayeh");
        recruitment.setLastName("Alinattaj");
        recruitment.setBirthDate(LocalDate.of(1989,9,5));
        recruitment.setApplicationDate(LocalDate.of(2021,1,2));
        recruitment.setAddress(address);
        recruitment.setDesiredSalary(2500.0);
        recruitment.setDetail("This is my first Apply for Job");
        recruitment.setEmail("bitta.52@gmail.com");
        recruitment.setGender(Gender.FEMALE);
        recruitment.setTitle(Title.ING);
        recruitment.setHomePhone("123456");
        recruitment.setMobilePhone("06605443488");
        recruitment.setPhoto(getBytesPhoto);
        recruitment.setCv(getBytesCv);
        return recruitment;
    }
}
