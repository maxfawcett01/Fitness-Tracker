package fitnesstracker.entities.meal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class IngredientTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Ingredient#Ingredient()}
     *   <li>{@link Ingredient#setIngredientName(String)}
     *   <li>{@link Ingredient#getId()}
     *   <li>{@link Ingredient#getIngredientName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        Ingredient actualIngredient = new Ingredient();
        actualIngredient.setIngredientName("Ingredient Name");

        // Assert
        assertNull(actualIngredient.getId());
        assertEquals("Ingredient Name", actualIngredient.getIngredientName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Ingredient#Ingredient(Meal, String)}
     *   <li>{@link Ingredient#setIngredientName(String)}
     *   <li>{@link Ingredient#getId()}
     *   <li>{@link Ingredient#getIngredientName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        // Arrange and Act
        Ingredient actualIngredient = new Ingredient(new Meal(), "Ingredient Name");
        actualIngredient.setIngredientName("Ingredient Name");

        // Assert
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

