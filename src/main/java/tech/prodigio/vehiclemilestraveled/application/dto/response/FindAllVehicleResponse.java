package tech.prodigio.vehiclemilestraveled.application.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import tech.prodigio.vehiclemilestraveled.domain.Vehicle;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class FindAllVehicleResponse {
    private final List<Vehicle> vehicles;
}
