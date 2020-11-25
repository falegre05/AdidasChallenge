package spring.challenge.citiesClient.repository.model;

import java.time.Duration;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Representation for connection object. Duration field is auto calculed.
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = ConnectionDeserializer.class)
public class Connection {

    private Long id;
    private City orig;
    private City dest;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private Duration duration;

    public Connection() {
    }

    public Connection(Long id, City orig, City dest, LocalTime departureTime, LocalTime arrivalTime) {
        this.id = id;
        this.orig = orig;
        this.dest = dest;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        duration = Duration.between(departureTime, arrivalTime);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getOrig() {
        return orig;
    }

    public void setOrig(City orig) {
        this.orig = orig;
    }

    public City getDest() {
        return dest;
    }

    public void setDest(City dest) {
        this.dest = dest;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Connection [id=" + id + ", orig=" + orig.getName() + ", dest=" + dest.getName() + ", arrivalTime="
                + arrivalTime + ", departureTime=" + departureTime + ", duration=" + duration.toMinutes() + "]";
    }
}