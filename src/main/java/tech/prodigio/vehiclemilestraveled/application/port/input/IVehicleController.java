package tech.prodigio.vehiclemilestraveled.application.port.input;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import tech.prodigio.vehiclemilestraveled.application.dto.request.CreateVehicleRequest;
import tech.prodigio.vehiclemilestraveled.application.dto.request.DeleteVehicleRequest;
import tech.prodigio.vehiclemilestraveled.application.dto.request.UpdateVehicleRequest;
import tech.prodigio.vehiclemilestraveled.application.dto.response.FindAllVehicleResponse;
import tech.prodigio.vehiclemilestraveled.application.dto.response.VehicleResponse;

import javax.validation.Valid;

public interface IVehicleController {
    ResponseEntity<VehicleResponse> create(@RequestHeader HttpHeaders headers,
                                           @Valid @RequestBody CreateVehicleRequest request,
                                           BindingResult result);

    ResponseEntity<FindAllVehicleResponse> read(@RequestHeader HttpHeaders headers);

    ResponseEntity<VehicleResponse> update(@RequestHeader HttpHeaders headers,
                                           @PathVariable("id") Long id,
                                           @Valid @RequestBody UpdateVehicleRequest request,
                                           BindingResult result);


    ResponseEntity<VehicleResponse> delete(@RequestHeader HttpHeaders headers,
                                           @PathVariable("id") Long id,
                                           @Valid @RequestBody DeleteVehicleRequest request);
}
