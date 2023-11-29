package fitnesstracker.services;

import fitnesstracker.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalBestsService {

    ExerciseRepository exerciseRepository;

    @Autowired
    public PersonalBestsService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

//    public List<Exercise> getPersonalBestByExerciseName(String exerciseName) {
//        List<Exercise> exercises = this.exerciseRepository.findAll();
//        g
//        return
//    }

}
