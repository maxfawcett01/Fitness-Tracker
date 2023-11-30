package fitnesstracker.controllers;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.services.ExerciseHistoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        Iterable<Exercise> exercises = exerciseHistoryService.getAllExercises();
        for (Exercise exercise : exercises) {
             @SuppressWarnings("unused")
             Long personId = exercise.getPersonId();
        }
        return exercises;
    }

    @GetMapping("/exercise/{exerciseId}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable long exerciseId) {
        Exercise exercise = exerciseHistoryService.getExerciseById(exerciseId);
        if (exercise != null) {
            return ResponseEntity.ok(exercise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{exerciseName}")
    public List<Exercise> getExerciseByName(@PathVariable String exerciseName){
        return exerciseHistoryService.getExerciseByName(exerciseName);
    }

    @PostMapping
    public ResponseEntity<Object> addNewExercise(@RequestBody(required = false) @Valid Exercise exercise, BindingResult result) {
        if (exercise == null) {
            return new ResponseEntity<>("Request body is empty. Please provide a request body!", HttpStatus.BAD_REQUEST);
        }
        Long personId = exercise.getPersonId();

        List<Exercise> exercisesByPersonId = exerciseHistoryService.findByPersonId(personId);
        if (exercisesByPersonId.isEmpty()) {
            return new ResponseEntity<>("Person with ID: " + personId + " cannot be found in the database.", HttpStatus.NOT_FOUND);
        }

        Exercise addedExercise = exerciseHistoryService.addExercise(exercise);
        return new ResponseEntity<>(addedExercise, HttpStatus.CREATED);
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
