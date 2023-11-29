package fitnesstracker.services;

import fitnesstracker.entities.meal.Ingredient;
import fitnesstracker.entities.meal.Meal;
import fitnesstracker.repositories.MealRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MealServiceTest {

    @Autowired
    private MealService mealService;

    @Test
    void testFindAll() {
        assertTrue(mealService.findAll().isEmpty());
    }

    @Test
    @Transactional
    void testSaveMeal() {
        Meal meal = new Meal();

        assertSame(meal, mealService.saveMeal(meal));
    }

    @Test
    void testSaveMeal2() {
        assertThrows(IllegalArgumentException.class, () -> mealService.saveMeal(null));
    }

    @Test
    @Transactional
    void testSaveMeal3() {
        Meal meal = new Meal();
        meal.setMealName("Meal Name");

        assertSame(meal, mealService.saveMeal(meal));
    }

    @Test
    void testGetMealById() {
        MealRepository mockMealRepo = mock(MealRepository.class);
        mealService = new MealService(mockMealRepo);

        Meal meal = new Meal("Chicken Stir Fry", "Lunch", 500, "Stir-fry chicken with vegetables and soy sauce", new ArrayList<>());
        meal.getIngredientList().add(new Ingredient(meal, "Chicken"));
        meal.getIngredientList().add(new Ingredient(meal, "Vegetables"));
        meal.getIngredientList().add(new Ingredient(meal, "Soy Sauce"));

        when(mockMealRepo.findById(any())).thenReturn(Optional.of(meal));
        Meal actual = mealService.getMealById(1L);

        assertEquals(meal.getMealName(), actual.getMealName());
    }
}

