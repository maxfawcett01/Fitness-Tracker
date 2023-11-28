package fitnesstracker.controllers;

import fitnesstracker.entities.meal.Meal;
import fitnesstracker.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @Autowired
    public void setMealService(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public List<Meal> getAllMeals() {
        List<Meal> meals = mealService.findAll();
        meals.forEach(meal -> {
            System.out.println("Meal: " + meal.getMealName());
            System.out.println("Ingredients: " + meal.getIngredientList());
        });
        return meals;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Meal addMeal(@RequestBody Meal meal) {
        Meal newMeal;

        try {
            newMeal = this.mealService.saveMeal(meal);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return newMeal;
    }

    @GetMapping("/{mealId}")
    public Meal getMealById(@PathVariable Long mealId) {
        Meal meal = mealService.getMealById(mealId);
        if(meal == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meal not found");
        return meal;
    }
}
