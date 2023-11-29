package fitnesstracker.services;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.repositories.ExerciseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalBestsService {

    ExerciseHistoryRepository exerciseHistoryRepository;

    @Autowired
    public PersonalBestsService(ExerciseHistoryRepository exerciseHistoryRepository) {
        this.exerciseHistoryRepository = exerciseHistoryRepository;
    }

//    public List<Exercise> getPersonalBestByExerciseName(String exerciseName) {
//        List<Exercise> exercises = this.exerciseHistoryRepository.findAll();
//        g
//        return
//    }

}
