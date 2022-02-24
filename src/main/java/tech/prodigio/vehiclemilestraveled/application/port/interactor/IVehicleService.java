package tech.prodigio.vehiclemilestraveled.application.port.interactor;

import tech.prodigio.vehiclemilestraveled.domain.Vehicle;

import java.util.List;

public interface IVehicleService {
    void create(final Vehicle vehicle);
    List<Vehicle> findAll();
    void update(final Long id, final Vehicle vehicle);
    void delete(final Long id, final Vehicle vehicle);
}
