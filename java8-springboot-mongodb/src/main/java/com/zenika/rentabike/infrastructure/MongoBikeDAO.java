package com.zenika.rentabike.infrastructure;

import com.zenika.rentabike.domain.bike.Bike;
import com.zenika.rentabike.domain.bike.BikeId;
import com.zenika.rentabike.domain.bike.BikeStatus;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MongoBikeDAO extends MongoRepository<Bike, BikeId> {

    List<Bike> findAllByStatusAndPositionNear(BikeStatus bikeStatus, Point point, Distance distance);
}
