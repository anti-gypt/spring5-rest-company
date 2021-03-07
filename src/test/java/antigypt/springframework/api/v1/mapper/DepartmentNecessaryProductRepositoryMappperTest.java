package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.DepartmentDTO;
import antigypt.springframework.api.v1.model.DepartmentNecessaryProductDTO;
import antigypt.springframework.api.v1.model.ProductTypeDTO;
import antigypt.springframework.domain.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentNecessaryProductRepositoryMappperTest {
    private static final String PHONENUMBER = "12345678";
    private static final String EMAIL = "omid@gmail.com";
    private static final String DETAIL = "this is detail";
    private static final String ADDRESSLINE = "Elisenstarse 1";
    private static final String COUNTRY = "Austria";
    private static final String CITY = "Wien";
    private static final String POSTALCODE = "1230";
    private static final String REGION = "Liesing";
    private static final String DISCOUNT = ".10";
    private static final LocalDate EXPIRATION_DATE = LocalDate.of(2021,3,2);
    private static final String PRICE = "12";
    private static final LocalDate PRODUCT_DATE = LocalDate.of(2020,3,2);;
    private static final String PRODUCT_COUNT = "1200";
    private static final String PRODUCT_ID = "1";
    private static final String PRODUCT_NAME = "shampoo";
    private static final String PRODUCT_TYPE_NAME = "detergent";
    private static final String WEIGHT = "1";

    private static final MockMultipartFile SENDED_IMAGE =
            new MockMultipartFile("imagefile","imagefile","text.txt","this si a byte sample".getBytes());
    private static final MockMultipartFile SENDED_SERIAL_NUMBER =
            new MockMultipartFile("cvfile","cvfile","text.txt","this si a byte sample".getBytes());


    DepartmentNecessaryProductMappper departmentNecessaryProductMappper;
    DepartmentNecessaryProductDTO departmentProductDTO;
    DepartmentNecessaryProduct departmentProduct;
    Department savedReturnedDepartment;
    Address address;
    DepartmentDTO sendedDepartmentDTO;
    Byte[] getBytes;
    ProductType productType;
    ProductTypeDTO productTypeDTO;
    @SneakyThrows
    @BeforeEach
    void setUp() {
        departmentNecessaryProductMappper = DepartmentNecessaryProductMappper.INSTANCE;

        getBytes = new Byte[SENDED_IMAGE.getBytes().length];
        int i = 0 ;
        for (byte b : SENDED_IMAGE.getBytes()){
            getBytes[i++] = b;
        }

        address = new Address();
        address.setAddressLine(ADDRESSLINE);
        address.setCity(CITY);
        address.setCountry(COUNTRY);
        address.setPostalCode(POSTALCODE);
        address.setRegion(REGION);

        savedReturnedDepartment = new Department();
        savedReturnedDepartment.setDepartmentId(1L);
        savedReturnedDepartment.setEmail(EMAIL);
        savedReturnedDepartment.setPhoneNumber(PHONENUMBER);
        savedReturnedDepartment.setDetail(DETAIL);
        savedReturnedDepartment.setAddress(address);
        savedReturnedDepartment.setEmployeeList(new ArrayList<>());

        sendedDepartmentDTO = new DepartmentDTO();
        sendedDepartmentDTO.setAddressLine(ADDRESSLINE);
        sendedDepartmentDTO.setCity(CITY);
        sendedDepartmentDTO.setCountry(COUNTRY);
        sendedDepartmentDTO.setDetail(DETAIL);
        sendedDepartmentDTO.setEmail(EMAIL);
        sendedDepartmentDTO.setPhoneNumber(PHONENUMBER);
        sendedDepartmentDTO.setPostalCode(POSTALCODE);
        sendedDepartmentDTO.setRegion(REGION);

        productType = new ProductType();
        productType.setDetail(DETAIL);
        productType.setProductCategory(ProductCategory.PAPER_PRODUCTS);
        productType.setProductTypeId(1L);
        productType.setProductTypeName(ProductTypeName.CUPS_PLATES);

        productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setDetail(DETAIL);
        productTypeDTO.setProductCategory(ProductCategory.PAPER_PRODUCTS);
        productTypeDTO.setProductTypeUrl("/api/v1/productTypes/1");
        productTypeDTO.setProductTypeName(ProductTypeName.CUPS_PLATES);


        departmentProduct = new DepartmentNecessaryProduct();
        departmentProduct.setDetail(DETAIL);
        departmentProduct.setDiscount(Double.valueOf(DISCOUNT));
        departmentProduct.setExpirationDate(EXPIRATION_DATE);
        departmentProduct.setImage(getBytes);
        departmentProduct.setPrice(Double.valueOf(PRICE));
        departmentProduct.setProduceDate(PRODUCT_DATE);
        departmentProduct.setProductCount(Long.valueOf(PRODUCT_COUNT));
        departmentProduct.setProductId(Long.valueOf(PRODUCT_ID));
        departmentProduct.setProductName(PRODUCT_NAME);
        departmentProduct.setSerialNumber(getBytes);
        departmentProduct.setWeight(Double.valueOf(WEIGHT));

        departmentProduct.setProductType(productType);

        departmentProductDTO = new DepartmentNecessaryProductDTO();
        departmentProductDTO.setDetail(DETAIL);
        departmentProductDTO.setDiscount(DISCOUNT);
        departmentProductDTO.setExpirationDate(String.valueOf(EXPIRATION_DATE));
        departmentProductDTO.setImage(getBytes);
        departmentProductDTO.setPrice(PRICE);
        departmentProductDTO.setProduceDate(String.valueOf(PRODUCT_DATE));
        departmentProductDTO.setProductCount(PRODUCT_COUNT);
        departmentProductDTO.setProductName(PRODUCT_NAME);
        departmentProductDTO.setSerialNumber(getBytes);
        departmentProductDTO.setWeight(WEIGHT);

        departmentProductDTO.setProductType(productTypeDTO);
        departmentProductDTO.setProductUrl("/api/v1/products/1");


    }

    @Test
    void departmentNecessaryProductDTOToDepartmentNecessaryProduct() {
        DepartmentNecessaryProduct departmentNecessaryProduct = departmentNecessaryProductMappper.departmentNecessaryProductDTOToDepartmentNecessaryProduct(departmentProductDTO);
        assertNotNull(departmentNecessaryProduct);
    }

    @Test
    void departmentNecessaryProductToDepartmentNecessaryProductDTO() {
        DepartmentNecessaryProductDTO departmentNecessaryProductDTO = departmentNecessaryProductMappper.departmentNecessaryProductToDepartmentNecessaryProductDTO(departmentProduct);
        assertNotNull(departmentNecessaryProductDTO);
    }
}