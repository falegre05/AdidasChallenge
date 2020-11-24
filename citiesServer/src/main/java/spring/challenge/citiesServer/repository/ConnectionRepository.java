package spring.challenge.citiesServer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import spring.challenge.citiesServer.repository.model.Connection;

public interface ConnectionRepository extends CrudRepository<Connection, Long> {
    List<Connection> findByOrigId(Long origId);

    List<Connection> findByDestId(Long origId);
}
