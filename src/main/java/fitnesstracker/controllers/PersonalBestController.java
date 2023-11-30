package fitnesstracker.controllers;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.services.PersonalBestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercises/pb")
public class PersonalBestController {

    PersonalBestService personalBestService;
    @Autowired
    public PersonalBestController(PersonalBestService personalBestService) {
        this.personalBestService = personalBestService;
    }

    @GetMapping("/weight/{personId}/{exerciseName}")
    public Exercise getPersonalBestWeightByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        return this.personalBestService.getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
    }

    @GetMapping("/duration/{personId}/{exerciseName}")
    public Exercise getPersonalBestDurationByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        return this.personalBestService.getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
    }

    @GetMapping("/distance/{personId}/{exerciseName}")
    public Exercise getPersonalBestDistanceByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        return this.personalBestService.getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
    }

    @GetMapping("/reps/{personId}/{exerciseName}")
    public Exercise getPersonalBestRepsByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        return this.personalBestService.getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
    }

    @GetMapping("/sets/{personId}/{exerciseName}")
    public Exercise getPersonalBestSetsByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        return this.personalBestService.getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
    }

    @GetMapping("/weight/{personId}")
    public List<Exercise> getPersonalBestWeightPersonId(@PathVariable Long personId) {
        return this.personalBestService.getPersonalBestWeightByPersonId(personId);
    }

    @GetMapping("/duration/{personId}")
    public List<Exercise> getPersonalBestDurationPersonId(@PathVariable Long personId) {
        return this.personalBestService.getPersonalBestDurationByPersonId(personId);
    }

    @GetMapping("/distance/{personId}")
    public List<Exercise> getPersonalBestDistancePersonId(@PathVariable Long personId) {
        return this.personalBestService.getPersonalBestDistanceByPersonId(personId);
    }

    @GetMapping("/reps/{personId}")
    public List<Exercise> getPersonalBestRepsPersonId(@PathVariable Long personId) {
        return this.personalBestService.getPersonalBestRepsByPersonId(personId);
    }

    @GetMapping("/sets/{personId}")
    public List<Exercise> getPersonalBestSetsPersonId(@PathVariable Long personId) {
        return this.personalBestService.getPersonalBestSetsByPersonId(personId);
    }

}
