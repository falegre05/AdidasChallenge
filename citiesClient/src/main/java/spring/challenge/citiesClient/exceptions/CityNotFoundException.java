package spring.challenge.citiesClient.exceptions;

public class CityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -5634011762469863110L;

    public CityNotFoundException(Long id) {
        super("Could not find city with id: " + id);
    }
}
