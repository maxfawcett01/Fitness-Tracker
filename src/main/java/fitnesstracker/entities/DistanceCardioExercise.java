package fitnesstracker.entities;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
public class DistanceCardioExercise extends CardioExercise{

    private double distanceInKm;

    @Autowired
    public DistanceCardioExercise(User user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, double distanceInKm) {
        super(user, exerciseName, startTime, endTime);
        this.distanceInKm = distanceInKm;
    }
}
