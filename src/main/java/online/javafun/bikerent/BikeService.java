package online.javafun.bikerent;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeService {
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Transactional
    public void add(BikeDto newBike) {
        Bike bike = new Bike(newBike.getId(),
                newBike.getModel(),
                newBike.getSerialNumber(),
                newBike.getHourPrice(),
                newBike.getDayPrice());

        bikeRepository.save(bike);
    }

    @Transactional
    public void deleteById(Long bikeId) {
        bikeRepository.deleteById(bikeId);
    }

    @Transactional
    public double rentForHours(String bikeSerialNumber, int hours, String borrowerSerialNumber) {
        LocalDateTime timeReturn = LocalDateTime.now().plusHours(hours);
        Bike bike = updateBike(bikeSerialNumber, borrowerSerialNumber, timeReturn);
        return bike.getHourPrice() * hours;
    }

    @Transactional
    public void returnBike(String bikeSerialNumber) {
        updateBike(bikeSerialNumber, null, null);
    }

    private Bike updateBike(String bikeSerialNumber, String borrowerSerialNumber, LocalDateTime timeReturn) {
        Bike bike = bikeRepository.findBySerialNumberIgnoreCase(bikeSerialNumber).orElseThrow(BikeNotFoundException::new);
        bike.setDateReturn(timeReturn);
        bike.setBorrowerId(borrowerSerialNumber);
        return bike;
    }

    public double rentForDay(String bikeSerialNumber, String borrowerSerialNumber) {
        LocalDateTime dateReturn = LocalDateTime.now().withHour(23).withMinute(59);
        Bike bike = updateBike(bikeSerialNumber, borrowerSerialNumber, dateReturn);
        return bike.getDayPrice();
    }

    public int countBorrowedBikes() {
        return bikeRepository.countAllByBorrowerIdIsNull();
    }

    public List<BikeDto> findAllAvailableBikes() {
        return bikeRepository.findAllByBorrowerIdIsNotNullOrderByDayPrice()
                .stream()
                .map(bike -> new BikeDto(
                        bike.getId(),
                        bike.getModel(),
                        bike.getSerialNumber(),
                        bike.getHourPrice(),
                        bike.getDayPrice()
                )).collect(Collectors.toList());
    }
}
