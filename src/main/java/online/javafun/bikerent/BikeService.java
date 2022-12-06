package online.javafun.bikerent;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BikeService {
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public void add(NewBikeDto newBike) {
        Bike bike = new Bike(newBike.getId(),
                newBike.getModel(),
                newBike.getSerialNumber(),
                newBike.getHourPrice(),
                newBike.getDayPrice());

        bikeRepository.save(bike);
    }

    public void deleteById(Long bikeId) {
        bikeRepository.deleteById(bikeId);
    }

    public double rentForHours(Long bikeId, int hours, String borrowerId) {
        LocalDateTime timeReturn = LocalDateTime.now().plusHours(hours);
        Bike bike = updateBike(bikeId, borrowerId, timeReturn);
        return bike.getHourPrice() * hours;
    }

    public void returnBike(Long bikeId) {
        updateBike(bikeId, null, null);
    }

    private Bike updateBike(Long bikeId, String borrowerId, LocalDateTime timeReturn) {
        Bike bike = bikeRepository.findById(bikeId).orElseThrow(BikeNotFoundException::new);
        bike.setDateReturn(timeReturn);
        bike.setBorrowerId(borrowerId);
        bikeRepository.save(bike);
        return bike;
    }

    public double rentForDay(Long bikeId, String borrowerId) {
        LocalDateTime dateReturn = LocalDateTime.now().withHour(23).withMinute(59);
        Bike bike = updateBike(bikeId, borrowerId, dateReturn);
        return bike.getDayPrice();
    }
}
