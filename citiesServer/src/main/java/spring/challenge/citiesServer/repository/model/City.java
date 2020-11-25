package spring.challenge.citiesServer.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

// Entity representing cities with their id, name, population and coordinates.
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "City's auto-generated ID")
    private Long id;
    @ApiModelProperty(notes = "City's name")
    private String name;
    @ApiModelProperty(notes = "City's population")
    private int population;
    @ApiModelProperty(notes = "City's X coordinate")
    private double coordX;
    @ApiModelProperty(notes = "City's Y coordinate")
    private double coordY;

    public City() {
    }

    public City(String name, int population, double coordX, double coordY) {
        this.name = name;
        this.population = population;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        City other = (City) obj;
        if (Double.doubleToLongBits(coordX) != Double.doubleToLongBits(other.coordX))
            return false;
        if (Double.doubleToLongBits(coordY) != Double.doubleToLongBits(other.coordY))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (population != other.population)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(coordX);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coordY);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + population;
        return result;
    }

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", coordX=" + coordX + ", coordY=" + coordY + ", population="
                + population + "]";
    }
}
