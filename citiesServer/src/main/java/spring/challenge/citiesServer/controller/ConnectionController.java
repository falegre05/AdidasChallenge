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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import spring.challenge.citiesServer.exceptions.ConnectionNotFoundException;
import spring.challenge.citiesServer.repository.ConnectionRepository;
import spring.challenge.citiesServer.repository.model.Connection;

@RestController
@RequestMapping(path = "/connection", produces = "application/json")
@Api(description = "Get information about connections between cities")
public class ConnectionController {

    @Autowired
    private ConnectionRepository connectionRepository;

    @ApiOperation(value = "Gets all cities")
    @GetMapping(path = { "/", "" })
    public @ResponseBody Iterable<Connection> getConnections() {
        return connectionRepository.findAll();
    }

    @ApiOperation(value = "Gets one connection given its id")
    @GetMapping("/{id}")
    Connection getConnection(@PathVariable Long id) {
        return connectionRepository.findById(id).orElseThrow(() -> new ConnectionNotFoundException(id));
    }

    @ApiOperation(value = "Gets all connections with origin in the city with the given id")
    @GetMapping("/origin/{id}")
    List<Connection> getOrigConnections(@PathVariable Long id) {
        return connectionRepository.findByOrigId(id);
    }

    @ApiOperation(value = "Gets all connections with destiny in the city with the given id")
    @GetMapping("/destiny/{id}")
    List<Connection> getDestinyConnections(@PathVariable Long id) {
        return connectionRepository.findByDestId(id);
    }

    @ApiOperation(value = "Creates a new connection")
    @PostMapping(path = { "/", "" })
    Connection newConnection(@RequestBody Connection newConnection) {
        return connectionRepository.save(newConnection);
    }

    @ApiOperation(value = "Updates an existing connection or creates a new one if it doesn't exist")
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

    @ApiOperation(value = "Deletes a connection")
    @DeleteMapping("/{id}")
    void DeleteCity(@PathVariable Long id) {
        connectionRepository.deleteById(id);
    }
}
