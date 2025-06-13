package io.eddvance.production.servicecron.rate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rates")
public class CronController {

    private final RateHistoryService rateHistoryService;

    public CronController(RateHistoryService rateHistoryService) {
        this.rateHistoryService = rateHistoryService;
    }

    @GetMapping("last-rate")
    public RateRecord rateConsultRecord() {
        return rateHistoryService.getLatestRate().orElseThrow(() -> new RuntimeException("No record found"));
    }
    @GetMapping("/collect-now")
    public void forceCollect() {
        rateHistoryService.saveCurrentRate()
                .subscribe(
                        rate -> System.out.println("✅ Collecte manuelle réussie: " + rate.getRate()),
                        error -> System.err.println("❌ Erreur collecte manuelle: " + error.getMessage())
                );
    }
}