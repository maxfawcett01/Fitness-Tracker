package fitnesstracker.services;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.repositories.ExerciseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseHistoryService {

    ExerciseHistoryRepository exerciseHistoryRepository;

    @Autowired
    public ExerciseHistoryService(ExerciseHistoryRepository exerciseHistoryRepository) {
        this.exerciseHistoryRepository = exerciseHistoryRepository;
    }

    public List<Exercise> getAllExercises() {
        return this.exerciseHistoryRepository.findAll();
    }

    public Exercise getExerciseById(long exerciseId){
        Optional<Exercise> exercise = this.exerciseHistoryRepository.findById(exerciseId);
        return exercise.orElse(null);
    }

    public Exercise addExercise(Exercise name){
        return exerciseHistoryRepository.save(name);
    }

    public void deleteById(long id) {
       exerciseHistoryRepository.deleteById(id);
    }

    public List<Exercise> getExerciseByName(String exerciseName) {
        return exerciseHistoryRepository.findExerciseByExerciseNameIgnoreCase(exerciseName);
    }

    public List<Exercise> getExerciseByPersonId(Long personId) {
        return exerciseHistoryRepository.findByPersonId(personId);
    }
}
