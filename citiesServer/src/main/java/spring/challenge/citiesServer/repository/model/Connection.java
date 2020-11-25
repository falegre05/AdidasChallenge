package spring.challenge.citiesServer.repository.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

// Entity representing connections between cities with their id, origin and destiny city 
// and departure and arrival time
@Entity
@Table(name = "connections")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Connection's auto-generated ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orig")
    @ApiModelProperty(notes = "Connection's origin city")
    City orig;

    @ManyToOne
    @JoinColumn(name = "dest")
    @ApiModelProperty(notes = "Connection's origin city")
    City dest;

    @ApiModelProperty(notes = "Connection's departure time")
    private LocalTime departureTime;
    @ApiModelProperty(notes = "Connection's arrival time")
    private LocalTime arrivalTime;

    public Connection() {
    }

    public Connection(City orig, City dest, LocalTime departureTime, LocalTime arrivalTime) {
        this.orig = orig;
        this.dest = dest;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
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

    @Override
    public String toString() {
        return "Connection [id=" + id + ", orig=" + orig.getName() + ", dest=" + dest.getName() + ", arrivalTime="
                + arrivalTime + ", departureTime=" + departureTime + "]";
    }
}