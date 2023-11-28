package fitnesstracker.entities.meal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingredient {

    public Ingredient() {
    }

    public Ingredient(Meal meal, String ingredientName) {
        this.meal = meal;
        this.ingredientName = ingredientName;
    }

    @Id
    @GeneratedValue
    Long id;
    public Long getId() {return id;}

    @ManyToOne
    Meal meal;

    String ingredientName;
    public String getIngredientName() {
        return ingredientName;
    }
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
