package fitnesstracker.entities.exercise;

import java.time.LocalDateTime;

public abstract class StrengthTrainingExercise extends Exercise {

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

    public StrengthTrainingExercise(String exerciseName, LocalDateTime startTime, LocalDateTime endTime, int sets, int reps) {
        super(exerciseName, startTime, endTime);
        this.sets = sets;
        this.reps = reps;
    }

    public StrengthTrainingExercise() {}
}
