package miro.task.models.vehicle.impl;

import miro.task.models.vehicle.Vehicle;

/**
 * Represents a cargo van available for rental.
 * Extends the Vehicle class to provide specific implementation for cargo vans.
 */
public class CargoVan extends Vehicle {

    /**
     * Constructs a new CargoVan instance.
     *
     * @param brand The brand of the cargo van.
     * @param model The model of the cargo van.
     * @param value The value of the cargo van.
     */
    public CargoVan(String brand, String model, double value) {
        super(brand, model, value);
    }


}
