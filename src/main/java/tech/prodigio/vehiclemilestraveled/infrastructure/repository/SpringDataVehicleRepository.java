package tech.prodigio.vehiclemilestraveled.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataVehicleRepository extends CrudRepository<VehicleEntity, Long> {



}
