package fitnesstracker.entities.exercise;

import java.time.LocalDateTime;

public abstract class Exercise {

    protected String exerciseName;

    protected String equipmentRequired;

    protected LocalDateTime startTime;

    protected LocalDateTime endTime;

    protected String description;

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

    public Exercise(String exerciseName, LocalDateTime startTime, LocalDateTime endTime) {
        this.exerciseName = exerciseName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Exercise() {}
}
