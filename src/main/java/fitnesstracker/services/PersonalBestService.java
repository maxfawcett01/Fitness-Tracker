package fitnesstracker.services;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalBestService {

    ExerciseRepository exerciseRepository;

    @Autowired
    public PersonalBestService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise getPersonalBestWeightByExerciseName(String exerciseName) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findTopByExerciseNameOrderByWeightInKgDesc(exerciseName);
        return exerciseOptional.orElse(null);
    }

    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

}
