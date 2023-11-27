package fitnesstracker.entities;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
public class IsometricExercise extends Exercise{

    String targetMuscle;

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    @Autowired
    public IsometricExercise(User user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        super(user, exerciseName, startTime, endTime);
    }
}
