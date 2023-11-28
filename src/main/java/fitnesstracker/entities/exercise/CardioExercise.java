package fitnesstracker.entities.exercise;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class CardioExercise extends Exercise {

    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }

    public CardioExercise(String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        super(exerciseName, startTime, endTime);
    }

    public CardioExercise() {}
}
