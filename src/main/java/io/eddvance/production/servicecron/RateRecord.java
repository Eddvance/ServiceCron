package io.eddvance.production.servicecron;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalTime;

@EntityScan
public class RateRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Double rate;
    private LocalTime rateTime;

    public RateRecord(Long id, Double rate, LocalTime rateTime) {
        this.id = id;
        this.rate = rate;
        this.rateTime = rateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public LocalTime getRateTime() {
        return rateTime;
    }

    public void setRateTime(LocalTime rateTime) {
        this.rateTime = rateTime;
    }
}
