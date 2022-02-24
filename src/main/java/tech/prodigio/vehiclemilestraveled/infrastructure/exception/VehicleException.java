package tech.prodigio.vehiclemilestraveled.infrastructure.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class VehicleException extends RuntimeException {

    private final HttpStatus httpStatus;

    public VehicleException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }


}
