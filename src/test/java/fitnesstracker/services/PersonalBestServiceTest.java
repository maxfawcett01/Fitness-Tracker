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

    @Test
    void testBestWeightFound() {
        Person person = new Person();
        Exercise exercise1 = new WeightLiftingExercise(person, "Bench press", LocalDateTime.now(), LocalDateTime.now(), 3, 12, 100);
        Exercise exercise2 = new WeightLiftingExercise(person, "Bench press", LocalDateTime.now(), LocalDateTime.now(), 3, 12, 60);
        uut.saveExercise(exercise1);
        uut.saveExercise(exercise2);
        Exercise best = uut.getPersonalBestWeightByExerciseName("Bench press");
        assertEquals(exercise1, best);
    }
}