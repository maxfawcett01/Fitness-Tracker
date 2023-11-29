package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.MappedSuperclass;

import java.time.Duration;
import java.time.LocalDateTime;


@MappedSuperclass
public class CardioExercise extends Exercise {

    public CardioExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned);
    }

    public CardioExercise() {}
}
