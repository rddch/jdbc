package entity;

public class Country {

    private String country;
    private long countryId;

    public Country(String country, long countryId) {
        this.country = country;
        this.countryId = countryId;
    }

    public Country() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }
}
