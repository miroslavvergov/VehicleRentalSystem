package miro.task.model.vehicle.impl;

import miro.task.model.vehicle.Vehicle;

/**
 * Represents a motorcycle available for rental.
 * Extends the Vehicle class to provide specific implementation for motorcycles.
 */
public class Motorcycle extends Vehicle {


    /**
     * Constructs a new Motorcycle instance.
     *
     * @param brand The brand of the motorcycle.
     * @param model The model of the motorcycle.
     * @param value The value of the motorcycle.
     */
    public Motorcycle(String brand, String model, double value) {
        super(brand, model, value);

    }


}
