package miro.task.utils.collectors.impl;

import miro.task.models.vehicle.Vehicle;
import miro.task.models.vehicle.impl.Car;
import miro.task.models.vehicle.impl.CargoVan;
import miro.task.models.vehicle.impl.Motorcycle;
import miro.task.utils.collectors.DataCollector;

import java.util.Scanner;

/**
 * Class responsible for collecting vehicle data from the console.
 */
public class VehicleDataCollector implements DataCollector<Vehicle> {

    private final Scanner scanner;

    public VehicleDataCollector(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Vehicle collect() {
        System.out.println("Enter vehicle type (car, motorcycle, cargo van):");
        String vehicleType = scanner.nextLine().toLowerCase();

        System.out.println("Enter vehicle brand:");
        String vehicleBrand = scanner.nextLine();

        System.out.println("Enter vehicle model:");
        String vehicleModel = scanner.nextLine();

        System.out.println("Enter vehicle value:");
        double vehicleValue = Double.parseDouble(scanner.nextLine());

        // Create the appropriate Vehicle object based on the vehicle type
        switch (vehicleType) {
            case "car":
                System.out.println("Enter car safety rating (1-5):");
                int safetyRating = Integer.parseInt(scanner.nextLine());
                return new Car(vehicleBrand, vehicleModel, vehicleValue, safetyRating);
            case "motorcycle":
                return new Motorcycle(vehicleBrand, vehicleModel, vehicleValue); // Rider age not needed here
            case "cargo van":
                return new CargoVan(vehicleBrand, vehicleModel, vehicleValue); // Driver experience not needed here
            default:
                System.out.println("Invalid vehicle type.");
                System.exit(1); // Exit if an invalid vehicle type is provided
                return null; // Unreachable, added to satisfy the compiler
        }
    }
}
