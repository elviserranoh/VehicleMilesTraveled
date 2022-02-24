package tech.prodigio.vehiclemilestraveled.infrastructure.mapper;

import org.mapstruct.Mapper;
import tech.prodigio.vehiclemilestraveled.domain.Vehicle;
import tech.prodigio.vehiclemilestraveled.infrastructure.repository.VehicleEntity;

@Mapper(componentModel = "spring")
public interface VehicleEntityMapper {
    Vehicle toDomain(VehicleEntity vehicleEntity);
    VehicleEntity toDbo(Vehicle vehicle);
}
