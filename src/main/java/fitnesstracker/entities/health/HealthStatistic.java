package fitnesstracker.entities.health;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

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
    private double calorieOut;
    private double heartRate;
    private double stress;

    @Column(name = "person_id")
    private Long personId;
    public Long getPersonId() {
        return personId;
    }

    // constructors
    public HealthStatistic() {
    }

    public HealthStatistic(LocalDate date, double sleep, double weight, double bloodPressure, double hydration, int calorieIn, double calorieOut, double heartRate, double stress, Long personId) {
        this.date = LocalDate.now();
        this.sleep = sleep;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.hydration = hydration;
        this.calorieIn = calorieIn;
        this.calorieOut = calorieOut;
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

    public double getCalorieOut() {
        return calorieOut;
    }

    public void setCalorieOut(double calorieOut) {
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
}
