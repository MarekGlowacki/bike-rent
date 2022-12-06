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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(double hourPrice) {
        this.hourPrice = hourPrice;
    }

    public double getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(double dayPrice) {
        this.dayPrice = dayPrice;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
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
