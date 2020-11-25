package spring.challenge.citiesServer;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.challenge.citiesServer.repository.CityRepository;
import spring.challenge.citiesServer.repository.ConnectionRepository;
import spring.challenge.citiesServer.repository.model.City;
import spring.challenge.citiesServer.repository.model.Connection;

// Class made just to initialize the database with some tests cases on start
@Configuration
class PopulateDatabase {

        private static final Logger log = LoggerFactory.getLogger(PopulateDatabase.class);

        City madrid = new City("Madrid", 3142991, 40.4165, -3.70256);
        City barcelona = new City("Barcelona", 1604555, 41.38879, 2.15899);
        City valencia = new City("Valencia", 786189, 39.46975, -0.37739);
        City sevilla = new City("Sevilla", 800000, 37.38283, -5.97317);
        City zaragoza = new City("Zaragoza", 700000, 41.65606, -0.87734);
        City malaga = new City("Málaga", 569130, 36.72016, -4.42034);
        City granada = new City("Granada", 439889, 37.18817, -3.60667);
        City murcia = new City("Murcia", 230000, 37.98704, -1.13004);
        City santiago = new City("Santiago de Compostela", 96405, 42.88052, -8.54569);
        City plasencia = new City("Plasencia", 40141, 40.03116, -6.08845);
        City bilbao = new City("Bilbao", 345821, 43.26271, -2.92528);
        City santander = new City("Santander", 172044, 43.46472, -3.80444);
        City valladolid = new City("Valladolid", 298412, 41.65518, -4.72372);
        City ciudadreal = new City("Ciudad Real", 74746, 38.98626, -3.92907);

        @Bean
        CommandLineRunner populateCities(CityRepository repository) {

                return args -> {
                        log.info("-------CITIES------");
                        log.info("Inserting " + repository.save(madrid));
                        log.info("Inserting " + repository.save(barcelona));
                        log.info("Inserting " + repository.save(valencia));
                        log.info("Inserting " + repository.save(sevilla));
                        log.info("Inserting " + repository.save(zaragoza));
                        log.info("Inserting " + repository.save(malaga));
                        log.info("Inserting " + repository.save(granada));
                        log.info("Inserting " + repository.save(murcia));
                        log.info("Inserting " + repository.save(santiago));
                        log.info("Inserting " + repository.save(plasencia));
                        log.info("Inserting " + repository.save(bilbao));
                        log.info("Inserting " + repository.save(santander));
                        log.info("Inserting " + repository.save(valladolid));
                        log.info("Inserting " + repository.save(ciudadreal));
                };
        }

        @Bean
        CommandLineRunner populateConnections(ConnectionRepository repository) {

                return args -> {
                        log.info("-------CONNECTIONS------");
                        // Madrid
                        log.info("Inserting " + repository.save(new Connection(madrid, zaragoza,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:00"))));
                        log.info("Inserting " + repository.save(new Connection(madrid, valencia,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:30"))));
                        log.info("Inserting " + repository.save(new Connection(madrid, ciudadreal,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:00"))));
                        log.info("Inserting " + repository.save(new Connection(madrid, plasencia,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:00"))));
                        log.info("Inserting " + repository.save(new Connection(madrid, valladolid,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:00"))));

                        // Barcelona
                        log.info("Inserting " + repository.save(new Connection(barcelona, valencia,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:30"))));
                        log.info("Inserting " + repository.save(new Connection(barcelona, zaragoza,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:00"))));

                        // Valencia
                        log.info("Inserting " + repository.save(new Connection(valencia, barcelona,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:30"))));
                        log.info("Inserting " + repository.save(new Connection(valencia, murcia,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:15"))));
                        log.info("Inserting " + repository.save(new Connection(valencia, ciudadreal,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:15"))));
                        log.info("Inserting " + repository.save(new Connection(valencia, madrid,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:20"))));
                        log.info("Inserting " + repository.save(new Connection(valencia, zaragoza,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:30"))));

                        // Sevilla
                        log.info("Inserting " + repository.save(new Connection(sevilla, ciudadreal,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:30"))));
                        log.info("Inserting " + repository.save(new Connection(sevilla, granada,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:40"))));
                        log.info("Inserting " + repository.save(new Connection(sevilla, malaga,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:00"))));
                        log.info("Inserting " + repository.save(new Connection(sevilla, plasencia,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:20"))));

                        // Zaragoza
                        log.info("Inserting " + repository.save(new Connection(zaragoza, barcelona,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:00"))));
                        log.info("Inserting " + repository.save(new Connection(zaragoza, valencia,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:30"))));
                        log.info("Inserting " + repository.save(new Connection(zaragoza, madrid,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:00"))));
                        log.info("Inserting " + repository.save(new Connection(zaragoza, valladolid,
                                        LocalTime.parse("00:00"), LocalTime.parse("04:30"))));
                        log.info("Inserting " + repository.save(new Connection(zaragoza, bilbao,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:00"))));

                        // Málaga
                        log.info("Inserting " + repository.save(new Connection(malaga, granada,
                                        LocalTime.parse("00:00"), LocalTime.parse("01:30"))));
                        log.info("Inserting " + repository.save(new Connection(malaga, sevilla,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:00"))));

                        // Granada
                        log.info("Inserting " + repository.save(new Connection(granada, ciudadreal,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:25"))));
                        log.info("Inserting " + repository.save(new Connection(granada, murcia,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:45"))));
                        log.info("Inserting " + repository.save(new Connection(granada, malaga,
                                        LocalTime.parse("00:00"), LocalTime.parse("01:30"))));
                        log.info("Inserting " + repository.save(new Connection(granada, sevilla,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:40"))));

                        // Murcia
                        log.info("Inserting " + repository.save(new Connection(murcia, valencia,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:15"))));
                        log.info("Inserting " + repository.save(new Connection(murcia, granada,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:45"))));
                        log.info("Inserting " + repository.save(new Connection(murcia, ciudadreal,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:15"))));

                        // Santiago
                        log.info("Inserting " + repository.save(new Connection(santiago, santander,
                                        LocalTime.parse("00:00"), LocalTime.parse("04:20"))));
                        log.info("Inserting " + repository.save(new Connection(santiago, valladolid,
                                        LocalTime.parse("00:00"), LocalTime.parse("04:00"))));

                        // Plasencia
                        log.info("Inserting " + repository.save(new Connection(plasencia, valladolid,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:15"))));
                        log.info("Inserting " + repository.save(new Connection(plasencia, madrid,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:00"))));
                        log.info("Inserting " + repository.save(new Connection(plasencia, ciudadreal,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:20"))));
                        log.info("Inserting " + repository.save(new Connection(plasencia, sevilla,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:20"))));

                        // Bilbao
                        log.info("Inserting " + repository.save(new Connection(bilbao, zaragoza,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:00"))));
                        log.info("Inserting " + repository.save(new Connection(bilbao, valladolid,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:50"))));
                        log.info("Inserting " + repository.save(new Connection(bilbao, santander,
                                        LocalTime.parse("00:00"), LocalTime.parse("01:00"))));

                        // Santander
                        log.info("Inserting " + repository.save(new Connection(santander, bilbao,
                                        LocalTime.parse("00:00"), LocalTime.parse("01:00"))));
                        log.info("Inserting " + repository.save(new Connection(santander, valladolid,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:30"))));
                        log.info("Inserting " + repository.save(new Connection(santander, santiago,
                                        LocalTime.parse("00:00"), LocalTime.parse("04:20"))));

                        // Valladolid
                        log.info("Inserting " + repository.save(new Connection(valladolid, santander,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:30"))));
                        log.info("Inserting " + repository.save(new Connection(valladolid, bilbao,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:50"))));
                        log.info("Inserting " + repository.save(new Connection(valladolid, zaragoza,
                                        LocalTime.parse("00:00"), LocalTime.parse("04:30"))));
                        log.info("Inserting " + repository.save(new Connection(valladolid, madrid,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:00"))));
                        log.info("Inserting " + repository.save(new Connection(valladolid, madrid,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:15"))));
                        log.info("Inserting " + repository.save(new Connection(valladolid, santiago,
                                        LocalTime.parse("00:00"), LocalTime.parse("04:00"))));

                        // Ciudad Real
                        log.info("Inserting " + repository.save(new Connection(ciudadreal, madrid,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:00"))));
                        log.info("Inserting " + repository.save(new Connection(ciudadreal, valencia,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:15"))));
                        log.info("Inserting " + repository.save(new Connection(ciudadreal, murcia,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:15"))));
                        log.info("Inserting " + repository.save(new Connection(ciudadreal, granada,
                                        LocalTime.parse("00:00"), LocalTime.parse("02:25"))));
                        log.info("Inserting " + repository.save(new Connection(ciudadreal, sevilla,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:30"))));
                        log.info("Inserting " + repository.save(new Connection(ciudadreal, plasencia,
                                        LocalTime.parse("00:00"), LocalTime.parse("03:20"))));
                };
        }
}
