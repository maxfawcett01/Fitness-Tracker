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
import fitnesstracker.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDate;

@Component
public class DataPopulate {

    private final MealService mealService;
    private final HealthStatisticService healthStatisticService;

    private final PersonService personService;
    private final ExerciseHistoryService exerciseHistoryService;

    @Autowired
    public DataPopulate(MealService mealService, HealthStatisticService healthStatisticService, ExerciseHistoryService exerciseHistoryService, PersonService personService) {
        this.mealService = mealService;
        this.healthStatisticService = healthStatisticService;
        this.exerciseHistoryService = exerciseHistoryService;
        this.personService = personService;
    }

    public void populateData() {

        LocalDate date = null;

        //*******************************************************************************
        Person person1 = new Person(1L, "Bob", "bob123", "password1");
        personService.savePerson(person1);
        Person person2 = new Person(2L, "Tom", "tom123", "password2");
        personService.savePerson(person2);
        //*******************************************************************************
        // Insert sample meals with ingredients
        Meal meal1 = new Meal(date,"Chicken Stir Fry", "Lunch", 500, "Stir-fry chicken with vegetables and soy sauce", new ArrayList<>(), person1.getId());
        meal1.getIngredientList().add(new Ingredient(meal1, "Chicken"));
        meal1.getIngredientList().add(new Ingredient(meal1, "Vegetables"));
        meal1.getIngredientList().add(new Ingredient(meal1, "Soy Sauce"));

        Meal meal2 = new Meal(date,"Salmon Salad", "Dinner", 400, "Grilled salmon served with a fresh salad", new ArrayList<>(), person2.getId());
        meal2.getIngredientList().add(new Ingredient(meal2, "Salmon"));
        meal2.getIngredientList().add(new Ingredient(meal2, "Fresh Salad"));

        Meal meal3 = new Meal(date,"Vegetarian Pasta", "Dinner", 600, "Pasta with tomato sauce, vegetables, and cheese", new ArrayList<>(), person1.getId());
        meal3.getIngredientList().add(new Ingredient(meal3, "Pasta"));
        meal3.getIngredientList().add(new Ingredient(meal3, "Tomato Sauce"));
        meal3.getIngredientList().add(new Ingredient(meal3, "Vegetables"));
        meal3.getIngredientList().add(new Ingredient(meal3, "Cheese"));

        // Save meals to the database
        mealService.saveMeal(meal1);
        mealService.saveMeal(meal2);
        mealService.saveMeal(meal3);

//*******************************************************************************

        HealthStatistic healthStatistic1 = new HealthStatistic(null, 23.0,60.0, 80.0, 90.0,480, 620.0, 65.0, 10.0, person1.getId());

        healthStatisticService.createHealthStatistic(healthStatistic1) ;
        HealthStatistic healthStatistic2 = new HealthStatistic(null, 24.0,61.0, 81.0, 91.0,481, 621.0, 66.0, 11.0, person2.getId());
        healthStatisticService.createHealthStatistic(healthStatistic2) ;
        HealthStatistic healthStatistic3 = new HealthStatistic(null, 24.0,61.0, 81.0, 91.0,481, 621.0, 66.0, 11.0,person1.getId());
        healthStatisticService.createHealthStatistic(healthStatistic3) ;

//*******************************************************************************
        Exercise exercise1 = new Exercise(person1.getId(),"Barbell rows", LocalDateTime.of(2023, 11, 28, 10, 0), LocalDateTime.of(2023, 11, 28, 11, 0), 250);
        exercise1.setEquipmentRequired("Barbell and free weights");
        exercise1.setDescription("Just do whatever man");
        exerciseHistoryService.addExercise(exercise1);

        Exercise exercise2 = new Exercise(person2.getId(), "Bench press", LocalDateTime.of(2023, 11, 25, 10, 0), LocalDateTime.of(2023, 11, 25, 11, 0), 200);
        exercise2.setEquipmentRequired("Barbell and free weights");
        exercise2.setDescription("Just don't pop your shoulder");
        exerciseHistoryService.addExercise(exercise2);

        WeightLiftingExercise exercise3 = new WeightLiftingExercise(person1.getId(), "Deadlifts", LocalDateTime.now(), LocalDateTime.now(), 200, 3, 12, 100);
        exerciseHistoryService.addExercise(exercise3);
    }
}
