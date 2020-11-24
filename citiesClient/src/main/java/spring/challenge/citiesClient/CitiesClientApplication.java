package spring.challenge.citiesClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitiesClientApplication {

	public static final String IP = "citiesserver";
	public static final int PORT = 9090;

	public static final int SPEED = 100; // KM/H
	public static final int KM_CONN = 400; // KM

	public static void main(String[] args) {
		SpringApplication.run(CitiesClientApplication.class, args);
	}
}
