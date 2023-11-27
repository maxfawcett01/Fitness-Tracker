package fitnesstracker.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Meal {

    public Meal(String mealName, String mealType, Integer calories, String cookingInstructions, List<Ingredient> ingredientList) {
        this.mealName = mealName;
        this.mealType = mealType;
        this.calories = calories;
        this.cookingInstructions = cookingInstructions;
        this.ingredientList = ingredientList;
    }

    public Meal() {
    }

    @Id
    @GeneratedValue
    Long id;
    public Long getId() {return id;}

    String mealName;
    public String getMealName() {
        return mealName;
    }
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    String mealType;
    public String getMealType() {
        return mealType;
    }
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    Integer calories;
    public Integer getCalories() {
        return calories;
    }
    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    String cookingInstructions;
    public String getCookingInstructions() {
        return cookingInstructions;
    }
    public void setCookingInstructions(String cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
    List<Ingredient> ingredientList;
    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }
    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
