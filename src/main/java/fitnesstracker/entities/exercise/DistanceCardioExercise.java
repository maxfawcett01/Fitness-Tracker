package fitnesstracker.entities.exercise;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class DistanceCardioExercise extends CardioExercise {

    private double distanceInKm;

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }
    public DistanceCardioExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned, double distanceInKm) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned);
        this.distanceInKm = distanceInKm;
    }

    public DistanceCardioExercise() {}
}
