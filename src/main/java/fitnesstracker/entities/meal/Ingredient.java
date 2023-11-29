package fitnesstracker.entities.meal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
@Schema(description = "Ingredient Information")
public class Ingredient {

    public Ingredient() {
    }

    public Ingredient(Meal meal, String ingredientName) {
        this.meal = meal;
        this.ingredientName = ingredientName;
    }

    @Id
    @GeneratedValue
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Ingredient ID", example = "1")
    Long id;
    public Long getId() {
        return id;
    }

    @ManyToOne
    @Schema(description = "Meal associated with the Ingredient")
    Meal meal;

    @Schema(description = "Name of the Ingredient", example = "Banana")
    String ingredientName;
    public String getIngredientName() {
        return ingredientName;
    }
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
