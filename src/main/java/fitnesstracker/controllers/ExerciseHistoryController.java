package fitnesstracker.controllers;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.services.ExerciseHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseHistoryController {

    ExerciseHistoryService exerciseHistoryService;

    @Autowired
    public ExerciseHistoryController(ExerciseHistoryService exerciseHistoryService) {
        this.exerciseHistoryService = exerciseHistoryService;
    }

    @GetMapping
    public Iterable<Exercise> getAllExercises() {
        try {
            return exerciseHistoryService.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while fetching meals", e);
        }
    }

    @GetMapping("/exercise/{exerciseId}")
    public Exercise getExerciseById(@PathVariable Long exerciseId) {
        Exercise exercise = exerciseHistoryService.getExerciseById(exerciseId);
        if (exercise != null) {
            return exercise;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercise not found");
        }
    }

    @GetMapping("/name/{exerciseName}")
    public List<Exercise> getExerciseByName(@PathVariable String exerciseName){
        return exerciseHistoryService.getExerciseByName(exerciseName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Exercise addNewExercise(@RequestBody(required = false) @Valid Exercise exercise) {
        Exercise newExercise;

        try {
            newExercise = exerciseHistoryService.addExercise(exercise);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return newExercise;
    }


    @DeleteMapping("/exercise/{id}")
    public void deleteExercise(@PathVariable long id){
        exerciseHistoryService.deleteById(id);
    }

    @GetMapping("/person/{personId}")
    public List<Exercise> findAllExercisesByPersonId(@PathVariable Long personId) {
        return exerciseHistoryService.findByPersonId(personId);
    }

    @GetMapping("/person/{personId}/{exerciseName}")
    public List<Exercise> findAllExercisesByPersonIdAndExerciseName(@PathVariable  Long personId, @PathVariable String exerciseName) {
        return exerciseHistoryService.findExerciseByPersonIdAndExerciseName(personId, exerciseName);
    }
}
