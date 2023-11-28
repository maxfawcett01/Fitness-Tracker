package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class DistanceCardioExercise extends CardioExercise {


    public DistanceCardioExercise(Person person, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, double distanceInKm) {
        super(person, exerciseName, startTime, endTime);
    }

    public DistanceCardioExercise() {}
}
