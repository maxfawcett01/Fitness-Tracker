package fitnesstracker.entities.exercise;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("BODYWEIGHT")
public class BodyweightExercise extends StrengthTrainingExercise {

    public BodyweightExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned, int sets, int reps) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned, sets, reps);
    }

    public BodyweightExercise() {}
}
