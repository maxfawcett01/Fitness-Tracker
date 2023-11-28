package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class NoDistanceCardioExercise extends CardioExercise {
    public NoDistanceCardioExercise(Person person, String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        super(person, exerciseName, startTime, endTime);
    }

    public NoDistanceCardioExercise() {}
}
