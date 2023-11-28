package fitnesstracker.services;

import fitnesstracker.entities.meal.Meal;
import fitnesstracker.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    MealRepository mealRepository;

    public List<Meal> findAll() {
        try {
            List<Meal> meals = this.mealRepository.findAll();
            System.out.println(meals);
            return this.mealRepository.findAll();
        } catch (Exception e) {
            // Log the exception or handle it according to your application's needs
            e.printStackTrace();
            throw new RuntimeException("An error occurred while fetching meals", e);
        }
    }

    public  Meal getMealById(long mealId) {
        Optional<Meal> meal = this.mealRepository.findById(mealId);
        return meal.orElse(null);
    }

    public Meal saveMeal(Meal meal) {
        if (meal == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }

        return this.mealRepository.save(meal);
    }


}
