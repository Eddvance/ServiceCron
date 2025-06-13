package io.eddvance.production.servicecron.rate;

import io.eddvance.production.servicecron.config.WebClientConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RateHistoryService {

    private final RateHistoryRepository rateHistoryRepository;
    private final WebClient lowCarbPowerWebClient;

    public RateHistoryService(RateHistoryRepository rateHistoryRepository, WebClient lowCarbPowerWebClient) {
        this.rateHistoryRepository = rateHistoryRepository;
        this.lowCarbPowerWebClient = lowCarbPowerWebClient;
    }

    @Transactional
    public Mono<RateRecord> saveCurrentRate() {
        return lowCarbPowerWebClient
                .get()
                .uri("/low-carb-power/rate")
                .retrieve()
                .bodyToMono(String.class)
                .map(rateString -> Double.parseDouble(rateString.trim()))
                .map(rate -> new RateRecord(rate, LocalDateTime.now()))
                .map(rateHistoryRepository::save)
                .doOnSuccess(record ->
                        System.out.println("✅ Tarif enregistré: " + record.getRate() +
                                " à " + record.getRateTime())
                );
    }

    public Optional<RateRecord> getLatestRate() {
        return rateHistoryRepository.findTopByOrderByRateTimeDesc();
    }
}
