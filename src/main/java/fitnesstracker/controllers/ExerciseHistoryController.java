package fitnesstracker.controllers;

import fitnesstracker.entities.Person;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.services.ExerciseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
            Long personId = exercise.getPerson().getId();
            return exerciseHistoryService.getAllExercises();
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

    @GetMapping("/name/{name}")
    public List<Exercise> getExerciseByName(@PathVariable String name){
        return exerciseHistoryService.getExerciseByName(name);
    }

    @PostMapping
    public Exercise addNewExercise(@RequestBody Exercise exercise){
        Long personId = exercise.getPerson().getId();
        return exerciseHistoryService.addExercise(exercise);
    }

    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable long id){
        exerciseHistoryService.deleteById(id);
    }

    @GetMapping("/person/{personId}")
    public List<Exercise> getExerciseByPersonId(@PathVariable Long personId) {
        return exerciseHistoryService.getExerciseByPersonId(personId);
    }

    //TODO: Get Exercise by muscle group

}
