package Entity;

public class Hotel {

    private String hotelName;
    private String review;
    private boolean hotelOrder;
    private long hotelId;

    public boolean isHotelOrder() {
        return hotelOrder;
    }

    public void setHotelOrder(boolean hotelOrder) {
        this.hotelOrder = hotelOrder;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", review='" + review + '\'' +
                ", hotelOrder=" + hotelOrder +
                '}';
    }
}
