package fitnesstracker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingredient {

    public Ingredient(Meal meal) {
        this.meal = meal;
    }

    @Id
    @GeneratedValue
    Long id;
    public Long getId() {return id;}

    @ManyToOne
    Meal meal;
}
