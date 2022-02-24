package tech.prodigio.vehiclemilestraveled.infrastructure.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.prodigio.vehiclemilestraveled.application.dto.request.CreateVehicleRequest;
import tech.prodigio.vehiclemilestraveled.application.dto.request.DeleteVehicleRequest;
import tech.prodigio.vehiclemilestraveled.application.dto.request.UpdateVehicleRequest;
import tech.prodigio.vehiclemilestraveled.application.dto.response.FindAllVehicleResponse;
import tech.prodigio.vehiclemilestraveled.application.dto.response.VehicleResponse;
import tech.prodigio.vehiclemilestraveled.application.port.input.IVehicleController;
import tech.prodigio.vehiclemilestraveled.application.port.interactor.IVehicleService;
import tech.prodigio.vehiclemilestraveled.infrastructure.exception.VehicleException;
import tech.prodigio.vehiclemilestraveled.infrastructure.utils.JsonUtil;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController implements IVehicleController {

    private final IVehicleService service;

    @ApiOperation(value = "Endpoint para crear un vehiculo")
    @PostMapping
    @Override
    public ResponseEntity<VehicleResponse> create(@RequestHeader HttpHeaders headers,
                                                  @Valid @RequestBody CreateVehicleRequest request,
                                                  BindingResult result) {

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> String.format("El campo %s %s", err.getField(), err.getDefaultMessage()))
                    .collect(Collectors.toList());

            throw new VehicleException(JsonUtil.toJson(errors), HttpStatus.BAD_REQUEST);
        }

        service.create(request);
        return ResponseEntity.ok(new VehicleResponse(request));
    }

    @ApiOperation(value = "Listar todos los vehiculos")
    @GetMapping
    @Override
    public ResponseEntity<FindAllVehicleResponse> read(@RequestHeader HttpHeaders headers) {
        return ResponseEntity.ok(new FindAllVehicleResponse(service.findAll()));
    }

    @ApiOperation(value = "Endpoint para actualizar un vehiculo")
    @PutMapping("/{id}")
    @Override
    public ResponseEntity<VehicleResponse> update(@RequestHeader HttpHeaders headers,
                                                  @PathVariable("id") Long id,
                                                  @Valid @RequestBody UpdateVehicleRequest request,
                                                  BindingResult result) {

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> String.format("El campo %s %s", err.getField(), err.getDefaultMessage()))
                    .collect(Collectors.toList());

            throw new VehicleException(JsonUtil.toJson(errors), HttpStatus.BAD_REQUEST);
        }

        service.update(id, request);
        return ResponseEntity.ok(new VehicleResponse(request));
    }

    @ApiOperation(value = "Eliminar un vehiculo")
    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<VehicleResponse> delete(@RequestHeader HttpHeaders headers,
                                                  @PathVariable("id") Long id,
                                                  @Valid @RequestBody DeleteVehicleRequest request) {
        service.delete(id, request.getVehicle());
        return ResponseEntity.ok(new VehicleResponse(request.getVehicle()));
    }
}
