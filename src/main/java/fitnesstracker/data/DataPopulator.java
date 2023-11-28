package fitnesstracker.data;

import fitnesstracker.entities.Person;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.exercise.WeightLiftingExercise;
import fitnesstracker.entities.health.HealthStatistic;
import fitnesstracker.entities.meal.Ingredient;
import fitnesstracker.entities.meal.Meal;
import fitnesstracker.services.ExerciseHistoryService;
import fitnesstracker.services.HealthStatisticService;
import fitnesstracker.services.MealService;
import jakarta.annotation.PostConstruct;
import fitnesstracker.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
public class DataPopulator {

    private final MealService mealService;
    private final HealthStatisticService healthStatisticService;

    private final PersonService personService;
    private final ExerciseHistoryService exerciseHistoryService;

    @Autowired
    public DataPopulator(MealService mealService, HealthStatisticService healthStatisticService,  ExerciseHistoryService exerciseHistoryService, PersonService personService) {
        this.mealService = mealService;
        this.healthStatisticService = healthStatisticService;
        this.exerciseHistoryService = exerciseHistoryService;
        this.personService = personService;

    }

    @EventListener(ContextRefreshedEvent.class)
    public void populateData() {
        // Insert sample meals with ingredients
        Meal meal1 = new Meal("Chicken Stir Fry", "Lunch", 500, "Stir-fry chicken with vegetables and soy sauce", new ArrayList<>());
        meal1.getIngredientList().add(new Ingredient(meal1, "Chicken"));
        meal1.getIngredientList().add(new Ingredient(meal1, "Vegetables"));
        meal1.getIngredientList().add(new Ingredient(meal1, "Soy Sauce"));

        Meal meal2 = new Meal("Salmon Salad", "Dinner", 400, "Grilled salmon served with a fresh salad", new ArrayList<>());
        meal2.getIngredientList().add(new Ingredient(meal2, "Salmon"));
        meal2.getIngredientList().add(new Ingredient(meal2, "Fresh Salad"));

        Meal meal3 = new Meal("Vegetarian Pasta", "Dinner", 600, "Pasta with tomato sauce, vegetables, and cheese", new ArrayList<>());
        meal3.getIngredientList().add(new Ingredient(meal3, "Pasta"));
        meal3.getIngredientList().add(new Ingredient(meal3, "Tomato Sauce"));
        meal3.getIngredientList().add(new Ingredient(meal3, "Vegetables"));
        meal3.getIngredientList().add(new Ingredient(meal3, "Cheese"));

        // Save meals to the database
        mealService.saveMeal(meal1);
        mealService.saveMeal(meal2);
        mealService.saveMeal(meal3);

//*******************************************************************************
        LocalDate date = null;
        HealthStatistic healthStatistic1 = new HealthStatistic( date, 23.0,60.0, 80.0, 90.0,480.0, 620.0, 65.0, 10.0);

        healthStatisticService.createHealthStatistic(healthStatistic1) ;
        HealthStatistic healthStatistic2 = new HealthStatistic( date, 24.0,61.0, 81.0, 91.0,481.0, 621.0, 66.0, 11.0);
        healthStatisticService.createHealthStatistic(healthStatistic2) ;

        Person person1 = new Person(1L, "Bob", "bob123", "password1");
        personService.savePerson(person1);
        Person person2 = new Person(2L, "Tom", "tom123", "password2");
        personService.savePerson(person2);

        Exercise exercise1 = new Exercise(person1,"Barbell rows", LocalDateTime.of(2023, 11, 28, 10, 0), LocalDateTime.of(2023, 11, 28, 11, 0));
        exercise1.setEquipmentRequired("Barbell and free weights");
        exercise1.setDescription("Just do whatever man");
        exerciseHistoryService.addExercise(exercise1);

        Exercise exercise2 = new Exercise(person2, "Bench press", LocalDateTime.of(2023, 11, 25, 10, 0), LocalDateTime.of(2023, 11, 25, 11, 0));
        exercise2.setEquipmentRequired("Barbell and free weights");
        exercise2.setDescription("Just don't pop your shoulder");
        exerciseHistoryService.addExercise(exercise2);

        WeightLiftingExercise exercise3 = new WeightLiftingExercise(person1, "Deadlifts", LocalDateTime.now(), LocalDateTime.now(), 3, 12, 100);
        exercise3.setEquipmentRequired("Barbell and free weights");
        exercise3.setDescription("Just don't pop your shoulder");
        exerciseHistoryService.addExercise(exercise3);

    }
}
