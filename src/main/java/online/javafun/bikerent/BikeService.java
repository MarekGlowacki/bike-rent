package online.javafun.bikerent;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
class BikeService {

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
    public double rentForHours(String serialNumber, int hours, String borrowerId) {
        LocalDateTime dateOfReturn = LocalDateTime.now().plusHours(hours);
        double hourPrice = updateBike(serialNumber, dateOfReturn, borrowerId).getHourPrice();
        return hourPrice * hours;
    }

    @Transactional
    public double rentForDay(String serialNumber, String borrowerId) {
        LocalDateTime dateReturn = LocalDateTime.now().withHour(23).withMinute(59);
        return updateBike(serialNumber, dateReturn, borrowerId).getDayPrice();
    }

    @Transactional
    public void returnBike(String serialNumber) {
        updateBike(serialNumber, null, null);
    }

    private Bike updateBike(String serialNumber, LocalDateTime dateReturn, String borrowerId) {
        Bike bike = bikeRepository
                .findBySerialNumberIgnoreCase(serialNumber)
                .orElseThrow(BikeNotFoundException::new);
        bike.setDateReturn(dateReturn);
        bike.setBorrowerId(borrowerId);
        return bike;
    }

    public List<BikeDto> findAllAvailableBikes() {
        return bikeRepository.findAllByBorrowerIdIsNullOrderByDayPrice()
                .stream().map(bike -> new BikeDto(
                        bike.getId(),
                        bike.getModel(),
                        bike.getSerialNumber(),
                        bike.getHourPrice(),
                        bike.getDayPrice()
                )).collect(Collectors.toList());
    }

    public int countBorrowedBikes() {
        return bikeRepository.countAllByBorrowerIdIsNotNull();
    }
}