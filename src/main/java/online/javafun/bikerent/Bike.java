package online.javafun.bikerent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bike {
    @Id
    private long id;
    private String model;
    private String serialNumber;
    private double hourPrice;
    private double dayPrice;
    private String borrowerId;

    public Bike() {}

    public Bike(long id, String model, String serialNumber, double hourPrice, double dayPrice) {
        this.id = id;
        this.model = model;
        this.serialNumber = serialNumber;
        this.hourPrice = hourPrice;
        this.dayPrice = dayPrice;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", hourPrice=" + hourPrice +
                ", dayPrice=" + dayPrice +
                ", borrowerId='" + borrowerId + '\'' +
                '}';
    }
}
