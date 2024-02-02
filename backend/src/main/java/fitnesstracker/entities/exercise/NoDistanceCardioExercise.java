package fitnesstracker.entities.exercise;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("No distance cardio exercise")
public class NoDistanceCardioExercise extends CardioExercise {
    public NoDistanceCardioExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned);
    }

    public NoDistanceCardioExercise() {}
    @Override
    public String getExerciseType(){
        return "No Distance Cardio Exercise";
    }
}
