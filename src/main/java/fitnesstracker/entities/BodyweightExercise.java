package fitnesstracker.entities;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
public class BodyweightExercise extends WeightExercise{

    @Autowired
    public BodyweightExercise(User user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, int sets, int reps) {
        super(user, exerciseName, startTime, endTime, sets, reps);
    }
}
