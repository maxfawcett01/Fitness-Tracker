package fitnesstracker.entities.health;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
@Entity
public class HealthStatistic {

    @Id
    @GeneratedValue
    private Long id;
    public Long getId() {
        return id;
    }

    private LocalDate date;
    private double sleep;
    private double weight;
    private double bloodPressure;
    private double hydration;
    private double calorieIn;
    private double calorieOut;
    private double heartRate;
    private double stress;


    // Map to store dynamic health parameters
    @ElementCollection
    private Map<String, String> parameters = new HashMap<>();

    // constructors
    public HealthStatistic() {
    }

       public HealthStatistic(LocalDate date, double sleep, double weight, double bloodPressure, double hydration, double calorieIn, double calorieOut, double heartRate, double stress) {
        this.date = LocalDate.now();
        this.sleep = sleep;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.hydration = hydration;
        this.calorieIn = calorieIn;
        this.calorieOut = calorieOut;
        this.heartRate = heartRate;
        this.stress = stress;
    }

    // getters, and setters
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

    public double getCalorieIn() {
        return calorieIn;
    }

    public void setCalorieIn(double calorieIn) {
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

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
