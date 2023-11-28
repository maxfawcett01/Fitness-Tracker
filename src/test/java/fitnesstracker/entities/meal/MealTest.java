package fitnesstracker.entities.meal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MealTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Meal#Meal()}
     *   <li>{@link Meal#setCalories(Integer)}
     *   <li>{@link Meal#setCookingInstructions(String)}
     *   <li>{@link Meal#setIngredientList(List)}
     *   <li>{@link Meal#setMealName(String)}
     *   <li>{@link Meal#setMealType(String)}
     *   <li>{@link Meal#getCalories()}
     *   <li>{@link Meal#getCookingInstructions()}
     *   <li>{@link Meal#getId()}
     *   <li>{@link Meal#getIngredientList()}
     *   <li>{@link Meal#getMealName()}
     *   <li>{@link Meal#getMealType()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        Meal actualMeal = new Meal();
        actualMeal.setCalories(1);
        actualMeal.setCookingInstructions("Cooking Instructions");
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        actualMeal.setIngredientList(ingredientList);
        actualMeal.setMealName("Meal Name");
        actualMeal.setMealType("Meal Type");

        // Assert
        assertEquals(1, actualMeal.getCalories().intValue());
        assertEquals("Cooking Instructions", actualMeal.getCookingInstructions());
        assertNull(actualMeal.getId());
        assertSame(ingredientList, actualMeal.getIngredientList());
        assertEquals("Meal Name", actualMeal.getMealName());
        assertEquals("Meal Type", actualMeal.getMealType());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Meal#Meal(String, String, Integer, String, List)}
     *   <li>{@link Meal#setCalories(Integer)}
     *   <li>{@link Meal#setCookingInstructions(String)}
     *   <li>{@link Meal#setIngredientList(List)}
     *   <li>{@link Meal#setMealName(String)}
     *   <li>{@link Meal#setMealType(String)}
     *   <li>{@link Meal#getCalories()}
     *   <li>{@link Meal#getCookingInstructions()}
     *   <li>{@link Meal#getId()}
     *   <li>{@link Meal#getIngredientList()}
     *   <li>{@link Meal#getMealName()}
     *   <li>{@link Meal#getMealType()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        // Arrange
        ArrayList<Ingredient> ingredientList = new ArrayList<>();

        // Act
        Meal actualMeal = new Meal("Meal Name", "Meal Type", 1, "Cooking Instructions", ingredientList);
        actualMeal.setCalories(1);
        actualMeal.setCookingInstructions("Cooking Instructions");
        ArrayList<Ingredient> ingredientList1 = new ArrayList<>();
        actualMeal.setIngredientList(ingredientList1);
        actualMeal.setMealName("Meal Name");
        actualMeal.setMealType("Meal Type");

        // Assert
        assertEquals(1, actualMeal.getCalories().intValue());
        assertEquals("Cooking Instructions", actualMeal.getCookingInstructions());
        assertNull(actualMeal.getId());
        List<Ingredient> ingredientList2 = actualMeal.getIngredientList();
        assertSame(ingredientList1, ingredientList2);
        assertEquals(ingredientList, ingredientList2);
        assertEquals("Meal Name", actualMeal.getMealName());
        assertEquals("Meal Type", actualMeal.getMealType());
    }
}

