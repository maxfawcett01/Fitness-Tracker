package fitnesstracker.entities;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
public class WeightLiftingExercise extends WeightExercise{

    private double weightInKg;

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }

    @Autowired
    public WeightLiftingExercise(User user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, int sets, int reps, double weightInKg) {
        super(user, exerciseName, startTime, endTime, sets, reps);
        this.weightInKg = weightInKg;
    }
}
