package spring.challenge.citiesServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.challenge.citiesServer.exceptions.ConnectionNotFoundException;
import spring.challenge.citiesServer.repository.ConnectionRepository;
import spring.challenge.citiesServer.repository.model.Connection;

@RestController
@RequestMapping(path = "/connection")
public class ConnectionController {

    @Autowired
    private ConnectionRepository connectionRepository;

    @GetMapping(path = { "/", "" })
    public @ResponseBody Iterable<Connection> getConnections() {
        return connectionRepository.findAll();
    }

    @GetMapping("/{id}")
    Connection getConnection(@PathVariable Long id) {
        return connectionRepository.findById(id).orElseThrow(() -> new ConnectionNotFoundException(id));
    }

    @GetMapping("/origin/{id}")
    List<Connection> getOrigConnections(@PathVariable Long id) {
        return connectionRepository.findByOrigId(id);
    }

    @GetMapping("/destiny/{id}")
    List<Connection> getDestinyConnections(@PathVariable Long id) {
        return connectionRepository.findByDestId(id);
    }

    @PostMapping(path = { "/", "" })
    Connection newConnection(@RequestBody Connection newConnection) {
        return connectionRepository.save(newConnection);
    }

    @PutMapping("/{id}")
    Connection updateCity(@RequestBody Connection newConnection, @PathVariable Long id) {

        return connectionRepository.findById(id).map(connection -> {
            connection.setOrig(newConnection.getOrig());
            connection.setDest(newConnection.getDest());
            connection.setDepartureTime(newConnection.getDepartureTime());
            connection.setArrivalTime(newConnection.getArrivalTime());
            return connectionRepository.save(connection);
        }).orElseGet(() -> {
            newConnection.setId(id);
            return connectionRepository.save(newConnection);
        });
    }

    @DeleteMapping("/{id}")
    void DeleteCity(@PathVariable Long id) {
        connectionRepository.deleteById(id);
    }
}
