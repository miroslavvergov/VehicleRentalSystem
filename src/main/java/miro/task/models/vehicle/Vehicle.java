package miro.task.models.vehicle;

import lombok.Getter;

/**
 * Abstract class representing a generic vehicle in the rental system.
 * Defines common properties and methods that specific vehicle types will inherit and implement.
 * Promotes polymorphism
 */
@Getter
public abstract class Vehicle {

    /**
     * fields are protected to allow direct access in subclasses while still restricting
     * access from outside the package and unrelated classes
     */
    protected String brand;
    protected String model;
    protected double value;

    /**
     * Constructs a new Vehicle instance.
     *
     * @param brand The brand of the vehicle.
     * @param model The model of the vehicle.
     * @param value The value of the vehicle.
     */
    public Vehicle(String brand, String model, double value) {
        this.brand = brand;
        this.model = model;
        this.value = value;
    }
}
