package fitnesstracker.repositories;

import fitnesstracker.entities.HealthStatistic;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HealthStatisticRepository extends ListCrudRepository<HealthStatistic, Long> {
    List<HealthStatistic> findByDate(LocalDate date);
}
