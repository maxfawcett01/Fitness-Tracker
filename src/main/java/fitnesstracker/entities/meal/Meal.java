package fitnesstracker.entities.meal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Schema(description = "Meal Information")
public class Meal {

    public Meal(LocalDate mealDate, String mealName, String mealType, Integer calories, String cookingInstructions, List<Ingredient> ingredientList, Long personId) {
        this.mealDate = mealDate != null ? mealDate : LocalDate.now();
        this.mealName = mealName;
        this.mealType = mealType;
        this.calories = calories;
        this.cookingInstructions = cookingInstructions;
        this.ingredientList = ingredientList;
        this.personId = personId;
    }

    public Meal() {
    }

    @Id
    @GeneratedValue
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Meal ID", example = "1")
    Long id;
    public Long getId() {
        return id;
    }

    @Schema(description = "Date of the Meal", example = "2020-01-01")
    private LocalDate mealDate;
    public LocalDate getMealDate() {
        return mealDate;
    }
    public void setMealDate(LocalDate date) {
        this.mealDate = date;
    }

    @Schema(description = "Name of the Meal", example = "Beans on Toast")
    String mealName;
    public String getMealName() {
        return mealName;
    }
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    @Schema(description = "Type of the Meal", example = "Breakfast")
    String mealType;
    public String getMealType() {
        return mealType;
    }
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    @Schema(description = "Calories of the Meal", example = "1000")
    Integer calories;
    public Integer getCalories() {
        return calories;
    }
    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Schema(description = "Cooking instructions for the Meal", example = "Bake 100g of beans, put toast in toaster")
    String cookingInstructions;
    public String getCookingInstructions() {
        return cookingInstructions;
    }
    public void setCookingInstructions(String cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Ingredient> ingredientList;
    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Column(name = "person_id")
    private Long personId;
    public Long getPersonId() {
        return personId;
    }
}

