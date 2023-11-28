package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class WeightLiftingExercise extends StrengthTrainingExercise {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Person person;

    private double weightInKg;
    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public WeightLiftingExercise(Person user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, int sets, int reps, double weightInKg) {
        super(exerciseName, startTime, endTime, sets, reps);
        this.weightInKg = weightInKg;
        this.person = user;
    }

    public WeightLiftingExercise() {}
}
