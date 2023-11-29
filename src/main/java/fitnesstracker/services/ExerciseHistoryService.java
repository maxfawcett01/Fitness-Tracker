package fitnesstracker.services;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseHistoryService {

    ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseHistoryService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercises() {
        return this.exerciseRepository.findAll();
    }

    public Exercise getExerciseById(long exerciseId){
        Optional<Exercise> exercise = this.exerciseRepository.findById(exerciseId);
        return exercise.orElse(null);
    }

    public Exercise addExercise(Exercise name){
        return exerciseRepository.save(name);
    }

    public void deleteById(long id) {
       exerciseRepository.deleteById(id);
    }

    public List<Exercise> getExerciseByName(String exerciseName) {
        return exerciseRepository.findExerciseByExerciseNameIgnoreCase(exerciseName);
    }

    public List<Exercise> getExerciseByPersonId(Long personId) {
        return exerciseRepository.findByPerson_Id(personId);
    }
}
