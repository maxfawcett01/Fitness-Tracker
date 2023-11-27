package fitnesstracker.entities;

import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class CardioExercise extends Exercise{

    @Autowired
    public CardioExercise(User user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        super(user, exerciseName, startTime, endTime);
    }
}
