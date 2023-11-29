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

    @GetMapping
    public List<Meal> getAllMeals() {
        try {
            List<Meal> meals = mealService.findAll();
            meals.forEach(meal -> {
                System.out.println("Meal: " + meal.getMealName());
                System.out.println("Ingredients: " + meal.getIngredientList());
            });
            return mealService.findAll();
        } catch (Exception e) {
            // Log the exception or handle it according to your application's needs
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while fetching meals", e);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Meal addMeal(@RequestBody Meal meal) {
        Meal newMeal;
        meal.getPersonId();

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

    @Autowired
    public void setMealService(MealService mealService) {
        this.mealService = mealService;
    }
}
