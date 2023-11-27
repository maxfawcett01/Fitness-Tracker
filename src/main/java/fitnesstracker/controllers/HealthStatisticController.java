package fitnesstracker.controllers;


import fitnesstracker.entities.health.HealthStatistic;
import fitnesstracker.services.HealthStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health-statistics")
public class HealthStatisticController {

    private final HealthStatisticService healthStatisticService ;

    @Autowired
    public HealthStatisticController(HealthStatisticService healthStatisticService) {
        this.healthStatisticService = healthStatisticService;
    }

    @GetMapping
    public List<HealthStatistic> getAllHealthStatistics() {
        return healthStatisticService.getAllHealthStatistics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthStatistic> getHealthStatisticById(@PathVariable Long id) {
        HealthStatistic healthStatistic = healthStatisticService.getHealthStatisticById(id);

        if (healthStatistic != null) {
            return ResponseEntity.ok(healthStatistic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<HealthStatistic> createHealthStatistic(@RequestBody HealthStatistic healthStatistic) {
        HealthStatistic createdHealthStatistic = healthStatisticService.createHealthStatistic(healthStatistic);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHealthStatistic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHealthStatistic(@PathVariable Long id) {
        healthStatisticService.deleteHealthStatistic(id);
        return ResponseEntity.noContent().build();
    }
}

