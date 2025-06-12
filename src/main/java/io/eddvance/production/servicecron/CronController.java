package io.eddvance.production.servicecron;

import io.eddvance.production.servicecron.rate.RateHistoryService;
import io.eddvance.production.servicecron.rate.RateRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CronController {

    private final RateHistoryService rateHistoryService;

    public CronController(RateHistoryService rateHistoryService) {
        this.rateHistoryService = rateHistoryService;
    }

    @GetMapping("last-rate")
    public RateRecord RateConsultRecord() {
        return rateHistoryService.getLatestRate().orElseThrow(() -> new RuntimeException("No record found"));
    }
}