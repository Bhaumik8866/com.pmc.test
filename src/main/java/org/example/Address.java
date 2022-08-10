package org.example;

public class Address {

    private String streetaddress;
    private String city;
    private String state;
    private String postalcode;

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Override
    public String toString() {
        return "{" +
                "streetaddress='" + streetaddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalcode='" + postalcode + '\'' +
                '}';
    }
}
