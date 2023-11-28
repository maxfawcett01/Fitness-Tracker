package fitnesstracker.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fitnesstracker.entities.meal.Meal;
import org.hibernate.collection.spi.PersistentBag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
class MealServiceTest {
    @Autowired
    private MealService mealService;

    /**
     * Method under test: {@link MealService#findAll()}
     */
    @Test
    void testFindAll() {
        // Arrange, Act and Assert
        assertEquals(6, mealService.findAll().size());
    }

    /**
     * Method under test: {@link MealService#getMealById(long)}
     */
    @Test
    void testGetMealById() {
        // Arrange and Act
        Meal actualMealById = mealService.getMealById(1L);

        // Assert
        assertEquals(500, actualMealById.getCalories().intValue());
        assertEquals("Lunch", actualMealById.getMealType());
        assertEquals("Chicken Stir Fry", actualMealById.getMealName());
        assertTrue(actualMealById.getIngredientList() instanceof PersistentBag);
        assertEquals("Stir-fry chicken with vegetables and soy sauce", actualMealById.getCookingInstructions());
        assertEquals(6, mealService.findAll().size());
    }

    /**
     * Method under test: {@link MealService#saveMeal(Meal)}
     */
    @Test
    void testSaveMeal() {
        // Arrange
        Meal meal = new Meal();

        // Act and Assert
        assertSame(meal, mealService.saveMeal(meal));
    }

    /**
     * Method under test: {@link MealService#saveMeal(Meal)}
     */
    @Test
    void testSaveMeal2() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> mealService.saveMeal(null));
    }
}

