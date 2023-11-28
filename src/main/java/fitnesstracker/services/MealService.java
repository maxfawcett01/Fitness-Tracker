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
        return this.mealRepository.findAll();
    }

    public  Meal getMealById(long mealId) {
        Optional<Meal> meal = this.mealRepository.findById(mealId);
        return meal.orElse(null);
    }

    public Meal saveMeal(Meal meal) {
        return this.mealRepository.save(meal);
    }
}
