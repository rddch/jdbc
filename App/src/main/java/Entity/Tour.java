package Entity;

public class Tour {

    private String tourName;
    private long tourId;

    public Tour(String tourName, long tourId) {
        this.tourName = tourName;
        this.tourId = tourId;
    }

    public Tour() {
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

}
