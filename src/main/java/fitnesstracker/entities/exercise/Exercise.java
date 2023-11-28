package fitnesstracker.entities.exercise;

import fitnesstracker.entities.Person;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Exercise {

    @Id
    @GeneratedValue
    private Long id;

    protected String exerciseName;

    protected String equipmentRequired;

    protected LocalDateTime startTime;

    protected LocalDateTime endTime;

    protected String description;


    @ManyToOne
    private Person person;

    public String getExerciseName() {
        return exerciseName;
    }

    public String getEquipmentRequired() {
        return equipmentRequired;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setEquipmentRequired(String equipmentRequired) {
        this.equipmentRequired = equipmentRequired;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Exercise(Person person, String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        this.exerciseName = exerciseName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.person = person;
    }

    public Exercise() {}

    public Long getId() {
        return id;
    }
}
