package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class WeightLiftingExercise extends StrengthTrainingExercise {

    private double weightInKg;

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public WeightLiftingExercise(Person person, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, int sets, int reps, double weightInKg) {
        super(person, exerciseName, startTime, endTime, sets, reps);
        this.weightInKg = weightInKg;
    }

    public WeightLiftingExercise() {}
}
