package fitnesstracker.services;

import fitnesstracker.comparators.SortByDistance;
import fitnesstracker.comparators.SortByDuration;
import fitnesstracker.comparators.SortByWeight;
import fitnesstracker.entities.exercise.DistanceCardioExercise;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.exercise.WeightLiftingExercise;
import fitnesstracker.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalBestService {

    ExerciseRepository exerciseRepository;

    @Autowired
    public PersonalBestService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise getPersonalBestDurationByExerciseNameIgnoreCase(String exerciseName) {
        List<Exercise> exercises = exerciseRepository.findExerciseByExerciseNameIgnoreCase(exerciseName);
        exercises.sort(new SortByDuration());
        return exercises.get(0);
    }

    public Exercise getPersonalBestDistanceByExerciseNameIgnoreCase(String exerciseName) {
        List<Exercise> exercises = exerciseRepository.findExerciseByExerciseNameIgnoreCase(exerciseName);
        List<DistanceCardioExercise> distanceCardioExercises = new ArrayList<>();

        for (Exercise exercise : exercises) {
            if (exercise instanceof DistanceCardioExercise distancecardioexercise) {
                distanceCardioExercises.add(distancecardioexercise);
            }
        }

        distanceCardioExercises.sort(new SortByDistance());

        return distanceCardioExercises.isEmpty() ? null : distanceCardioExercises.get(0);
    }


    public Exercise getPersonalBestWeightByExerciseNameIgnoreCase(String exerciseName) {
        List<Exercise> exercises = exerciseRepository.findExerciseByExerciseNameIgnoreCase(exerciseName);
        List<WeightLiftingExercise> weightLiftingExercises = new ArrayList<>();

        for (Exercise exercise : exercises) {
            if (exercise instanceof WeightLiftingExercise weightLiftingExercise) {
                weightLiftingExercises.add(weightLiftingExercise);
            }
        }

        weightLiftingExercises.sort(new SortByWeight());

        return weightLiftingExercises.isEmpty() ? null : weightLiftingExercises.get(0);
    }


    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

}
