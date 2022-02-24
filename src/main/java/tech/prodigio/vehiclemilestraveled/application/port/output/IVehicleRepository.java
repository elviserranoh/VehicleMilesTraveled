package tech.prodigio.vehiclemilestraveled.application.port.output;

import tech.prodigio.vehiclemilestraveled.domain.Vehicle;

import java.util.List;

public interface IVehicleRepository {

    void create(final Vehicle vehicle);
    List<Vehicle> findAll();
    void update(final Vehicle vehicle);
    void delete(final Vehicle vehicle);
    boolean existsById(final Long id);
    Vehicle findById(final Long id);
}
