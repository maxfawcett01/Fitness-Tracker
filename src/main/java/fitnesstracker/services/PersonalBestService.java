package fitnesstracker.services;

import fitnesstracker.comparators.*;
import fitnesstracker.entities.exercise.DistanceCardioExercise;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.exercise.StrengthTrainingExercise;
import fitnesstracker.entities.exercise.WeightLiftingExercise;
import fitnesstracker.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonalBestService {

    ExerciseRepository exerciseRepository;

    @Autowired
    public PersonalBestService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        List<Exercise> exercises = exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        exercises.sort(new SortByDuration());
        return exercises.get(0);
    }

    public Exercise getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        List<Exercise> exercises = exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        List<DistanceCardioExercise> distanceCardioExercises = new ArrayList<>();

        for (Exercise exercise : exercises) {
            if (exercise instanceof DistanceCardioExercise distancecardioexercise) {
                distanceCardioExercises.add(distancecardioexercise);
            }
        }

        distanceCardioExercises.sort(new SortByDistance());

        return distanceCardioExercises.isEmpty() ? null : distanceCardioExercises.get(0);
    }

    public Exercise getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        List<Exercise> exercises = exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        List<WeightLiftingExercise> weightLiftingExercises = new ArrayList<>();

        for (Exercise exercise : exercises) {
            if (exercise instanceof WeightLiftingExercise weightLiftingExercise) {
                weightLiftingExercises.add(weightLiftingExercise);
            }
        }

        weightLiftingExercises.sort(new SortByWeight());

        return weightLiftingExercises.isEmpty() ? null : weightLiftingExercises.get(0);
    }

    public Exercise getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        List<Exercise> exercises = exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        List<StrengthTrainingExercise> strengthTrainingExercises = new ArrayList<>();
        for (Exercise exercise : exercises) {
            if (exercise instanceof StrengthTrainingExercise) {
                strengthTrainingExercises.add((StrengthTrainingExercise) exercise);
            }
        }
        strengthTrainingExercises.sort(new SortByReps());
        return exercises.get(0);
    }

    public Exercise getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        List<Exercise> exercises = exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        List<StrengthTrainingExercise> strengthTrainingExercises = new ArrayList<>();
        for (Exercise exercise : exercises) {
            if (exercise instanceof StrengthTrainingExercise) {
                strengthTrainingExercises.add((StrengthTrainingExercise) exercise);
            }
        }
        strengthTrainingExercises.sort(new SortBySets());
        return exercises.get(0);
    }

    public List<Exercise> getPersonalBestDurationByPersonId(Long personId) {
        List<Exercise> exercisesById = exerciseRepository.findByPersonId(personId);
        List<Exercise> bestDurationExercises = new ArrayList<>();
        Set<String> exerciseNames = new HashSet<>();
        for (Exercise exercise : exercisesById) {
            exerciseNames.add(exercise.getExerciseName().toLowerCase());
        }
        for (String exerciseName : exerciseNames) {
            bestDurationExercises.add(getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName));
        }
        return bestDurationExercises;
    }

    public List<Exercise> getPersonalBestDistanceByPersonId(Long personId) {
        List<Exercise> exercisesById = exerciseRepository.findByPersonId(personId);
        List<Exercise> bestDistanceExercises = new ArrayList<>();
        Set<String> exerciseNames = new HashSet<>();
        for (Exercise exercise : exercisesById) {
            exerciseNames.add(exercise.getExerciseName().toLowerCase());
        }
        for (String exerciseName : exerciseNames) {
            bestDistanceExercises.add(getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName));
        }
        return bestDistanceExercises;
    }

    public List<Exercise> getPersonalBestWeightByPersonId(Long personId) {
        List<Exercise> exercisesById = exerciseRepository.findByPersonId(personId);
        List<Exercise> bestWeightExercises = new ArrayList<>();
        Set<String> exerciseNames = new HashSet<>();
        for (Exercise exercise : exercisesById) {
            exerciseNames.add(exercise.getExerciseName().toLowerCase());
        }
        for (String exerciseName : exerciseNames) {
            bestWeightExercises.add(getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName));
        }
        return bestWeightExercises;
    }

    public List<Exercise> getPersonalBestRepsByPersonId(Long personId) {
        List<Exercise> exercisesById = exerciseRepository.findByPersonId(personId);
        List<Exercise> bestRepsExercises = new ArrayList<>();
        Set<String> exerciseNames = new HashSet<>();
        for (Exercise exercise : exercisesById) {
            exerciseNames.add(exercise.getExerciseName().toLowerCase());
        }
        for (String exerciseName : exerciseNames) {
            bestRepsExercises.add(getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName));
        }
        return bestRepsExercises;
    }

    public List<Exercise> getPersonalBestSetsByPersonId(Long personId) {
        List<Exercise> exercisesById = exerciseRepository.findByPersonId(personId);
        List<Exercise> bestSetsExercises = new ArrayList<>();
        Set<String> exerciseNames = new HashSet<>();
        for (Exercise exercise : exercisesById) {
            exerciseNames.add(exercise.getExerciseName().toLowerCase());
        }
        for (String exerciseName : exerciseNames) {
            bestSetsExercises.add(getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName));
        }
        return bestSetsExercises;
    }

    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

}
