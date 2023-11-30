package fitnesstracker.controllers;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.services.PersonalBestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercises/pb")
public class PersonalBestController {

    PersonalBestService personalBestService;
    @Autowired
    public PersonalBestController(PersonalBestService personalBestService) {
        this.personalBestService = personalBestService;
    }

    @GetMapping("/test")
    public Exercise getBestDeadlifts() {
        return this.personalBestService.getPersonalBestWeightByExerciseNameIgnoreCase("deadlifts");
    }

}
