package online.javafun.bikerent;

public class NewBikeDto {

    private long id;
    private String model;
    private String serialNumber;
    private double hourPrice;
    private double dayPrice;

    public NewBikeDto(long id, String model, String serialNumber, double hourPrice, double dayPrice) {
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
}
