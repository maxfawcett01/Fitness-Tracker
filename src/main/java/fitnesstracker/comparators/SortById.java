package fitnesstracker.comparators;

import fitnesstracker.entities.exercise.Exercise;

import java.util.Comparator;

import static java.lang.Long.signum;

public class SortById implements Comparator<Exercise> {

    @Override
    public int compare(Exercise a, Exercise b) {
        return signum(a.getId()-b.getId());
    }
}
