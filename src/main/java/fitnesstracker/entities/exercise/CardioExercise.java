package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;

import java.time.Duration;
import java.time.LocalDateTime;


public class CardioExercise extends Exercise {

    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }

    public CardioExercise(Person person, String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        super(person, exerciseName, startTime, endTime);
    }

    public CardioExercise() {}
}
