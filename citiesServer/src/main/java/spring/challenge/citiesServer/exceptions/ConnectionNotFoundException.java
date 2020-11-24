package spring.challenge.citiesServer.exceptions;

public class ConnectionNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ConnectionNotFoundException(Long id) {
        super("Could not find connection with id: " + id);
    }

}
