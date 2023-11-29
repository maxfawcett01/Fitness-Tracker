package fitnesstracker.entities.exercise;

import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class StrengthTrainingExercise extends Exercise {

    protected int sets;

    protected int reps;

    protected String targetMuscle;

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    public StrengthTrainingExercise(Long personId, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, Integer caloriesBurned, int sets, int reps) {
        super(personId, exerciseName, startTime, endTime, caloriesBurned);
        this.sets = sets;
        this.reps = reps;
    }

    public StrengthTrainingExercise() {}
}
