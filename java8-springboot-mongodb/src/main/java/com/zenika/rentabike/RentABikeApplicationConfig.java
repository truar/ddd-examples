package com.zenika.rentabike;

import com.zenika.rentabike.application.BikeScanner;
import com.zenika.rentabike.application.BikeSearcher;
import com.zenika.rentabike.application.JourneyCreator;
import com.zenika.rentabike.application.JourneySearcher;
import com.zenika.rentabike.domain.EventBus;
import com.zenika.rentabike.domain.IdGenerator;
import com.zenika.rentabike.domain.bike.BikeRepository;
import com.zenika.rentabike.domain.journey.JourneyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RentABikeApplicationConfig {

    @Bean
    public BikeSearcher bikeSearcher(BikeRepository bikeRepository) {
        return new BikeSearcher(bikeRepository);
    }

    @Bean
    public BikeScanner bikeScanner(BikeRepository bikeRepository, EventBus eventBus) {
        return new BikeScanner(bikeRepository, eventBus);
    }

    @Bean
    public JourneyCreator journeyCreator(JourneyRepository journeyRepository, IdGenerator idGenerator) {
        return new JourneyCreator(journeyRepository, idGenerator);
    }

    @Bean
    public JourneySearcher journeySearcher(JourneyRepository journeyRepository) {
        return new JourneySearcher(journeyRepository);
    }
}
