package io.eddvance.production.servicecron;

import jakarta.persistence.*;

import java.time.LocalTime;


@Entity
@Table(name = "lowcarbpower_history")
public class RateRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double rate;

    @Column(nullable = false)
    private LocalTime rateTime;

    public RateRecord(Double rate, LocalTime rateTime) {
        this.rate = rate;
        this.rateTime = rateTime;
    }

    public RateRecord() {
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
