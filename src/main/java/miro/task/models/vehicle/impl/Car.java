package miro.task.models.vehicle.impl;

import lombok.Getter;
import miro.task.models.vehicle.Vehicle;

/**
 * Represents a car available for rental.
 * Extends the Vehicle class to provide specific implementation for cars.
 */
@Getter
public class Car extends Vehicle {

    // Safety rating of the car, on a scale of 1 to 5.
    private int safetyRating;

    /**
     * Constructs a new Car instance.
     *
     * @param brand        The brand of the car.
     * @param model        The model of the car.
     * @param value        The value of the car.
     * @param safetyRating The safety rating of the car, on a scale of 1 to 5.
     */
    public Car(String brand, String model, double value, int safetyRating) {
        super(brand, model, value);
        this.safetyRating = safetyRating;
    }

}
