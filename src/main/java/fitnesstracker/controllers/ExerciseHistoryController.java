package fitnesstracker.controllers;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.services.ExerciseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercises")
public class ExerciseHistoryController {

    ExerciseHistoryService exerciseHistoryService;
    @Autowired
    public ExerciseHistoryController(ExerciseHistoryService exerciseHistoryService) {
        this.exerciseHistoryService = exerciseHistoryService;
    }

    @GetMapping
    public Iterable<Exercise> getAllExercises(){
        return exerciseHistoryService.getAllExercises();
    }

    @GetMapping("/{exerciseId}")
    public Exercise getExerciseById(@PathVariable long exerciseId){
        Exercise exercise = exerciseHistoryService.getExerciseById(exerciseId);
        return exercise;
    }

    @PostMapping
    public Exercise addNewExercise(@RequestBody Exercise exercise){
        return exerciseHistoryService.addExercise(exercise);
    }

}
