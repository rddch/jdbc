package Entity;

public class Hotel {

    private String hotelName;
    private String review;
    private long hotelId;
    private long countryId;

    public Hotel(String hotelName, String review, long hotelId, long countryId) {
        this.hotelName = hotelName;
        this.review = review;
        this.hotelId = hotelId;
        this.countryId = countryId;
    }

    public Hotel() {
    }

    public long getCountryId() {
        return countryId;
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
