package fitnesstracker.controllers;

import fitnesstracker.entities.Person;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.services.ExerciseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
            exercise.setPersonId(personId);
            return exerciseHistoryService.getAllExercises();
        }
        return exercises;
    }

    @GetMapping("/{exerciseId}")
    public Exercise getExerciseById(@PathVariable long exerciseId){
        Exercise exercise = exerciseHistoryService.getExerciseById(exerciseId);
        return exercise;
    }

    //TODO: Fix this - Throws exemption
//    @GetMapping("/{exerciseName}")
//    public List<Exercise> getExerciseByName(@PathVariable String exerciseName){
//        List<Exercise> exercises = exerciseHistoryService.getExerciseByName(exerciseName);
//        return exercises;
//    }

    @PostMapping
    public Exercise addNewExercise(@RequestBody Exercise exercise){
        Long personId = exercise.getPerson().getId();
        exercise.setPersonId(personId);
        return exerciseHistoryService.addExercise(exercise);
    }

    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable long id){
        exerciseHistoryService.deleteById(id);
    }


    //TODO: Get Exercise by muscle group

}
