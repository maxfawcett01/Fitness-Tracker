package fitnesstracker.controllers;

import fitnesstracker.entities.health.HealthStatistic;
import fitnesstracker.services.HealthStatisticService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.List;

@RestController
@RequestMapping("/stat")
@Api(tags = "Health Statistics")
public class HealthStatisticController {

    private final HealthStatisticService healthStatisticService ;

    @Autowired
    public HealthStatisticController(HealthStatisticService healthStatisticService) {
        this.healthStatisticService = healthStatisticService;
    }

    @GetMapping
    @ApiOperation("Get all health statistics")
    public List<HealthStatistic> getAllHealthStatistics() {
        return healthStatisticService.getAllHealthStatistics();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a health statistic by ID")
    public ResponseEntity<HealthStatistic> getHealthStatisticById(@PathVariable Long id) {
        HealthStatistic healthStatistic = healthStatisticService.getHealthStatisticById(id);

        if (healthStatistic != null) {
            return ResponseEntity.ok(healthStatistic);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ApiOperation("Create a new health statistic")
    public ResponseEntity<HealthStatistic> createHealthStatistic(@RequestBody HealthStatistic healthStatistic) {
        HealthStatistic createdHealthStatistic = healthStatisticService.createHealthStatistic(healthStatistic);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHealthStatistic);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a health statistic by ID")
    public ResponseEntity<Void> deleteHealthStatistic(@PathVariable Long id) {
        healthStatisticService.deleteHealthStatistic(id);
        return ResponseEntity.noContent().build();
    }
}
