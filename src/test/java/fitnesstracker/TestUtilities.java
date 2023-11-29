package fitnesstracker;

import fitnesstracker.entities.meal.Ingredient;
import fitnesstracker.entities.meal.Meal;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TestUtilities {
    public static @NotNull ArrayList<Meal> getMealList() {
        ArrayList<Meal> meals = new ArrayList<>();
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

        meals.add(meal1);
        meals.add(meal2);
        meals.add(meal3);
        return meals;
    }
}
