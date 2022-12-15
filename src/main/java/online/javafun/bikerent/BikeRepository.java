package online.javafun.bikerent;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

interface BikeRepository extends CrudRepository<Bike, Long> {
    Optional<Bike> findBySerialNumberIgnoreCase(String serialNumber);
    int countAllByBorrowerIdIsNotNull();
    List<Bike> findAllByBorrowerIdIsNullOrderByDayPrice();
}