package fitnesstracker.comparators;

import fitnesstracker.entities.exercise.Exercise;

import java.time.Duration;
import java.util.Comparator;

public class SortByDuration implements Comparator<Exercise> {

    @Override
    public int compare(Exercise a, Exercise b) {
        return a.getDuration().compareTo(b.getDuration());
    }
}
