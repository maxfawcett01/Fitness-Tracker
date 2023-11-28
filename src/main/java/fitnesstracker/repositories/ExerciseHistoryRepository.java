package fitnesstracker.repositories;

import fitnesstracker.entities.exercise.Exercise;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseHistoryRepository extends ListCrudRepository<Exercise, Long> {
}
