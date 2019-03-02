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
    private static final int MIN_SEATS_NUMBER = 0;

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
        if (seatsNumber < MIN_SEATS_NUMBER) {
            throw new IllegalArgumentException(
                    "Seats number must be greater than or equal to " + MIN_SEATS_NUMBER);
        }
        return getBuses()
                .stream()
                .filter(bus -> bus.getSeatsNumber() >= MIN_SEATS_NUMBER
                        && seatsNumber <= bus.getSeatsNumber())
                .collect(Collectors.toList());
    }

    public String collectBusNames(List<Bus> buses) {
        return buses.stream()
                .map(Bus::getName)
                .collect(Collectors.joining("\n"));
    }
}
