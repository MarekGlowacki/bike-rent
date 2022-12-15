package online.javafun.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikeRentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikeRentApplication.class, args);
        BikeDto bike1 = new BikeDto(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        BikeDto bike2 = new BikeDto(2L, "Merida model", "MATRIX2324", 30, 100);
        BikeDto bike3 = new BikeDto(3L, "Trek model", "TREK8293", 30, 100);
        BikeDto bike4 = new BikeDto(4L, "Superior model", "SUP93847", 30, 100);
        BikeService bikeService = context.getBean(BikeService.class);
        bikeService.add(bike1);
        bikeService.add(bike2);
        bikeService.add(bike3);
        bikeService.add(bike4);
        double payment = bikeService.rentForDay("TREK8293", "Nr dowodu1");
        System.out.println("Wypożyczono rower za kwotę: " + payment);

        int borrowedBikes = bikeService.countBorrowedBikes();
        System.out.println("Liczba wypożyczonych rowerów: " + borrowedBikes);

        System.out.println("Dostępne rowery (cena rosnąco):");
        bikeService.findAllAvailableBikes().forEach(System.out::println);
    }

}
