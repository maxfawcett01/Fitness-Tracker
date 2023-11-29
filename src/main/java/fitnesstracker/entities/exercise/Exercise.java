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

    protected String name;

    protected String equipmentRequired;

    protected LocalDateTime startTime;

    protected LocalDateTime endTime;

    protected String description;


    public Person getPerson() {
        return person;
    }

    @ManyToOne
    private Person person;
    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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

    public Exercise(Person person, String name, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.person = person;
    }

    public Exercise() {}

    public Long getId() {
        return id;
    }
}
