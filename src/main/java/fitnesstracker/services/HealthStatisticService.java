package fitnesstracker.services;

import fitnesstracker.entities.HealthStatistic;
import fitnesstracker.repositories.HealthStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthStatisticService {

    private final HealthStatisticRepository healthStatisticRepository;

    @Autowired
    public HealthStatisticService(HealthStatisticRepository healthStatisticRepository) {
        this.healthStatisticRepository = healthStatisticRepository;
    }

    public List<HealthStatistic> getAllHealthStatistics() {
        return healthStatisticRepository.findAll();
    }

    public HealthStatistic getHealthStatisticById(Long id) {
        return healthStatisticRepository.findById(id).orElse(null);
    }

    public HealthStatistic createHealthStatistic(HealthStatistic healthStatistic) {
        return healthStatisticRepository.save(healthStatistic);
    }

    public void deleteHealthStatistic(Long id) {
        healthStatisticRepository.deleteById(id);
    }
}
