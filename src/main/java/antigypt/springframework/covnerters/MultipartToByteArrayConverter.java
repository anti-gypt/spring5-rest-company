package antigypt.springframework.covnerters;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

public class MultipartToByteArrayConverter implements Converter<MultipartFile,Byte[]> {



    @SneakyThrows
    @NonNull
    @Synchronized
    @Override
    public Byte[] convert(MultipartFile multipartFile) {
        Byte[] getBytes = new Byte[multipartFile.getBytes().length];
        int i = 0 ;
        for (byte b : multipartFile.getBytes()){
            getBytes[i++] = b;
        }
        return getBytes;
    }
}
