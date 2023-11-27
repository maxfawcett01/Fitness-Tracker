package fitnesstracker.entities.exercise;

import fitnesstracker.entities.User;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class WeightExercise extends Exercise {

    private int sets;

    private int reps;

    private String targetMuscle;

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

    @Autowired
    public WeightExercise(User user, String exerciseName, LocalDateTime startTime, LocalDateTime endTime, int sets, int reps) {
        super(user, exerciseName, startTime, endTime);
        this.sets = sets;
        this.reps = reps;
    }
}
