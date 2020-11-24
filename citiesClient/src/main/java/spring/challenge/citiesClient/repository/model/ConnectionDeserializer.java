package spring.challenge.citiesClient.repository.model;

import java.io.IOException;
import java.time.LocalTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class ConnectionDeserializer extends JsonDeserializer<Connection> {
    @Override
    public Connection deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        City orig, dest;

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Long id = node.get("id").longValue();
        JsonNode origNode = node.get("orig");
        {
            Long cityId = origNode.get("id").longValue();
            String cityName = origNode.get("name").textValue();
            double cityCoordX = origNode.get("coordX").doubleValue();
            double cityCoordY = origNode.get("coordY").doubleValue();
            orig = new City(cityId, cityName, cityCoordX, cityCoordY);
        }
        JsonNode destNode = node.get("dest");
        {
            Long cityId = destNode.get("id").longValue();
            String cityName = destNode.get("name").textValue();
            double cityCoordX = destNode.get("coordX").doubleValue();
            double cityCoordY = destNode.get("coordY").doubleValue();
            dest = new City(cityId, cityName, cityCoordX, cityCoordY);
        }
        LocalTime departureTime = LocalTime.parse(node.get("departureTime").asText());
        LocalTime arrivalTime = LocalTime.parse(node.get("arrivalTime").asText());

        return new Connection(id, orig, dest, departureTime, arrivalTime);
    }
}