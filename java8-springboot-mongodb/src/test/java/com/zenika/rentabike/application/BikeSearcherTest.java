package com.zenika.rentabike.application;

import com.zenika.rentabike.domain.bike.Bike;
import com.zenika.rentabike.domain.bike.BikeId;
import com.zenika.rentabike.domain.bike.BikeRepository;
import com.zenika.rentabike.domain.standard.Position;
import com.zenika.rentabike.domain.standard.Zone;
import com.zenika.rentabike.doubles.BikeRepositoryDouble;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BikeSearcherTest {

    @Test
    void findsAvailableBikesNearby() {
        BikeRepository bikeRepository = new BikeRepositoryDouble();
        BikeSearcher bikeSearcher = new BikeSearcher(bikeRepository);
        Bike bikeNearby = new Bike(new BikeId("123"), new Position(2.33d, 48.88d));
        bikeRepository.save(bikeNearby);

        List<Bike> bikes = bikeSearcher.getAllAvailableInZone(new Zone(48.80d, 2.20d, 380));

        assertThat(bikes).containsExactly(bikeNearby);
    }
}
