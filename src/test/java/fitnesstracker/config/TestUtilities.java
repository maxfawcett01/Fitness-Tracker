package fitnesstracker.config;

import fitnesstracker.entities.Person;
import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.meal.Ingredient;
import fitnesstracker.entities.meal.Meal;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestUtilities {
    public static @NotNull ArrayList<Meal> getMealList() {
        Person person1 = new Person(1L, "Bob", "bob123", "password1");
        ArrayList<Meal> meals = new ArrayList<>();
        Meal meal1 = new Meal(null, "Chicken Stir Fry", "Lunch", 500, "Stir-fry chicken with vegetables and soy sauce", new ArrayList<>(), person1.getId());
        meal1.getIngredientList().add(new Ingredient(meal1, "Chicken"));
        meal1.getIngredientList().add(new Ingredient(meal1, "Vegetables"));
        meal1.getIngredientList().add(new Ingredient(meal1, "Soy Sauce"));

        Meal meal2 = new Meal(null,"Salmon Salad", "Dinner", 400, "Grilled salmon served with a fresh salad", new ArrayList<>(),  person1.getId());
        meal2.getIngredientList().add(new Ingredient(meal2, "Salmon"));
        meal2.getIngredientList().add(new Ingredient(meal2, "Fresh Salad"));

        Meal meal3 = new Meal(null,"Vegetarian Pasta", "Dinner", 600, "Pasta with tomato sauce, vegetables, and cheese", new ArrayList<>(), person1.getId());
        meal3.getIngredientList().add(new Ingredient(meal3, "Pasta"));
        meal3.getIngredientList().add(new Ingredient(meal3, "Tomato Sauce"));
        meal3.getIngredientList().add(new Ingredient(meal3, "Vegetables"));
        meal3.getIngredientList().add(new Ingredient(meal3, "Cheese"));

        meals.add(meal1);
        meals.add(meal2);
        meals.add(meal3);
        return meals;
    }

    public static @NotNull List<Exercise> getExerciseList() {
        Exercise exercise1 = new Exercise(1L, "running", LocalDateTime.of(2020, 12, 3,3,30), LocalDateTime.of(2020, 12, 3,3,59), 100);
        Exercise exercise2 = new Exercise(123L, "Weights", LocalDateTime.of(2020, 12, 3,3,30), LocalDateTime.of(2020, 12, 3,3,59), 100);
        Exercise exercise3 = new Exercise(134L, "running", LocalDateTime.of(2020, 12, 3,3,30), LocalDateTime.of(2020, 12, 3,3,59), 100);
        ArrayList<Exercise> exercises = new ArrayList<>();

        exercises.add(exercise1);
        exercises.add(exercise2);
        exercises.add(exercise3);
        return exercises;
    }
}
