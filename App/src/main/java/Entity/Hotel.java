package Entity;

public class Hotel {

    private String hotelName;
    private String review;
    private long hotelId;

    public Hotel(String hotelName, String review, long hotelId) {
        this.hotelName = hotelName;
        this.review = review;
        this.hotelId = hotelId;
    }

    public Hotel() {
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
}
