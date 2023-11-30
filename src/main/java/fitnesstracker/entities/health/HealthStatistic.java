package fitnesstracker.entities.health;

import fitnesstracker.entities.exercise.Exercise;
import fitnesstracker.entities.meal.Meal;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("unused")
@Entity
public class HealthStatistic {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;
    private double sleep;
    private double weight;
    private double bloodPressure;
    private double hydration;
    private int calorieIn;
    private int calorieOut;
    private double heartRate;
    private double stress;

    @Column(name = "person_id")
    private Long personId;

    public Long getPersonId() {
        return personId;
    }

    @Transient
    private int calculatedCalorieIn;
    public int getCalculatedCalorieOut() {
        return calculatedCalorieOut;
    }

    @Transient
    private int calculatedCalorieOut;
    public int getCalculatedCalorieIn() {
        return calculatedCalorieIn;
    }

    // constructors
    public HealthStatistic() {
    }

    @Autowired
    public HealthStatistic(LocalDate date, double sleep, double weight, double bloodPressure, double hydration, int calorieIn, int calorieOut, double heartRate, double stress, Long personId) {
        this.date = LocalDate.now();
        this.sleep = sleep;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.hydration = hydration;
        this.calorieIn = getCalculatedCalorieIn();
        this.calorieOut = getCalculatedCalorieOut();
        this.heartRate = heartRate;
        this.stress = stress;
        this.personId = personId;
    }

    // getters, and setters
    public Long getId() {
        return id;
    }

    public double getSleep() {
        return sleep;
    }

    public void setSleep(double sleep) {
        this.sleep = sleep;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getHydration() {
        return hydration;
    }

    public void setHydration(double hydration) {
        this.hydration = hydration;
    }

    public int getCalorieIn() {
        return calorieIn;
    }

    public void setCalorieIn(int calorieIn) {
        this.calorieIn = calorieIn;
    }

    public int getCalorieOut() {
        return calorieOut;
    }

    public void setCalorieOut(int calorieOut) {
        this.calorieOut = calorieOut;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public double getStress() {
        return stress;
    }

    public void setStress(double stress) {
        this.stress = stress;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int calculateCalorieOutFromExercise(List<Exercise> exercises) {
        calculatedCalorieOut = 0;
        for (Exercise exercise : exercises) {
            if (exercise.getEndTime().toLocalDate().equals(getDate())) {
                calculatedCalorieOut += exercise.getCaloriesBurned();
            }
        }
        return calculatedCalorieOut;
    }

    public int calculateCalorieInFromMeals(List<Meal> meals) {
        if (meals != null) {
            calculatedCalorieIn = meals.stream().mapToInt(Meal::getCalories).sum();
        }
        return calculatedCalorieIn;
    }
}

