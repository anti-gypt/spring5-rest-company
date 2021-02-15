package antigypt.springframework.api.v1.mapper;

import antigypt.springframework.api.v1.model.VehicleDTO;
import antigypt.springframework.domain.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    @Mapping(
            source = "employee",
            target = "employee"
    )
    VehicleDTO vehicleToVehicleDTO(Vehicle vehicle);

    @Mapping(
            source = "employee",
            target = "employee"
    )
    Vehicle vehicleDTOToVehicle(VehicleDTO vehicleDTO);
}