package edu.lntu;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class BusService {

    private static final String BUSES_FILEPATH = "/buses.json";

    @Setter
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Bus> getBuses() {
        try {
            return Arrays.asList(objectMapper.readValue(
                    getClass().getResource(BUSES_FILEPATH), Bus[].class));
        } catch (IOException e) {
            throw new ParsingException("Can't parse buses JSON", e);
        }
    }

    public List<Bus> getBusesBySeatsNumber(int seatsNumber) {
        return getBuses()
                .stream()
                .filter(bus -> seatsNumber == bus.getSeatsNumber())
                .collect(Collectors.toList());
    }

    public String stringifyBuses(List<Bus> buses) {
        return buses.stream()
                .map(Bus::getName)
                .collect(Collectors.joining("\n"));
    }
}
