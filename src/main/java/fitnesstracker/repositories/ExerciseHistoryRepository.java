package fitnesstracker.repositories;

import fitnesstracker.entities.exercise.Exercise;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseHistoryRepository extends ListCrudRepository<Exercise, Long> {
//    List<Exercise> findExerciseByNameIgnoreCase(String exercise);
}
