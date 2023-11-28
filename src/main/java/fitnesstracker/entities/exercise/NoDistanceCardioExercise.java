package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class NoDistanceCardioExercise extends CardioExercise {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Person person;
    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public NoDistanceCardioExercise(Person user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        super(exerciseName, startTime, endTime);
        this.person = user;
    }

    public NoDistanceCardioExercise() {}
}
