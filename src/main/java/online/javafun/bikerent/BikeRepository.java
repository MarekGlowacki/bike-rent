package online.javafun.bikerent;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class BikeRepository {
    private final EntityManager entityManager;

    public BikeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    public void save(Bike bike) {
        boolean bikeExist = entityManager.find(Bike.class, bike.getId()) != null;
        if (bikeExist) {
            entityManager.merge(bike);
        } else {
            entityManager.persist(bike);
        }
    }

    public Optional<Bike> findById(Long id) {
        Bike bike = entityManager.find(Bike.class, id);
        return Optional.ofNullable(bike);
    }

    @Transactional
    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }
}
