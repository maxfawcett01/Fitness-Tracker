package fitnesstracker.entities.exercise;

import fitnesstracker.entities.User;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
public class NoDistanceCardioExercise extends CardioExercise {

    @Autowired
    public NoDistanceCardioExercise(User user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        super(user, exerciseName, startTime, endTime);
    }
}
