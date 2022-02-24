package tech.prodigio.vehiclemilestraveled.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import tech.prodigio.vehiclemilestraveled.application.port.output.IVehicleRepository;
import tech.prodigio.vehiclemilestraveled.domain.Vehicle;
import tech.prodigio.vehiclemilestraveled.infrastructure.mapper.VehicleEntityMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Primary
@RequiredArgsConstructor
public class VehicleRepository implements IVehicleRepository {

    private final SpringDataVehicleRepository springDataVehicleRepository;
    private final VehicleEntityMapper mapper;

    @Override
    public void create(final Vehicle vehicle) {

        VehicleEntity entity = mapper.toDbo(vehicle);

        springDataVehicleRepository.save(entity);
    }

    @Override
    public List<Vehicle> findAll() {
        Iterable<VehicleEntity> iterator = springDataVehicleRepository.findAll();

        return StreamSupport
                .stream(iterator.spliterator(), false)
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Vehicle vehicle) {

        VehicleEntity entity = mapper.toDbo(vehicle);
        springDataVehicleRepository.save(entity);
    }

    @Override
    public void delete(Vehicle vehicle) {

        VehicleEntity entity = mapper.toDbo(vehicle);
        springDataVehicleRepository.delete(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return springDataVehicleRepository.existsById(id);
    }

    @Override
    public Vehicle findById(Long id) {
        return mapper.toDomain(springDataVehicleRepository.findById(id).orElse(null));
    }

}
