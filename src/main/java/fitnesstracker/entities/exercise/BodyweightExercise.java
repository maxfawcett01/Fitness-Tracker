package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class BodyweightExercise extends StrengthTrainingExercise {

    @ManyToOne
    private Person person;


    public Person getPerson() {
        return person;
    }

    public BodyweightExercise(Person person, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, int sets, int reps) {
        super(person, exerciseName, startTime, endTime, sets, reps);
    }
}
