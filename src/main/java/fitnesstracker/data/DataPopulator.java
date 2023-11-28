package fitnesstracker.data;

import fitnesstracker.entities.health.HealthStatistic;
import fitnesstracker.entities.meal.Ingredient;
import fitnesstracker.entities.meal.Meal;
import fitnesstracker.services.HealthStatisticService;
import fitnesstracker.services.MealService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class DataPopulator {

    private final MealService mealService;
    private final HealthStatisticService healthStatisticService;

    @Autowired
    public DataPopulator(MealService mealService, HealthStatisticService healthStatisticService) {
        this.mealService = mealService;
        this.healthStatisticService = healthStatisticService;
    }

    @EventListener(ContextRefreshedEvent.class)
    @PostConstruct
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

//        ******************************************************
        LocalDate date = null;
        HealthStatistic healthStatistic1 = new HealthStatistic( date, 23.0,60.0, 80.0, 90.0,480.0, 620.0, 65.0, 10.0);
        healthStatisticService.createHealthStatistic(healthStatistic1);
    }
}
