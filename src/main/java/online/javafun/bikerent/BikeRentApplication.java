package online.javafun.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikeRentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikeRentApplication.class, args);
        NewBikeDto bike1 = new NewBikeDto(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        BikeService bikeService = context.getBean(BikeService.class);
        bikeService.add(bike1);
        System.out.println("Zapisano w bazie bike1");
        double rentingCost = bikeService.rentForHours(1L, 5, "Nr dowodu");
        System.out.println("Koszt wypożyczenia to: " + rentingCost);
        bikeService.returnBike(1L);
    }

}
