package fitnesstracker.services;

import fitnesstracker.entities.Person;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.exercise.WeightLiftingExercise;
import fitnesstracker.entities.meal.Ingredient;
import fitnesstracker.entities.meal.Meal;
import fitnesstracker.repositories.ExerciseRepository;
import fitnesstracker.repositories.MealRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        //Exercise best = uut.getPersonalBestWeightByExerciseNameIgnoreCase("bench press");
//        assertEquals(exercise1.getId(), best.getId());
    }
}