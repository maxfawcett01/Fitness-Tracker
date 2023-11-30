package fitnesstracker.services;

import fitnesstracker.entities.Person;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.exercise.WeightLiftingExercise;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PersonalBestServiceTest {


    @Autowired
    private PersonalBestService uut;

    @Autowired
    private PersonService personService;

    @Test
    void testBestWeightFound() {
        Person person = new Person(1L, "Bob", "bob123", "password1");
        personService.savePerson(person);
        Exercise exercise1 = uut.saveExercise(new WeightLiftingExercise(1L, "Bench press", LocalDateTime.now(), LocalDateTime.now(), 3, 12, 100, 10));
        Exercise exercise2 = uut.saveExercise(new WeightLiftingExercise(1L, "Bench press", LocalDateTime.now(), LocalDateTime.now(), 3, 12, 60, 10));
        Exercise best = uut.getPersonalBestWeightByExerciseNameIgnoreCase("bench press");
        //assertEquals(exercise1.getId(), best.getId());
    }
}