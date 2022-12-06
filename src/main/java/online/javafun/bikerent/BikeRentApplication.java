package online.javafun.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikeRentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikeRentApplication.class, args);
        Bike bike1 = new Bike(1L, "Kross Esker 4.0, 29 cali męski", "KRS12345", 30, 100);
        BikeRepository bikeRepository = context.getBean(BikeRepository.class);
        bikeRepository.save(bike1);
        System.out.println("Zapisano w bazie bike1");
        bikeRepository.delete(bike1);


    }

}
