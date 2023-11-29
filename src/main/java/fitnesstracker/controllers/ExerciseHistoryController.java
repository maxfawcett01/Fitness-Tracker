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

    @GetMapping("/{exerciseId}")
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
    public ResponseEntity<Object> addNewExercise(@RequestBody @Valid Exercise exercise, BindingResult result) {
        if (exercise == null) {
            return new ResponseEntity<>("Request body is empty.", HttpStatus.BAD_REQUEST);
        }
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Long personId = exercise.getPersonId();

        List<Exercise> exercisesByPersonId = exerciseHistoryService.findByPersonId(personId);
        if (exercisesByPersonId.isEmpty()) {
            return new ResponseEntity<>("Person with ID: " + personId + " cannot be found in the database.", HttpStatus.NOT_FOUND);
        }

        @SuppressWarnings("unused")
        Long personId = exercise.getPersonId();

        Exercise addedExercise = exerciseHistoryService.addExercise(exercise);
        return new ResponseEntity<>(addedExercise, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable long id){
        exerciseHistoryService.deleteById(id);
    }

    @GetMapping("/person/{personId}")
    public List<Exercise> findByPersonId(@PathVariable Long personId) {
        return exerciseHistoryService.findByPersonId(personId);
    }

}
