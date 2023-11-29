package fitnesstracker.entities.exercise;

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
    protected Integer caloriesBurned;
    protected String description;

    @Column(name = "person_id")
    private Long personId;

    //constructors
    public Exercise() {}
    public Exercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned) {
        this.exerciseName = exerciseName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.personId = personId;
        this.caloriesBurned = caloriesBurned;
    }

    //getters
    public Long getId() {
        return id;
    }
    public Long getPersonId() {
        return personId;
    }
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
    public Integer getCaloriesBurned() {
        return caloriesBurned;
    }
    public String getDescription() {
        return description;
    }

    //setters
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
    public void setCaloriesBurned(Integer caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
