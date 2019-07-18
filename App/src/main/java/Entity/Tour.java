package Entity;

public class Tour {

    private String tourName;
    private boolean tourOrder;
    private long tourId;
    private Hotel hotel;

    public boolean isTourOrder() {
        return tourOrder;
    }

    public void setTourOrder(boolean tourOrder) {
        this.tourOrder = tourOrder;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public long getTourId() {
        return tourId;
    }

    public void setTourId(long tourId) {
        this.tourId = tourId;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourName='" + tourName + '\'' +
                ", tourOrder=" + tourOrder +
                '}';
    }
}
