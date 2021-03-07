package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.VehicleDTO;
import antigypt.springframework.domain.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    @Mappings({
            @Mapping(
                    source="employee",
                    target = "employee"),
            @Mapping(
                    source = "employee.department.productList",
                    target = "employee.department.productList.products"),
            @Mapping(
                    source ="employee.department" ,
                    target ="employee.department")
    })
    VehicleDTO vehicleToVehicleDTO(Vehicle vehicle);

    @Mappings({
            @Mapping(
                    source="employee",
                    target = "employee"),
            @Mapping(source = "employee.department.productList.products",
                    target = "employee.department.productList"),
            @Mapping(source ="employee.department" ,target ="employee.department")
    })
    Vehicle vehicleDTOToVehicle(VehicleDTO vehicleDTO);
}