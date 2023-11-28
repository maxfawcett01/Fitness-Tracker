package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class BodyweightExercise extends StrengthTrainingExercise {

    @ManyToOne
    private final Person person;


    public Person getPerson() {
        return person;
    }

    public BodyweightExercise(Person user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, int sets, int reps) {
        super(exerciseName, startTime, endTime, sets, reps);
        this.person = user;
    }
}
