package pl.sda.model;

public class Address {



    private String streetName;
    private int houseNumber;
    private int flatNumber;
    private String postalCode;
    private String city;
    private String country;
    private StreetPrefix streetPrefix;

    public Address() {
    }

    public Address(String streetName, int houseNumber, int flatNumber, String postalCode, String city, String country, StreetPrefix streetPrefix) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.streetPrefix = streetPrefix;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return streetPrefix.getPrefix() + " " + streetName + " " + houseNumber +"/" + flatNumber +
                "\n" + postalCode + " " + city + " " + country;
    }
}
