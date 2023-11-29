package fitnesstracker.repositories;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.exercise.WeightLiftingExercise;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends ListCrudRepository<Exercise, Long> {

    List<Exercise> findExerciseByExerciseNameIgnoreCase(String exerciseName);

    List<Exercise> findByPerson_Id(Long personId);

    Optional<Exercise> findTopByExerciseNameOrderByWeightInKgDesc(String exerciseName);
}
