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
    public List<Exercise> getPersonalBestWeightByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        Exercise exercise = this.personalBestService.getPersonalBestWeightByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        return this.personalBestService.listifyIfNotNull(exercise);
    }

    @GetMapping("/duration/{personId}/{exerciseName}")
    public List<Exercise> getPersonalBestDurationByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        Exercise exercise = this.personalBestService.getPersonalBestDurationByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        return this.personalBestService.listifyIfNotNull(exercise);
    }

    @GetMapping("/distance/{personId}/{exerciseName}")
    public List<Exercise> getPersonalBestDistanceByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        Exercise exercise = this.personalBestService.getPersonalBestDistanceByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        return this.personalBestService.listifyIfNotNull(exercise);
    }

    @GetMapping("/reps/{personId}/{exerciseName}")
    public List<Exercise> getPersonalBestRepsByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        Exercise exercise = this.personalBestService.getPersonalBestRepsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        return this.personalBestService.listifyIfNotNull(exercise);
    }

    @GetMapping("/sets/{personId}/{exerciseName}")
    public List<Exercise> getPersonalBestSetsByExerciseNameAndPersonId(@PathVariable Long personId, @PathVariable String exerciseName) {
        Exercise exercise = this.personalBestService.getPersonalBestSetsByPersonIdAndExerciseNameIgnoreCase(personId, exerciseName);
        return this.personalBestService.listifyIfNotNull(exercise);
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
