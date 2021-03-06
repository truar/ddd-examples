package com.zenika.rentabike.infrastructure;

import com.zenika.rentabike.domain.bike.BikeId;
import com.zenika.rentabike.domain.journey.Journey;
import com.zenika.rentabike.domain.journey.JourneyRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Repository
public class InMemoryJourneyRepository implements JourneyRepository {

    private final Map<String, Journey> database = new HashMap<>();

    @Override
    public void save(Journey journey) {
        database.put(journey.getId().getValue(), journey);
    }

    @Override
    public List<Journey> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public List<Journey> findAllByBike(BikeId bikeId) {
        return database.values().stream()
                .filter(journey -> bikeId.equals(journey.getBikeId()))
                .collect(toList());
    }

    @Override
    public void deleteAll() {
        database.clear();
    }
}
