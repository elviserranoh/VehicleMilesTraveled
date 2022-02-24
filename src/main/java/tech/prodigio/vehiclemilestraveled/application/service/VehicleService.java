package tech.prodigio.vehiclemilestraveled.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tech.prodigio.vehiclemilestraveled.application.port.interactor.IVehicleService;
import tech.prodigio.vehiclemilestraveled.application.port.output.IVehicleRepository;
import tech.prodigio.vehiclemilestraveled.domain.Vehicle;
import tech.prodigio.vehiclemilestraveled.infrastructure.exception.VehicleException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService implements IVehicleService {

    private final IVehicleRepository repository;

    @Override
    public void create(final Vehicle vehicle) {
        repository.create(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(final Long id, final Vehicle vehicle) {

        if(!repository.existsById(id)) {
            throw new VehicleException(String.format("El vehiculo con id %d no existe", id), HttpStatus.BAD_REQUEST);
        }

        Vehicle currentVehicle = repository.findById(id);

        currentVehicle.setCountyFips(currentVehicle.getCountyFips());
        currentVehicle.setCountyName(currentVehicle.getCountyName());
        currentVehicle.setStateName(currentVehicle.getStateName());
        currentVehicle.setDate(currentVehicle.getDate());
        currentVehicle.setCountyVmt(currentVehicle.getCountyVmt());
        currentVehicle.setBaselineJanVmt(currentVehicle.getBaselineJanVmt());
        currentVehicle.setPercentChangeFromJan(currentVehicle.getPercentChangeFromJan());
        currentVehicle.setMean7CountyVmt(currentVehicle.getMean7CountyVmt());
        currentVehicle.setMean7PercentChangeFromJan(currentVehicle.getMean7PercentChangeFromJan());
        currentVehicle.setDateAtLow(currentVehicle.getDateAtLow());
        currentVehicle.setMean7CountyVmtAtLow(currentVehicle.getMean7CountyVmtAtLow());
        currentVehicle.setPercentChangeFromLow(currentVehicle.getPercentChangeFromLow());

        repository.update(currentVehicle);
    }

    @Override
    public void delete(final Long id, final Vehicle vehicle) {
        if(!repository.existsById(id)) {
            throw new VehicleException(String.format("El vehiculo con id %d no existe", id), HttpStatus.BAD_REQUEST);
        }

        Vehicle currentVehicle = repository.findById(id);

        repository.delete(currentVehicle);
    }


}
