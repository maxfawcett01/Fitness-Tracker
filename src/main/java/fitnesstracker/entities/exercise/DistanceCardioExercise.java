package fitnesstracker.entities.exercise;

import fitnesstracker.comparators.SortByDistance;
import fitnesstracker.entities.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class DistanceCardioExercise extends CardioExercise {

    double distanceInKm;

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public DistanceCardioExercise(Person person, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, double distanceInKm) {
        super(person, exerciseName, startTime, endTime);
        this.distanceInKm = distanceInKm;
    }

    public DistanceCardioExercise() {}
}
