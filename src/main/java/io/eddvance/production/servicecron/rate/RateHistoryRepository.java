package io.eddvance.production.servicecron.rate;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RateHistoryRepository extends JpaRepository<RateRecord, Long> {

    Optional<RateRecord> findTopByOrderByRateTimeDesc();

}
