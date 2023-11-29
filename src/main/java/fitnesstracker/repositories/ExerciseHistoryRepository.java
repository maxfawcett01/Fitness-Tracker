package fitnesstracker.repositories;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.exercise.WeightLiftingExercise;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseHistoryRepository extends ListCrudRepository<Exercise, Long> {

    Optional<Exercise> findTopByExerciseNameOrderByWeightInKgDesc(String exerciseName);
    List<Exercise> findExerciseByNameIgnoreCase(String name);
    List<Exercise> findByPerson_Id(Long personId);
}
