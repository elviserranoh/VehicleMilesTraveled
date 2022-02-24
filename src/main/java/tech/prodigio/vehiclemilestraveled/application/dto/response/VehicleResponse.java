package tech.prodigio.vehiclemilestraveled.application.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import tech.prodigio.vehiclemilestraveled.domain.Vehicle;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
public class VehicleResponse {

    @NotNull private Vehicle vehicle;

    @JsonCreator
    public VehicleResponse(@JsonProperty("vehicle") @NotNull final Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
