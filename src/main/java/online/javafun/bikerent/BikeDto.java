package online.javafun.bikerent;

public class BikeDto {

    private long id;
    private String model;
    private String serialNumber;
    private double hourPrice;
    private double dayPrice;

    public BikeDto(long id, String model, String serialNumber, double hourPrice, double dayPrice) {
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

    @Override
    public String toString() {
        return "BikeDto{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", hourPrice=" + hourPrice +
                ", dayPrice=" + dayPrice +
                '}';
    }
}
