package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.MappedSuperclass;

import java.time.Duration;
import java.time.LocalDateTime;


@MappedSuperclass
public class CardioExercise extends Exercise {

    public CardioExercise(Person person, String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        super(person, exerciseName, startTime, endTime);
    }

    public CardioExercise() {}
}
