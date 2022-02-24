package tech.prodigio.vehiclemilestraveled.infrastructure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {VehicleException.class})
    public ResponseEntity<Object> handleApiRequestException(VehicleException e) {
        VehicleExceptionModel vehicleExceptionModel = new VehicleExceptionModel(e.getMessage(),
                e.getHttpStatus(),
                ZonedDateTime.now());

        return new ResponseEntity<>(vehicleExceptionModel, e.getHttpStatus());
    }

}
