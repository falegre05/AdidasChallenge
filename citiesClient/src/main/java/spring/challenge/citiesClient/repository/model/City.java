package spring.challenge.citiesClient.repository.model;

import spring.challenge.citiesClient.CitiesClientApplication;

// Representtion for city object
public class City {

    private Long id;
    private String name;
    private double coordX;
    private double coordY;

    public City() {
    }

    public City(Long id, String name, double coordX, double coordY) {
        this.id = id;
        this.name = name;
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
        return result;
    }

    @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", coordX=" + coordX + ", coordY=" + coordY + "]";
    }

    // Calc distance in straight line between 2 cities using their coordinates and
    // some Pythagorean trigonometry
    public double calcStraightLine(City dest) {
        final int EARTH_RADIUS = 6371;

        double lat1 = this.coordX * Math.PI / 180;
        double lon1 = this.coordY * Math.PI / 180;
        double lat2 = dest.coordX * Math.PI / 180;
        double lon2 = dest.coordY * Math.PI / 180;

        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;

        double x = deltaLon * Math.cos((lat1 + lat2) / 2);
        double y = deltaLat;

        return EARTH_RADIUS * Math.sqrt(x * x + y * y);
    }

    // Estimates how many minutes will it take to arrive from one city to another
    // one following an straight and with constant speed. 100km/h right now.
    public int calcEstimatedTime(City dest) {
        return (int) (this.calcStraightLine(dest) / CitiesClientApplication.SPEED) * 60;
    }

    // Estimates how many connections with other cities will it take to arrive from
    // one city to another in straight line. 1 connection per 400km aprox
    public int calcEstimatedConns(City dest) {
        return (int) (this.calcStraightLine(dest) / CitiesClientApplication.KM_CONN);
    }
}
