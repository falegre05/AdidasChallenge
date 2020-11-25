package spring.challenge.citiesClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitiesClientApplication {

	// Metrics used to calculate heuristic estimations, converting kms taken out
	// from the city's coordinates into time and number of connections
	public static final int SPEED = 100; // KM/H
	// The largest connection is 390km, this way I assure the estimate is never
	// higher than the actual number of connections
	public static final int KM_CONN = 400; // KM

	public static void main(String[] args) {
		SpringApplication.run(CitiesClientApplication.class, args);
	}
}
