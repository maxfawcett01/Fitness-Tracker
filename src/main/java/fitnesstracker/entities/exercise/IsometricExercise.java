package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class IsometricExercise extends Exercise {

    @ManyToOne
    private Person person;

    String targetMuscle;

    public Person getPerson() {
        return person;
    }

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public IsometricExercise(Person user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        super(exerciseName, startTime, endTime);
        this.person = user;
    }

    public IsometricExercise() {}
}
