package tech.prodigio.vehiclemilestraveled.application.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import tech.prodigio.vehiclemilestraveled.domain.Vehicle;

import javax.validation.constraints.NotNull;

@Getter
public class DeleteVehicleRequest {
    @NotNull
    private final Vehicle vehicle;

    @JsonCreator
    public DeleteVehicleRequest(@JsonProperty("vehicle") @NotNull final Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
