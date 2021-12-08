package it.unimib.cheaptrip.model;

import java.util.Date;

public class PopularDirectionsFromFavorite {

    private String origin;
    private String destination;
    private String price;
    private String transfers;
    private String airline;
    private String flight_number;
    private Date departure_at;
    private Date return_at;
    private Date expires_at;

    public PopularDirectionsFromFavorite(String origin, String destination, String price, String transfers, String airline, String flight_number, Date departure_at, Date return_at, Date expires_at) {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.transfers = transfers;
        this.airline = airline;
        this.flight_number = flight_number;
        this.departure_at = departure_at;
        this.return_at = return_at;
        this.expires_at = expires_at;
    }

    public PopularDirectionsFromFavorite(){

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTransfers() {
        return transfers;
    }

    public void setTransfers(String transfers) {
        this.transfers = transfers;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public Date getDeparture_at() {
        return departure_at;
    }

    public void setDeparture_at(Date departure_at) {
        this.departure_at = departure_at;
    }

    public Date getReturn_at() {
        return return_at;
    }

    public void setReturn_at(Date return_at) {
        this.return_at = return_at;
    }

    public Date getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(Date expires_at) {
        this.expires_at = expires_at;
    }

    @Override
    public String toString() {
        return "PopularDirectionsFromFavorite{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", price='" + price + '\'' +
                ", transfers='" + transfers + '\'' +
                ", airline='" + airline + '\'' +
                ", flight_number='" + flight_number + '\'' +
                ", departure_at=" + departure_at +
                ", return_at=" + return_at +
                ", expires_at=" + expires_at +
                '}';
    }
}
