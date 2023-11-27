package fitnesstracker.entities.exercise;

import fitnesstracker.entities.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class Exercise {

    @Id
    @GeneratedValue
    private Long id;
    public Long getId() {
        return id;
    }

    @ManyToOne
    private final User user;

    private String exerciseName;

    private String equipmentRequired;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String description;

    public User getUser() {
        return user;
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

    public String getDescription() {
        return description;
    }

    public Duration getDuration() {
        return Duration.between(startTime, endTime);
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

    @Autowired
    public Exercise(User user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        this.user = user;
        this.exerciseName = exerciseName;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
