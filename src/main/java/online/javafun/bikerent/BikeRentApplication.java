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
        Bike bike2 = new Bike(2L, "Trek Marlin damski", "TMR12345", 25, 80);
        bikeRepository.save(bike2);
        System.out.println("Zapisano w bazie bike2");

        System.out.println("Pobieram i wyświetlam bike2");
        bikeRepository.findById(2L).ifPresent(System.out::println);

        System.out.println("usuwam z bazy bike1");
        bikeRepository.deleteById(1L);

        System.out.println("Pobieram i wyświetlam bike1");
        bikeRepository.findById(1L).ifPresentOrElse(System.out::println, () -> System.out.println("brak roweru bike1"));


    }

}
