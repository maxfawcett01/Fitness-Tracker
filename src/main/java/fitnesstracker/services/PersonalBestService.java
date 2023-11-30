package fitnesstracker.services;

import com.google.common.collect.Iterables;
import fitnesstracker.comparators.*;
import fitnesstracker.entities.exercise.DistanceCardioExercise;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.exercise.StrengthTrainingExercise;
import fitnesstracker.entities.exercise.WeightLiftingExercise;
import fitnesstracker.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonalBestService {

    ExerciseRepository exerciseRepository;

    @Autowired
    public PersonalBestService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        try {
            List<Exercise> exercises = exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
            exercises.sort(new SortByDuration());
            Collections.reverse(exercises);
            return exercises.get(0);
        } catch (IndexOutOfBoundsException ioobe) {
            return null;
        }
    }

    public Exercise getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        try {
            List<Exercise> exercises = exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
            List<DistanceCardioExercise> distanceCardioExercises = new ArrayList<>();
            for (Exercise exercise : exercises) {
                if (exercise instanceof DistanceCardioExercise) {
                    distanceCardioExercises.add((DistanceCardioExercise) exercise);
                }
            }
            distanceCardioExercises.sort(new SortByDistance());
            Collections.reverse(distanceCardioExercises);
            return distanceCardioExercises.get(0);
        } catch (IndexOutOfBoundsException ioobe) {
            return null;
        }
    }

    public Exercise getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        try {
            List<Exercise> exercises = exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
            List<WeightLiftingExercise> weightLiftingExercises = new ArrayList<>();
            for (Exercise exercise : exercises) {
                if (exercise instanceof WeightLiftingExercise) {
                    weightLiftingExercises.add((WeightLiftingExercise) exercise);
                }
            }
            weightLiftingExercises.sort(new SortByWeight());
            Collections.reverse(weightLiftingExercises);
            return weightLiftingExercises.get(0);
        } catch (IndexOutOfBoundsException ioobe) {
            return null;
        }
    }

    public Exercise getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        try {
            List<Exercise> exercises = exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
            List<StrengthTrainingExercise> strengthTrainingExercises = new ArrayList<>();
            for (Exercise exercise : exercises) {
                if (exercise instanceof StrengthTrainingExercise) {
                    strengthTrainingExercises.add((StrengthTrainingExercise) exercise);
                }
            }
            strengthTrainingExercises.sort(new SortByReps());
            Collections.reverse(strengthTrainingExercises);
            return strengthTrainingExercises.get(0);
        } catch (IndexOutOfBoundsException ioobe) {
            return null;
        }
    }

    public Exercise getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(Long personId, String exerciseName) {
        try {
            List<Exercise> exercises = exerciseRepository.findExerciseByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
            List<StrengthTrainingExercise> strengthTrainingExercises = new ArrayList<>();
            for (Exercise exercise : exercises) {
                if (exercise instanceof StrengthTrainingExercise) {
                    strengthTrainingExercises.add((StrengthTrainingExercise) exercise);
                }
            }
            strengthTrainingExercises.sort(new SortBySets());
            Collections.reverse(strengthTrainingExercises);
            return strengthTrainingExercises.get(0);
        } catch (IndexOutOfBoundsException ioobe) {
            return null;
        }
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
        Iterables.removeIf(bestDurationExercises, Objects::isNull);
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
        Iterables.removeIf(bestDistanceExercises, Objects::isNull);
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
        Iterables.removeIf(bestWeightExercises, Objects::isNull);
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
        Iterables.removeIf(bestRepsExercises, Objects::isNull);
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
        Iterables.removeIf(bestSetsExercises, Objects::isNull);
        return bestSetsExercises;
    }

    public List<Exercise> listifyIfNotNull(Exercise exercise) {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(exercise);
        Iterables.removeIf(exercises, Objects::isNull);
        return exercises;
    }

    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }
}
