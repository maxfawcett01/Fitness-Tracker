package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class DistanceCardioExercise extends CardioExercise {


    @ManyToOne
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public DistanceCardioExercise(Person person, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, double distanceInKm) {
        super(person, exerciseName, startTime, endTime);
    }

    public DistanceCardioExercise() {}
}
