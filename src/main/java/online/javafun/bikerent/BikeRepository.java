package online.javafun.bikerent;

import org.springframework.data.repository.CrudRepository;

interface BikeRepository extends CrudRepository<Bike, Long> {}
