package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.RecruitmentDTO;
import antigypt.springframework.domain.Recruitment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RecruitmentMapper {
    RecruitmentMapper INSTANCE = Mappers.getMapper(RecruitmentMapper.class);
    RecruitmentDTO recruitmentToRecruitmentDTO(Recruitment recruitment);
    @Mappings({@Mapping( source = "email" , target = "email"),
               @Mapping(source = "addressLine",target = "address.addressLine"),
               @Mapping(source = "country",target = "address.country"),
               @Mapping(source = "city",target = "address.city"),
               @Mapping(source = "region",target = "address.region"),
               @Mapping(source = "postalCode",target = "address.postalCode"),

    })
    Recruitment recruitmnetDTOToRecruitment(RecruitmentDTO recruitmentDTO);

}
