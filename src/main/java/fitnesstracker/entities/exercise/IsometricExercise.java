package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class IsometricExercise extends Exercise {

    String targetMuscle;
    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public IsometricExercise(Person person, String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        super(person, exerciseName, startTime, endTime);
    }

    public IsometricExercise() {}
}
