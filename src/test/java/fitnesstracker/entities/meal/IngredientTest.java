package fitnesstracker.entities.meal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class IngredientTest {

    @Test
    void testConstructor() {
        Ingredient actualIngredient = new Ingredient();
        actualIngredient.setIngredientName("Ingredient Name");

        assertNull(actualIngredient.getId());
        assertEquals("Ingredient Name", actualIngredient.getIngredientName());
    }

    @Test
    void testConstructor2() {
        Ingredient actualIngredient = new Ingredient(new Meal(), "Ingredient Name");
        actualIngredient.setIngredientName("Ingredient Name");

        assertNull(actualIngredient.getId());
        assertEquals("Ingredient Name", actualIngredient.getIngredientName());
        Meal meal = actualIngredient.meal;
        assertNull(meal.getMealType());
        assertNull(meal.getMealName());
        assertNull(meal.getIngredientList());
        assertNull(meal.getId());
        assertNull(meal.getCookingInstructions());
        assertNull(meal.getCalories());
    }
}

